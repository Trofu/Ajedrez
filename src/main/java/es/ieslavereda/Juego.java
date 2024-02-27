package es.ieslavereda;

import java.util.*;

public class Juego {

    private Board tablero;
    private DeletedPieceManagerListImp vivas;
    private DeletedPieceManagerListImp muertas;
    private List<Piece> piezas;




    public Juego() {
        tablero = new Board();
        piezas = new ArrayList<>();
        addPieces();
        vivas = new DeletedPieceManagerListImp();
        muertas = new DeletedPieceManagerListImp();
        for (Piece pice:piezas){
            vivas.addPiece(pice);
        }
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

    public DeletedPieceManagerListImp getMuertas() {
        return muertas;
    }



    public DeletedPieceManagerListImp getVivas() {
        return vivas;
    }


    public Coordinate pedirCordenada(){
        Scanner sc = new Scanner(System.in);
        boolean yes=false;
        Coordinate coord=null;
        do {
            if (yes){
                System.out.println("Coordenada mal introducida");
            }
            String cord = sc.nextLine();
            char c1 = cord.toUpperCase().charAt(0);
            int c2 = cord.charAt(1)-48;
            coord = new Coordinate(c1,c2);
        } while (yes=!tablero.contains(coord));
        return coord;
    }


    @Override
    public String toString(){
        return getTablero()+"VIVAS\n"+getVivas()+"\nMUERTAS\n"+getMuertas();
    }
}
