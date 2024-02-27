package es.ieslavereda;

import java.util.*;

public class Board {
    private Map<Coordinate,Cell> cells;
    public Board(){
        cells = new HashMap<>();
        for (int row=8;row>= 1;row--)
            for(char col='A';col<='H';col++){
                Coordinate thew = new Coordinate(col,row);
                cells.put(thew,new Cell(this,thew));
            }
    }
    public boolean contains(Coordinate c) {
        if(c.getLetter()<'A' || c.getLetter()>'H') return false;
        if(c.getNumber()<1 || c.getNumber()>8) return false;

        return true;
    }
    public Cell getCellAt(Coordinate c) {
        if(!contains(c)) return null;
        return cells.get(c);
    }
    public void highLight(Set<Coordinate> coordinates){
        coordinates.stream().forEach(coordinate -> getCellAt(coordinate).highlight());
        System.out.println(coordinates);
    }

    public void highLight_out(){
        cells.values().stream().forEach(cell -> cell.removeHighLight());
    }

    private DeletedPieceManagerListImp allPieces(){
        DeletedPieceManagerListImp piece = new DeletedPieceManagerListImp();
        for (int i = 0; i <8; i++) {
            piece.addPiece(new Pawn(this,new Coordinate('A',7), Pawn.Type.BLACK));
        }
        return piece;
    }
    @Override
    public String toString() {
        DeletedPieceManagerListImp piece = allPieces();
        String aux="\t\t    A  B  C  D  E  F  G  H\n";
        for (int row=8;row>= 1;row--){
            aux+="\t\t " + row +" ";
            for(char col='A';col<='H';col++){
                aux+=cells.get(new Coordinate(col,row));
            }
            aux+=" " + row + "\n";
        }
        aux+="\t\t    A  B  C  D  E  F  G  H\n\n";
        return aux;
    }
}
