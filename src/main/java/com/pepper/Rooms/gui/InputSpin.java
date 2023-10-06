package com.pepper.Rooms.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import org.w3c.dom.css.RGBColor;


public class InputSpin 
{
    private Label label;
    private Spinner spinner;
    private HBox container;
    private Pane parent;
    
    public InputSpin(Pane parent, String text)
    {
        this.parent = parent;
        container = new HBox(6);
        container.setPrefHeight(25);
        container.setAlignment(Pos.BASELINE_RIGHT);
        Insets insets = new Insets(3, 0, 0,0);
        HBox.setMargin(container, new Insets(3, 0, 0,0));
        
        spinner = new Spinner();
        spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1));
        
        
        label = new Label(text);        
        
        container.getChildren().add(label);
        container.getChildren().add(spinner);
        parent.getChildren().add(container);
    }
    
    public void setLabelColor(RGBColor color)
    {
        label.setTextFill((Paint) color);
    }
    
    public void setPrefWidth(double w)
    {
        spinner.setPrefWidth(w);
    }
    
    public void delInputSpin()
    {
        parent.getChildren().remove(container);
    }

    public Label getLabel() {
        return label;
    }

    public Spinner getSpinner() {
        return spinner;
    }

    public HBox getContainer() {
        return container;
    }

    public Pane getParent() {
        return parent;
    }
   
    
}
