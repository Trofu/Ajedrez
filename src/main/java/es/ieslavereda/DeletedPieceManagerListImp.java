package es.ieslavereda;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static com.diogonunes.jcolor.Ansi.colorize;

public class DeletedPieceManagerListImp implements IDeletedPieceManager {

    List<Piece> pieceList;


    public DeletedPieceManagerListImp() {
        pieceList = new ArrayList<>();

    }

    @Override
    public void addPiece(Piece piece) {
        pieceList.add(piece);
    }

    @Override
    public int count(Piece.Type pieceType) {
        return (int) pieceList.stream().filter(piece -> piece.getType().equals(pieceType)).count();
    }
    @Override
    public Piece removeLast() {
        return pieceList.remove(pieceList.size()-1);
    }

    @Override
    public String toString() {
        String aux="";
        for (Piece.Type type:Piece.Type.values()){
            aux+=colorize(" ",Cell.Color.BLACK.getAttribute())+colorize(type.getShape(),type.getColor().getAttribute(),Cell.Color.BLACK.getAttribute())+colorize(" ",Cell.Color.BLACK.getAttribute());
        }
        aux+="\n";
        for (Piece.Type type:Piece.Type.values()){
            aux+=colorize(" ",Cell.Color.WHITE.getAttribute())+colorize(""+count(type),Piece.Color.BLACK.getAttribute(),Cell.Color.WHITE.getAttribute())+colorize(" ",Cell.Color.WHITE.getAttribute()) ;
        }
        return aux;
    }
}
