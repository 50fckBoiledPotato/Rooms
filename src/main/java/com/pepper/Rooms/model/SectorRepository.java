package com.pepper.Rooms.model;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface SectorRepository extends CrudRepository<Sector, Integer>
{
    @Override
    Sector save(Sector sector);
    
    @Override
    void delete(Sector sector);
    
    List<Sector> findAll();
    
    @Query("SELECT s.id FROM Sector s")
    List<Integer> findSectorIds();
}
