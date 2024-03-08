package es.ieslavereda.Model;

import java.io.Serializable;
import java.util.*;

import static com.diogonunes.jcolor.Ansi.colorize;

public class Board implements Serializable {
    private Map<Coordinate,Cell> cells;

    private DeletedPieceManagerListImp vivas;
    private DeletedPieceManagerListImp muertas;

    private boolean white;

    public Board(){
        white = true;
        cells = new HashMap<>();
        for (int row=8;row>= 1;row--)
            for(char col='A';col<='H';col++){
                Coordinate thew = new Coordinate(col,row);
                cells.put(thew,new Cell(this,thew));
            }
        muertas = new DeletedPieceManagerListImp();
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
        removeHighLight();
        coordinates.stream().forEach(coordinate -> getCellAt(coordinate).highlight());
        System.out.println("\n-------------------------------\n");
        System.out.println("POSIBLE MOVEMENTS: "+ coordinates+"\n");
        System.out.println(this);
        coordinates.stream().forEach(coordinate -> getCellAt(coordinate).removeHighLight());
    }

    public void removeHighLight(){
        for (Cell cell:cells.values()){
            cell.removeHighLight();
        }
    }

    public boolean kingDEAD(){
        if (vivas.count(Piece.Type.BLACK_KING)==0){
            return true;
        }
        if (vivas.count(Piece.Type.WHITE_KING)==0){
            return true;
        }
        return false;
    }

    private String allPieces(){
        String count ="";
        count+="\nALIVE\n";
        for (Piece.Type type:Piece.Type.values()){
            count+=colorize(" ",Cell.Color.BLACK.getAttribute())+colorize(type.getShape(),type.getColor().getAttribute(),Cell.Color.BLACK.getAttribute())+colorize(" ",Cell.Color.BLACK.getAttribute());
        }
        count+="\n";
        count+=vivas.toString();
        count+="\nDEAD\n";
        for (Piece.Type type:Piece.Type.values()){
            count+=colorize(" ",Cell.Color.BLACK.getAttribute())+colorize(type.getShape(),type.getColor().getAttribute(),Cell.Color.BLACK.getAttribute())+colorize(" ",Cell.Color.BLACK.getAttribute());
        }
        count+="\n";
        count+=muertas.toString();
        return count;
    }

    public DeletedPieceManagerListImp getVivas() {
        return vivas;
    }

    public DeletedPieceManagerListImp getMuertas() {
        return muertas;
    }

    public void setVivas(DeletedPieceManagerListImp vivas) {
        this.vivas = vivas;
    }

    public void setWhite(boolean white) {
        this.white = white;
    }

    public boolean isWhite() {
        return white;
    }

    @Override
    public String toString() {
        String aux ="";
        if (white){
            aux="       A  B  C  D  E  F  G  H\n";
            for (int row=8;row>= 1;row--){
                aux+="    " + row +" ";
                for(char col='A';col<='H';col++){
                    aux+=cells.get(new Coordinate(col,row));
                }
                aux+=" " + row + "\n";
            }
            aux+="       A  B  C  D  E  F  G  H\n";

        }else {
            aux="       H  G  F  E  D  C  B  A\n";
            for (int row=1;row<= 8;row++){
                aux+="    " + row +" ";
                for(char col='H';col>='A';col--){
                    aux+=cells.get(new Coordinate(col,row));
                }
                aux+=" " + row + "\n";
            }
            aux+="       H  G  F  E  D  C  B  A\n";
        }
        aux+= allPieces();
        return aux;
    }
}
