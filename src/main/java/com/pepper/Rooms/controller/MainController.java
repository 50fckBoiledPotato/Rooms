package com.pepper.Rooms.controller;

import com.pepper.Rooms.gui.CheckBoxPair;
import com.pepper.Rooms.gui.InputSpin;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import org.springframework.stereotype.Controller;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

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
    private ComboBox rSectorCb, findByCb;
    @FXML
    private CheckBox openChb, closeChb;
    @FXML
    private VBox findPane;
    private CheckBoxPair chbPair;
    private InputSpin InputSpin;
    

    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
        sController = new SectorController(this);
        rController = new RoomController(this);
        
        setupUI();
        rController.updateFindByCb();
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
    
    @FXML
    public void find()
    {
        
    }
    
    ///////////////////////////
    
    
    
    private void setupUI()
    {
        //chbPair = new CheckBoxPair(findPane, "Open", "Closed");
        //InputSpin = new InputSpin(findPane, "Level: ");
        
        openChb.setOnAction(event ->{
            closeChb.setSelected(false); 
            openChb.setSelected(true);            
        });
        closeChb.setOnAction(event -> {
            openChb.setSelected(false);
            closeChb.setSelected(true);            
        });
    }
    
    public void deleteNode(Node node)
    {
        findPane.getChildren().remove(node);
    }
    
    public boolean getIsOpen() 
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

    public ComboBox getFindByCb() {
        return findByCb;
    }

    public CheckBox getOpenChb() {
        return openChb;
    }

    public CheckBox getCloseChb() {
        return closeChb;
    }

    public VBox getFindPane() {
        return findPane;
    }

    
    

    
}
