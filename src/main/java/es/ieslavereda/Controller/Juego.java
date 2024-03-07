package es.ieslavereda.Controller;

import es.ieslavereda.Model.*;

import java.util.*;

public class Juego {

    private Board tablero;
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

    public void playGame(){
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
                c1 = this.pedirCordenada();
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
                c2 = this.pedirCordenada();
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


    public Coordinate pedirCordenada(){
        Scanner sc = new Scanner(System.in);
        boolean yes=false,yes2=false,yes3=false;
        Coordinate coord;
        System.out.println("Enter a coordinate: ");
        do {
            if (yes){
                System.err.println("Coordenada fuera de los limites");
            }
            String cord;
            do {
                if (yes2){
                    System.err.println("Coordenada Incorrecta prueba (Letra(A-H)/Numero(1-8))");
                }
                cord = sc.nextLine();
            }while ( yes2 = !(cord.length()==2));
            char c1 = cord.toUpperCase().charAt(0);
            int c2 = cord.charAt(1)-48;
            coord = new Coordinate(c1,c2);
        }while (yes = !tablero.contains(coord));
        return coord;
    }


    @Override
    public String toString(){
        return getTablero()+"";
    }
}
