package com.pepper.Rooms.controller;

import com.pepper.Rooms.RoomCore;
import com.pepper.Rooms.model.Model;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import org.springframework.stereotype.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

@Controller
public class MainController implements Initializable
{
    
    private SectorController sController;
    private RoomController rController;
    @FXML
    private TextField sName, rName;
    @FXML
    private Spinner sPermissionSpin, rLevelSpin;
    @FXML
    private ComboBox rSectorCb;
    @FXML
    private CheckBox openChb, closeChb;
    

    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
        sController = new SectorController(this);
        rController = new RoomController(this);
        setupUI();
    }
    
    @FXML
    public void saveSector()
    {
        sController.saveSector();
        sController.setSectors();
    }
    
    @FXML
    public void saveRoom()
    {
        rController.saveRoom();
    }
    
    ///////////////////////////
    
    boolean getIsOpen() 
    {
        if(openChb.isSelected())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    private void setupUI()
    {
        openChb.setOnAction(event ->{
            closeChb.setSelected(false); //bal oldali where
            openChb.setSelected(true);
            
        });
        closeChb.setOnAction(event -> {
            openChb.setSelected(false); //jobb oldali where
            closeChb.setSelected(true);
            
        });
    }

    public TextField getsName() {
        return sName;
    }

    public TextField getrName() {
        return rName;
    }

    public Spinner getrLevel() {
        return rLevelSpin;
    }

    public Spinner getsPermissionSpin() {
        return sPermissionSpin;
    }

    public ComboBox getrSectorCb() {
        return rSectorCb;
    }

    public CheckBox getOpenChb() {
        return openChb;
    }

    public CheckBox getCloseChb() {
        return closeChb;
    }

    
    

    
}
