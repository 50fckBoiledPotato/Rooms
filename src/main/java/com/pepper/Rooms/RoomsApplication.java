package com.pepper.Rooms;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RoomsApplication {

	public static void main(String[] args) {
            Application.launch(RoomCore.class, args);
	}

}
/*



egy létesítmény termeit tartjuk nyilván, egy szektorban több terem is található; egy adott szektor termeibe csak adott jogosultsági szinttel lehet
belépni (PL: a 2-es jogosultságú szektor termeibe 1-es értékkel még nem lehet belépni, 2-essel, vagy 3-assal már igen)

RoomRepository:
1.zárt/nyitott termek: azon termek listája, amelyeknél a nyitottság értéke a paraméterül kapott logikai érték
2.adott besorolású termek: azon termek listája, amelyeknél a besorolás értéke a paraméterül kapott karakter; megnevezés szerint növekvő sorrendben
3.az előző tagadása: azon termek listája, amelyeknél a besorolás értéke eltér a paraméterül kapott karaktertől; besorolás szerint csökkenő sorrendben
4.szektor-azonosító alapján: azon termek listája, amelyeknél a szektor azonosítója a paraméterül kapott szám
5.jogosultság alapján: azon termek listája, amelyeknél a szektor jogosultsági szintje nem nagyobb a paraméterül kapott számnál
6.zárt/nyitott és besorolás: azon termek listája, amelyeknél a nyitottság és a besorolás értéke a paraméterül kapott logikai értéknek és karakternek megfelelő
*/