package es.ieslavereda.Model;

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

    public List<Piece> getPieceList() {
        return pieceList;
    }

    public void remove(Piece piece){
        pieceList.remove(piece);
    }

}
