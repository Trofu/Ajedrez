package es.ieslavereda.Model;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

public class Queen extends Piece implements Serializable {
    public Queen(Board board, Coordinate position, Type type) {
        super(type.getType(), board.getCellAt(position));
    }

    //put your task here
    public Set<Coordinate> getNextMovements(){
        Set<Coordinate> nextMovements = new LinkedHashSet<>();

        for (Coordinate c : Bishop.getNextMovementsAsBishop(this))
            nextMovements.add(c);

        for (Coordinate c : Rook.getNextMovementsAsRook(this))
            nextMovements.add(c);

        return nextMovements;
    }

    public enum Type {
        BLACK(Piece.Type.BLACK_QUEEN), WHITE(Piece.Type.WHITE_QUEEN);
        private Piece.Type type;

        Type(Piece.Type type) {
            this.type = type;
        }

        public Piece.Type getType() {
            return type;
        }
    }
}
