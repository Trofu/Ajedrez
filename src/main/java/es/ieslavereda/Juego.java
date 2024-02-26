package es.ieslavereda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Juego {

    private Board tablero;

    private Map<String,Piece> piezas;


    public Juego() {
        tablero = new Board();
        piezas = new HashMap<>();
        putPieces();
    }


    private void putPieces (){
        piezas.put("KB",new King(tablero,new Coordinate('D',1), King.Type.WHITE));
        piezas.put("KN",new King(tablero,new Coordinate('D',8), King.Type.BLACK));
        piezas.put("QB",new Queen(tablero,new Coordinate('E',1), Queen.Type.WHITE));
        piezas.put("QN",new Queen(tablero,new Coordinate('E',8), Queen.Type.BLACK));
        piezas.put("BN1",new Bishop(tablero,new Coordinate('C',8), Bishop.Type.BLACK));
        piezas.put("BN2",new Bishop(tablero,new Coordinate('F',8), Bishop.Type.BLACK));
        piezas.put("BB1",new Bishop(tablero,new Coordinate('C',1), Bishop.Type.WHITE));
        piezas.put("BB2",new Bishop(tablero,new Coordinate('F',1), Bishop.Type.WHITE));
        piezas.put("KN1",new Knight(tablero,new Coordinate('B',8), Knight.Type.BLACK));
        piezas.put("KN2",new Knight(tablero,new Coordinate('G',8), Knight.Type.BLACK));
        piezas.put("KB1",new Knight(tablero,new Coordinate('B',1), Knight.Type.WHITE));
        piezas.put("KB2",new Knight(tablero,new Coordinate('G',1), Knight.Type.WHITE));
        piezas.put("RN1",new Rook(tablero,new Coordinate('A',8), Rook.Type.BLACK));
        piezas.put("RN2",new Rook(tablero,new Coordinate('H',8), Rook.Type.BLACK));
        piezas.put("RB1",new Rook(tablero,new Coordinate('A',1), Rook.Type.WHITE));
        piezas.put("RB2",new Rook(tablero,new Coordinate('H',1), Rook.Type.WHITE));
        piezas.put("PN1",new Pawn(tablero,new Coordinate('A',7), Pawn.Type.BLACK));
        piezas.put("PN2",new Pawn(tablero,new Coordinate('B',7), Pawn.Type.BLACK));
        piezas.put("PN3",new Pawn(tablero,new Coordinate('C',7), Pawn.Type.BLACK));
        piezas.put("PN4",new Pawn(tablero,new Coordinate('D',7), Pawn.Type.BLACK));
        piezas.put("PN5",new Pawn(tablero,new Coordinate('E',7), Pawn.Type.BLACK));
        piezas.put("PN6",new Pawn(tablero,new Coordinate('F',7), Pawn.Type.BLACK));
        piezas.put("PN7",new Pawn(tablero,new Coordinate('G',7), Pawn.Type.BLACK));
        piezas.put("PN8",new Pawn(tablero,new Coordinate('H',7), Pawn.Type.BLACK));
        piezas.put("PB1",new Pawn(tablero,new Coordinate('A',2), Pawn.Type.WHITE));
        piezas.put("PB2",new Pawn(tablero,new Coordinate('B',2), Pawn.Type.WHITE));
        piezas.put("PB3",new Pawn(tablero,new Coordinate('C',2), Pawn.Type.WHITE));
        piezas.put("PB4",new Pawn(tablero,new Coordinate('D',2), Pawn.Type.WHITE));
        piezas.put("PB5",new Pawn(tablero,new Coordinate('E',2), Pawn.Type.WHITE));
        piezas.put("PB6",new Pawn(tablero,new Coordinate('F',2), Pawn.Type.WHITE));
        piezas.put("PB7",new Pawn(tablero,new Coordinate('G',2), Pawn.Type.WHITE));
        piezas.put("PB8",new Pawn(tablero,new Coordinate('H',2), Pawn.Type.WHITE));
    }

    public Board getTablero() {
        return tablero;
    }

    public void setTablero(Board tablero) {
        this.tablero = tablero;
    }

    public Map<String, Piece> getPiezas() {
        return piezas;
    }

    public void setPiezas(Map<String, Piece> piezas) {
        this.piezas = piezas;
    }
}
