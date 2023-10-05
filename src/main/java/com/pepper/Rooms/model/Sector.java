package com.pepper.Rooms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Sector 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int permission;
    /*Sector: azonosítója van, neve, jogosultság - egészszám*/
    public Sector(){}

    public Sector(String name, int permission) {
        this.name = name;
        this.permission = permission;
    }
    
    

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPermission() {
        return permission;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "Sector{" + "id=" + id + ", name=" + name + ", permission=" + permission + '}';
    }
    
    

}
