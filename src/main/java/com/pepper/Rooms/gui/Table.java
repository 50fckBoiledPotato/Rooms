package com.pepper.Rooms.gui;

import jakarta.persistence.Transient;
import java.lang.reflect.Field;
import java.util.List;
import java.util.function.BiConsumer;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

public class Table<T> extends TableView<T> 
{
    
    public Table(Pane parent, Class<T> entityClass)
    {
        super();
        parent.getChildren().add(this);
        
        Field[] fields = entityClass.getDeclaredFields(); // lekéri az entitás változóit (aminek van gettere
        for (Field field : fields) 
        {       //!field.isSynthetic(): enumok kiszűrése és minden más változó kiszűrése amit nem én declaráltam osztályváltozóként
            if (!field.isSynthetic() && !field.isAnnotationPresent(Transient.class)) 
            {
                field.setAccessible(true); // private változókhoz hozzáférés
                String header = field.getName(); // field név: oszlop cím
                                
                //TableColumn<Income, Integer> idCol = new TableColumn<>("ID");
                TableColumn<T, String> column = new TableColumn<>(header);
                //idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
                column.setCellValueFactory(cellData -> 
                {
                    try 
                    {   // itt derül ki a változók tulajdonsága
                        //Java reflection minden fieldet Object típusként kezel függetlenül a field tulajdonságától(String, int..)
                        //field.get(cellData.getValue()); egy Objectet ad vissza
                        Object value = field.get(cellData.getValue());
                        //azt az esetet kezeli amikor az adatbázisban lehet null értéke egy cellának, akkor egy üres String jelenik meg 'null' helyett
                        return value != null ? new SimpleStringProperty(value.toString()) : new SimpleStringProperty("");
                    }
                    catch (IllegalAccessException e) 
                    {
                        e.printStackTrace();
                        return new SimpleStringProperty("");
                    }
                });                
                column.setMinWidth(USE_PREF_SIZE);
                
                if(field.getType() == Boolean.class || field.getType() == boolean.class)
                {
                   
                }
                
                getColumns().add(column);
            }
        }
    }
    
    public void addActionColumn(String buttonText, BiConsumer<T, Integer> onClick) // gomb hozzáadása
    {
        TableColumn<T, String> column = new TableColumn<>();
        
        Callback<TableColumn<T, String>, TableCell<T, String>> factory;
        factory = new Callback<>() 
        {
            
            @Override
            public TableCell<T, String> call(TableColumn<T, String> param) 
            {
                TableCell<T, String> cell = new TableCell<>()
                {
                    @Override
                    protected void updateItem(String item, boolean empty) 
                    {
                        super.updateItem(item, empty); 

                        if(empty)
                        {
                            setGraphic(null);
                        }
                        else
                        {
                            Button button = new Button(buttonText);
                            button.setOnAction(evt -> 
                            {
                                int index = getIndex();
                                T entity = getTableRow().getItem();

                                onClick.accept(entity, index);
                            });

                            setGraphic(button);
                        }
                        setText(null);
                    }
                };
                return cell;
            }
            
        };
        column.setCellFactory(factory);
        getColumns().add(column);
    }
    
    public void setItems(List<T> items) {
        getItems().clear();
        getItems().setAll(items);
    }
}