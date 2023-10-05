package com.pepper.Rooms;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;


public class RoomCore extends Application
{
    private static ConfigurableApplicationContext context;

    @Override
    public void start(Stage stage) throws Exception 
    {
        FXMLLoader loader = new FXMLLoader(RoomCore.class.getResource("rooms.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setTitle("Rooms");
        stage.show();
    }

    @Override
    public void init() throws Exception 
    {
        super.init(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        context = new SpringApplicationBuilder(RoomsApplication.class).run();
    }
    
    

    public static ConfigurableApplicationContext getContext()
    {
        return  context;
    }
}
