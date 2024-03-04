package es.ieslavereda;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Juego j1 = new Juego();
        Board tablero = j1.getTablero();
        do {
            if (tablero.isWhite()){
                System.out.println("PLAYER WHITE YOUR TURN");
            }else {
                System.out.println("PLAYER BLACK YOUR TURN");
            }
                System.out.println(tablero);
                Coordinate c1;
                boolean yes = false;
                do {
                    if (yes){
                        if (tablero.isWhite()) {
                            System.err.println("Select a white piece");
                        }else {
                            System.err.println("Select a black piece");
                        }
                    }else {
                        System.out.println("Which piece do you want to move?");
                    }
                    c1 = j1.pedirCordenada();
                }while (yes = (tablero.getCellAt(c1).isEmpty()||(tablero.getCellAt(c1).getPiece().getColor()== Piece.Color.BLACK && (tablero.isWhite()))||(tablero.getCellAt(c1).getPiece().getColor()== Piece.Color.WHITE && !(tablero.isWhite()))));
                tablero.removeHighLight();
                tablero.highLight(tablero.getCellAt(c1).getPiece().getNextMovements());
                Coordinate c2;
                do {
                    if (yes){
                        System.err.println("Select one of all posible movements");
                    }else {
                        System.out.println("In what cell do you want to place it?");
                    }
                    c2 = j1.pedirCordenada();
                }while (yes = (!tablero.getCellAt(c1).getPiece().getNextMovements().contains(c2)));
                tablero.getCellAt(c1).getPiece().moveTo(c2);
                if (tablero.isWhite()) {
                    Piece king = null;
                    for (Piece piece :tablero.getVivas().getPieceList()){
                        if (piece.getType() == Piece.Type.BLACK_KING){
                            king = piece;

                        }
                    }
                    for (Coordinate coordinate:tablero.getCellAt(c2).getPiece().getNextMovements()){
                        if (coordinate.equals(king.getCell().getCoordinate())){
                            System.out.println("Rey negro estas en JAQUE");
                            tablero.getCellAt(coordinate).highlight();
                        }
                    }
                    tablero.setWhite(false);
                }else {
                    Piece king = null;
                    for (Piece piece :tablero.getVivas().getPieceList()){
                        if (piece.getType() == Piece.Type.WHITE_KING){
                            king = piece;

                        }
                    }
                    for (Coordinate coordinate:tablero.getCellAt(c2).getPiece().getNextMovements()){
                        if (coordinate.equals(king.getCell().getCoordinate())){
                            System.out.println("Rey Blanco estas en JAQUE");
                            tablero.getCellAt(coordinate).highlight();
                        }
                    }
                    tablero.setWhite(true);
                }
        }while (!tablero.kingDEAD());
    }
};
