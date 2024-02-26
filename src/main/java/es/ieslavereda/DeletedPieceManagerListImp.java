package es.ieslavereda;

import java.util.ArrayList;
import java.util.List;
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
        return aux;
    }
}
