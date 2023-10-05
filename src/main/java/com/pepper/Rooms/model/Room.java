package com.pepper.Rooms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="rooms")
public class Room 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int sector;
    private int level;
    private boolean isOpen;
    /*
    Room: azonosítója, megnevezése, melyik szektorban található,
    besorolás/típus - egy szimpla karakter, nyitott - igaz/hamis érték)
    */
    public Room(){}

    public Room(String name, int sector, int level, boolean isOpen) {
        this.name = name;
        this.sector = sector;
        this.level = level;
        this.isOpen = isOpen;
    }
    
    

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSector() {
        return sector;
    }

    public int getLevel() {
        return level;
    }

    public boolean isIsOpen() {
        return isOpen;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSector(int sector) {
        this.sector = sector;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    @Override
    public String toString() {
        return "Room{" + "id=" + id + ", name=" + name + ", sector=" + sector + ", level=" + level + ", isOpen=" + isOpen + '}';
    }
    
    
    
}
