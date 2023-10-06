package com.pepper.Rooms.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import org.w3c.dom.css.RGBColor;


public class CheckBoxPair 
{
    private CheckBox chb0, chb1;
    private HBox container;
    
    public CheckBoxPair(Pane parent, String text0, String text1)
    {
        container = new HBox(6);
        container.setPrefHeight(30);
        container.setAlignment(Pos.BASELINE_RIGHT);
        Insets insets = new Insets(3, 0, 0,0);
        HBox.setMargin(container, new Insets(3, 0, 0,0));
        
        
        
        chb0 = new CheckBox(text0);
        chb1 = new CheckBox(text1);
        chb0.setPadding(insets);
        
        chb0.setOnAction(event ->{
            chb1.setSelected(false); 
            chb0.setSelected(true);            
        });
        chb1.setOnAction(event -> {
            chb0.setSelected(false);
            chb1.setSelected(true);            
        });
        
        container.getChildren().addAll(chb0, chb1);
        parent.getChildren().add(container);
    }

    public void setTextFill(RGBColor color)
    {
        chb0.setTextFill((Paint) color);
        chb1.setTextFill((Paint) color);
    }

    public CheckBox getChb0() {
        return chb0;
    }

    public CheckBox getChb1() {
        return chb1;
    }

    public HBox getContainer() {
        return container;
    }
    
    
}
