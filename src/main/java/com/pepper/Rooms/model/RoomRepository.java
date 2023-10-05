package com.pepper.Rooms.model;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RoomRepository extends CrudRepository<Room, Integer>
{
    /*
    RoomRepository:
1.zárt/nyitott termek: azon termek listája, amelyeknél a nyitottság értéke a paraméterül kapott logikai érték
2.adott besorolású termek: azon termek listája, amelyeknél a besorolás értéke a paraméterül kapott karakter; megnevezés szerint növekvő sorrendben
3.az előző tagadása: azon termek listája, amelyeknél a besorolás értéke eltér a paraméterül kapott karaktertől; besorolás szerint csökkenő sorrendben
4.szektor-azonosító alapján: azon termek listája, amelyeknél a szektor azonosítója a paraméterül kapott szám
5.jogosultság alapján: azon termek listája, amelyeknél a szektor jogosultsági szintje nem nagyobb a paraméterül kapott számnál
6.zárt/nyitott és besorolás: azon termek listája, amelyeknél a nyitottság és a besorolás értéke a paraméterül kapott logikai értéknek és karakternek megfelelő
    */
    /*zárt/nyitott termek:*/    
    List<Room> findByIsOpen(Boolean isOpen);
    
    /*adott besorolású termek:*/
    List<Room> findByLevel(int level);
    
    /*előző tagadása*/
    @Query("SELECT r FROM Room r WHERE level <> :level")
    List<Room> findbyOutOfLevelCustom(@Param("level") int level);
    
    /*szektor-azonosító alapján:*/
    List<Room> findBySector(int sector);
    
    /*rooms, amelyeknél a szektor jogosultsági szintje nem nagyobb a paraméterül kapott számnál*/
    @Query("SELECT r FROM Room r JOIN Sector s ON r.sector = s.id WHERE s.permission <= :permission ")
    List<Room> findRoomsByPermission(@Param("permission") int permission);
    
    /*zárt/nyitott és besorolás:*/
    @Query("SELECT r FROM Room r WHERE r.level = :level AND r.isOpen = :isOpen")
    List<Room> findRoomsByLevelAndIsOpen(@Param("level") int level, @Param("isOpen") boolean isOpen);
    
    @Override
    Room save(Room room);
}
