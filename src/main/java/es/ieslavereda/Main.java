package es.ieslavereda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Juego j1 = new Juego();
        Board tablero = j1.getTablero();
        do {
            if (tablero.isWhite()){
                System.out.println("PLAYER WHITE YOUR TURN");
                System.out.println(tablero);
                Coordinate c1;
                boolean yes = false;
                do {
                    if (yes){
                        System.err.println("Select a white piece");
                    }else {
                        System.out.println("Which piece do you want to move?");
                    }
                    c1 = j1.pedirCordenada();
                }while (yes = (tablero.getCellAt(c1).isEmpty()||(tablero.getCellAt(c1).getPiece().getColor()== Piece.Color.BLACK)));
                tablero.highLight(tablero.getCellAt(c1).getPiece().getNextMovements());
                Coordinate c2;
                do {
                    if (yes){
                        System.err.println("Select one of all posible movements");
                    }else {
                        System.out.println("In what cell do you want to place it?");
                    }
                    c2 = j1.pedirCordenada();
                }while (yes = !tablero.getCellAt(c1).getPiece().getNextMovements().contains(c2));
                tablero.getCellAt(c1).getPiece().moveTo(c2);
                tablero.setWhite(false);
            }else {
                System.out.println("PLAYER BLACK YOUR TURN");
                System.out.println(tablero);
                Coordinate c1;
                boolean yes = false;
                do {
                    if (yes){
                        System.err.println("Select a black piece");
                    }else {
                        System.out.println("Which piece do you want to move?");
                    }
                    c1 = j1.pedirCordenada();
                }while (yes = (tablero.getCellAt(c1).isEmpty()||(tablero.getCellAt(c1).getPiece().getColor()== Piece.Color.WHITE)));
                tablero.highLight(tablero.getCellAt(c1).getPiece().getNextMovements());
                Coordinate c2;
                do {
                    if (yes){
                        System.err.println("Select one of all posible movements");
                    }else {
                        System.out.println("In what cell do you want to place it?");
                    }
                    c2 = j1.pedirCordenada();
                }while (yes = !tablero.getCellAt(c1).getPiece().getNextMovements().contains(c2));
                tablero.getCellAt(c1).getPiece().moveTo(c2);
                tablero.setWhite(true);
            }

        }while (!tablero.kingDEAD());
    }
}
