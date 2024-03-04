package es.ieslavereda;

import java.util.*;

import static com.diogonunes.jcolor.Ansi.colorize;

public class Board {
    private Map<Coordinate,Cell> cells;

    private DeletedPieceManagerListImp vivas;

    private boolean white;

    public Board(){
        white = true;
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
            System.out.println("\nGANAN LAS BLANCAS");
            return true;
        }
        if (vivas.count(Piece.Type.WHITE_KING)==0){
            System.out.println("\nGANAN LAS NEGRAS");
            return true;
        }
        return false;
    }

    private String allPieces(){
        String count ="";
        vivas = new DeletedPieceManagerListImp();
        for(Cell cell:cells.values()){
            if (!cell.isEmpty()){
                vivas.addPiece(cell.getPiece());
            }
        }
        count+="\nVIVAS\n";
        for (Piece.Type type:Piece.Type.values()){
            count+=colorize(" ",Cell.Color.BLACK.getAttribute())+colorize(type.getShape(),type.getColor().getAttribute(),Cell.Color.BLACK.getAttribute())+colorize(" ",Cell.Color.BLACK.getAttribute());
        }
        count+="\n";
        for (Piece.Type type:Piece.Type.values()){
            count+=colorize(" ",Cell.Color.WHITE.getAttribute())+colorize(""+vivas.count(type),Piece.Color.BLACK.getAttribute(),Cell.Color.WHITE.getAttribute())+colorize(" ",Cell.Color.WHITE.getAttribute()) ;
        }
        count+="\nMUERTAS\n";
        for (Piece.Type type:Piece.Type.values()){
            count+=colorize(" ",Cell.Color.BLACK.getAttribute())+colorize(type.getShape(),type.getColor().getAttribute(),Cell.Color.BLACK.getAttribute())+colorize(" ",Cell.Color.BLACK.getAttribute());
        }
        count+="\n";
        for (Piece.Type type:Piece.Type.values()){
            if (type.getShape()=="♟"){
                count+=colorize(" ",Cell.Color.WHITE.getAttribute())+colorize(""+(8-vivas.count(type)),Piece.Color.BLACK.getAttribute(),Cell.Color.WHITE.getAttribute())+colorize(" ",Cell.Color.WHITE.getAttribute()) ;
            }else if (type.getShape()=="♚"||type.getShape()=="♛"){
                count+=colorize(" ",Cell.Color.WHITE.getAttribute())+colorize(""+(1-vivas.count(type)),Piece.Color.BLACK.getAttribute(),Cell.Color.WHITE.getAttribute())+colorize(" ",Cell.Color.WHITE.getAttribute()) ;
            }else {
                count+=colorize(" ",Cell.Color.WHITE.getAttribute())+colorize(""+(2-vivas.count(type)),Piece.Color.BLACK.getAttribute(),Cell.Color.WHITE.getAttribute())+colorize(" ",Cell.Color.WHITE.getAttribute()) ;
            }
        }
        return count;
    }

    public DeletedPieceManagerListImp getVivas() {
        return vivas;
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
            aux="\t\t    A  B  C  D  E  F  G  H\n";
            for (int row=8;row>= 1;row--){
                aux+="\t\t " + row +" ";
                for(char col='A';col<='H';col++){
                    aux+=cells.get(new Coordinate(col,row));
                }
                aux+=" " + row + "\n";
            }
            aux+="\t\t    A  B  C  D  E  F  G  H\n\n";

        }else {
            aux="\t\t    H  G  F  E  D  C  B  A\n";
            for (int row=1;row<= 8;row++){
                aux+="\t\t " + row +" ";
                for(char col='H';col>='A';col--){
                    aux+=cells.get(new Coordinate(col,row));
                }
                aux+=" " + row + "\n";
            }
            aux+="\t\t    H  G  F  E  D  C  B  A\n\n";
        }
        aux+= allPieces();
        return aux;
    }
}
