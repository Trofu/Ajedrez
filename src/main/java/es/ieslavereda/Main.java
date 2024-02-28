package es.ieslavereda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Juego j1 = new Juego();
        Board tablero = j1.getTablero();
        System.out.println(j1);
        do {
            Coordinate c1 = j1.pedirCordenada1();
            if (!tablero.getCellAt(c1).isEmpty()){
                tablero.highLight(tablero.getCellAt(c1).getPiece().getNextMovements());
            }
            System.out.println(j1);
            tablero.highLight_out(tablero.getCellAt(c1).getPiece().getNextMovements());
            Coordinate c2 = j1.pedirCordenada();
            tablero.getCellAt(c1).getPiece().moveTo(c2);
            System.out.println(j1);
        }while (!tablero.kingDEAD());



    }




}
