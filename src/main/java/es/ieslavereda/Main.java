package es.ieslavereda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Juego j1 = new Juego();
        Board tablero = j1.getTablero();
        boolean yes = true;
        do {
            System.out.println(j1);
            System.out.println("Which piece do you want to move?\nEnter a coordinate: ");
            Coordinate c1 = j1.pedirCordenada();
            if (!tablero.getCellAt(c1).isEmpty()){
                tablero.highLight(tablero.getCellAt(c1).getPiece().getNextMovements());
            }
            System.out.println(j1);
            tablero.highLight_out();
            System.out.println("Enter other coords");
            Coordinate c2 = j1.pedirCordenada();

            tablero.getCellAt(c1).getPiece().moveTo(c2);
        }while (yes);



    }




}
