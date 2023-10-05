package com.pepper.Rooms.controller;

import com.pepper.Rooms.RoomCore;
import com.pepper.Rooms.model.Model;
import com.pepper.Rooms.model.Sector;
import javafx.scene.control.SpinnerValueFactory;


public class SectorController 
{
    private MainController P;
    private Model model;
    
    public SectorController(MainController parent)
    {
        this.P = parent;
        model = RoomCore.getContext().getBean(Model.class);
        
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1);
        P.getsPermissionSpin().setValueFactory(valueFactory);        
        setSectors();
    }

    public void saveSector() 
    {
        if(!P.getsName().getText().isEmpty())
        {
            String sName = P.getsName().getText().trim();
            int permission = (int) P.getsPermissionSpin().getValue();
            
            model.saveSector(new Sector(sName, permission));            
        }
    }
    
    public void setSectors()
    {
        P.getrSectorCb().getItems().clear();
        P.getrSectorCb().getItems().addAll(model.getSectorIds());
        P.getrSectorCb().getItems().add(0, null);
    }
    
    

}
