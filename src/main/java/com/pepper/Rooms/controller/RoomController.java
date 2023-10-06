package com.pepper.Rooms.controller;

import com.pepper.Rooms.RoomCore;
import com.pepper.Rooms.gui.CheckBoxPair;
import com.pepper.Rooms.gui.InputSpin;
import com.pepper.Rooms.gui.Table;
import com.pepper.Rooms.model.Model;
import com.pepper.Rooms.model.Room;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.Pane;


public class RoomController 
{
    private MainController P;
    private Model model;
    private Table table;
    
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
    private CheckBoxPair chbPair;
    private InputSpin spinner;
    
    public void findRoom(String by)
    {
        Pane pane = P.getTableContainer();
        
        
        switch (by)
        {
            case "Open/closed" ->
            {
                if(chbPair.getChb0().isSelected())
                {
                    System.out.println("room Controllerből: open");
                    pane.getChildren().clear();
                    List<Room> rooms = model.findByIsOpen(true);
                    table = new Table(pane, Room.class);
                    table.setItems(rooms);
                }
                else if(chbPair.getChb1().isSelected())
                {
                    System.out.println("room Controllerből: closed");
                    pane.getChildren().clear();
                    List<Room> rooms = model.findByIsOpen(false);
                    table = new Table(pane, Room.class);
                    table.setItems(rooms);
                }
            }
            case "Level" ->
            {
                pane.getChildren().clear();
                int level =(int) spinner.getSpinner().getValue();
                List<Room> rooms = model.findByLevel(level);
                table = new Table(pane, Room.class);
                table.setItems(rooms);
            }
            case "Level not equals" ->
            {
                int level =(int) spinner.getSpinner().getValue();
                List<Room> rooms = model.findbyOutOfLevelCustom(level);
                table = new Table(pane, Room.class);
                table.setItems(rooms);
            }
            case "Sector" ->
            {
                pane.getChildren().clear();
                int level =(int) spinner.getSpinner().getValue();
                List<Room> rooms = model.findBySector(level);
                table = new Table(pane, Room.class);
                table.setItems(rooms);
            }
            case "Permission" ->
            {
                pane.getChildren().clear();
                int level =(int) spinner.getSpinner().getValue();
                List<Room> rooms = model.findRoomsByPermission(level);
                table = new Table(pane, Room.class);
                table.setItems(rooms);
            }
            case "Level and by open/closed" ->
            {
                pane.getChildren().clear();
                int level =(int) spinner.getSpinner().getValue();
                if(chbPair.getChb0().isSelected())
                {
                    List<Room> rooms = model.findRoomsByLevelAndIsOpen(level, true);
                    table = new Table(pane, Room.class);
                    table.setItems(rooms);
                }
                else if(chbPair.getChb1().isSelected())
                {
                   List<Room> rooms = model.findRoomsByLevelAndIsOpen(level, false);
                   table = new Table(pane, Room.class);
                   table.setItems(rooms);
                }
            }
            default ->
            {
                
            }
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
                } else {
                    clearNode();
                }
            }
        });
    }
    
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
