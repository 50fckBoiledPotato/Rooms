package com.pepper.Rooms.model;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Model 
{
    @Autowired
    RoomRepository roomRepo;
    @Autowired
    SectorRepository sectorRepo;

    public void saveSector(Sector sector)
    {
        sectorRepo.save(sector);
    }
    
    public List<Integer> getSectorIds()
    {
        return sectorRepo.findSectorIds();
    }
    
    public void deleteSector(Sector sector)
    {
        sectorRepo.delete(sector);
    }
    
    public void saveRoom(Room room)
    {
        roomRepo.save(room);
    }
    
    public List<Room> findByIsOpen(Boolean isOpen)
    {
        return roomRepo.findByIsOpen(isOpen);
    }
    
    public List<Room> findByLevel(int level)
    {
        return roomRepo.findByLevel(level);
    }
    
    public List<Room> findbyOutOfLevelCustom(int level)
    {
        return roomRepo.findByLevel(level);
    }
    
    public List<Room> findBySector(int sector)
    {
        return roomRepo.findBySector(sector);
    }
    
    public List<Room> findRoomsByPermission(int permission)
    {
        return roomRepo.findRoomsByPermission(permission);
    }
    
    public List<Room> findRoomsByLevelAndIsOpen(int level, boolean isOpen)
    {
        return roomRepo.findRoomsByLevelAndIsOpen(level, isOpen);
    }
    
}
