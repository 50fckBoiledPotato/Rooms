package com.pepper.Rooms.controller;

import com.pepper.Rooms.RoomCore;
import com.pepper.Rooms.gui.CheckBoxPair;
import com.pepper.Rooms.gui.InputSpin;
import com.pepper.Rooms.model.Model;
import com.pepper.Rooms.model.Room;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SpinnerValueFactory;


public class RoomController 
{
    private MainController P;
    private Model model;
    
    public RoomController(MainController parent)
    {
        this.P = parent;
        model = RoomCore.getContext().getBean(Model.class);
        
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1);
        P.getrLevel().setValueFactory(valueFactory);
        
        
        
    }

    void saveRoom() 
    {
        if(!P.getrName().getText().isEmpty() && P.getrSectorCb().getValue() != null)
        {
            String name = P.getrName().getText();
            int sector = (int) P.getrSectorCb().getValue();
            int level = (int) P.getrLevel().getValue();
            boolean isOpen = P.getIsOpen();
            
            Room newRoom = new Room(name, sector, level, isOpen);
            model.saveRoom(newRoom);
        }
    }
    
    public void updateFindByCb()
    {
        ComboBox<String> cb = P.getFindByCb();
        List<String> queries = new ArrayList<>();
        queries.add("Open/closed");
        queries.add("Level");
        queries.add("Level not equals");
        queries.add("Sector");
        queries.add("Permission");
        queries.add("Level and by open/closed");
        cb.getItems().add(0, null);
        cb.getItems().addAll(queries);
        
        cb.valueProperty().addListener(new ChangeListener<String>()
        {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue != null)
                {
                    switch (newValue)
                    {
                        case "Open/closed" ->
                        {
                            clearNode();
                            addChbPair();
                        }
                        case "Level" ->
                        {
                            clearNode();
                            addSpinner("Level");
                        }
                        case "Level not equals" ->
                        {
                            clearNode();
                            addSpinner("Level");
                        }
                        case "Sector" ->
                        {
                            clearNode();
                            addSpinner("Sector");
                        }
                        case "Permission" ->
                        {
                            clearNode();
                            addSpinner("Permission");
                        }
                        case "Level and by open/closed" ->
                        {
                            clearNode();
                            addChbPairAndSpinner("Level");
                        }
                        default ->
                        {
                            clearNode();
                        }
                    }
                }
            }
        });
    }
    private CheckBoxPair chbPair;
    private InputSpin spinner;
    public void addChbPair()
    {
        chbPair = new CheckBoxPair(P.getFindPane(), "Open", "Closed");        
    }
    public void addSpinner(String text)
    {
        spinner = new InputSpin(P.getFindPane(), text);
    }
    public void addChbPairAndSpinner(String text)
    {
        spinner = new InputSpin(P.getFindPane(), text);
        spinner.setPrefWidth(110);
        chbPair = new CheckBoxPair(P.getFindPane(), "Open", "Closed"); 
    }
    public void clearNode()
    {
        P.getFindPane().getChildren().clear();
    }
    

}
