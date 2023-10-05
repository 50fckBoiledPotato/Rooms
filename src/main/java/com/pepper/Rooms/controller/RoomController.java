/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.pepper.Rooms.controller;

import com.pepper.Rooms.RoomCore;
import com.pepper.Rooms.model.Model;
import com.pepper.Rooms.model.Room;
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
    
    
    
    

}
