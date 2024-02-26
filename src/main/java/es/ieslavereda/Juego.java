package es.ieslavereda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Juego {

    private Board tablero;

    private DeletedPieceManagerListImp muertas;
    private List<Piece> piezas;


    public Juego() {
        tablero = new Board();
        piezas = new ArrayList<>();
        addPieces();
    }


    private void addPieces (){
        piezas.add(new King(tablero,new Coordinate('D',1), King.Type.WHITE));
        piezas.add(new King(tablero,new Coordinate('D',8), King.Type.BLACK));
        piezas.add(new Queen(tablero,new Coordinate('E',1), Queen.Type.WHITE));
        piezas.add(new Queen(tablero,new Coordinate('E',8), Queen.Type.BLACK));
        piezas.add(new Bishop(tablero,new Coordinate('C',8), Bishop.Type.BLACK));
        piezas.add(new Bishop(tablero,new Coordinate('F',8), Bishop.Type.BLACK));
        piezas.add(new Bishop(tablero,new Coordinate('C',1), Bishop.Type.WHITE));
        piezas.add(new Bishop(tablero,new Coordinate('F',1), Bishop.Type.WHITE));
        piezas.add(new Knight(tablero,new Coordinate('B',8), Knight.Type.BLACK));
        piezas.add(new Knight(tablero,new Coordinate('G',8), Knight.Type.BLACK));
        piezas.add(new Knight(tablero,new Coordinate('B',1), Knight.Type.WHITE));
        piezas.add(new Knight(tablero,new Coordinate('G',1), Knight.Type.WHITE));
        piezas.add(new Rook(tablero,new Coordinate('A',8), Rook.Type.BLACK));
        piezas.add(new Rook(tablero,new Coordinate('H',8), Rook.Type.BLACK));
        piezas.add(new Rook(tablero,new Coordinate('A',1), Rook.Type.WHITE));
        piezas.add(new Rook(tablero,new Coordinate('H',1), Rook.Type.WHITE));
        piezas.add(new Pawn(tablero,new Coordinate('A',7), Pawn.Type.BLACK));
        piezas.add(new Pawn(tablero,new Coordinate('B',7), Pawn.Type.BLACK));
        piezas.add(new Pawn(tablero,new Coordinate('C',7), Pawn.Type.BLACK));
        piezas.add(new Pawn(tablero,new Coordinate('D',7), Pawn.Type.BLACK));
        piezas.add(new Pawn(tablero,new Coordinate('E',7), Pawn.Type.BLACK));
        piezas.add(new Pawn(tablero,new Coordinate('F',7), Pawn.Type.BLACK));
        piezas.add(new Pawn(tablero,new Coordinate('G',7), Pawn.Type.BLACK));
        piezas.add(new Pawn(tablero,new Coordinate('H',7), Pawn.Type.BLACK));
        piezas.add(new Pawn(tablero,new Coordinate('A',2), Pawn.Type.WHITE));
        piezas.add(new Pawn(tablero,new Coordinate('B',2), Pawn.Type.WHITE));
        piezas.add(new Pawn(tablero,new Coordinate('C',2), Pawn.Type.WHITE));
        piezas.add(new Pawn(tablero,new Coordinate('D',2), Pawn.Type.WHITE));
        piezas.add(new Pawn(tablero,new Coordinate('E',2), Pawn.Type.WHITE));
        piezas.add(new Pawn(tablero,new Coordinate('F',2), Pawn.Type.WHITE));
        piezas.add(new Pawn(tablero,new Coordinate('G',2), Pawn.Type.WHITE));
        piezas.add(new Pawn(tablero,new Coordinate('H',2), Pawn.Type.WHITE));
    }

    public Board getTablero() {
        return tablero;
    }

    public void setTablero(Board tablero) {
        this.tablero = tablero;
    }

    public List<Piece> getPiezas() {
        return piezas;
    }

    public void setPiezas(List<Piece> piezas) {
        this.piezas = piezas;
    }
}
