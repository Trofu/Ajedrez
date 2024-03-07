package es.ieslavereda.Model;

import java.util.LinkedHashSet;
import java.util.Set;

public class King extends Piece{
    public King(Board board, Coordinate position, Type type) {
        super(type.getType(), board.getCellAt(position));
    }

    //put your task here
    @Override
    public Set<Coordinate> getNextMovements() {

        Coordinate position = getCell().getCoordinate();
        Set<Coordinate> nextMovements = new LinkedHashSet<>();
        Coordinate c;

        c = position.up();
        if (canAddToNextMovements(c))
            nextMovements.add(c);

        c =  position.up().right();
        if (canAddToNextMovements(c))
            nextMovements.add(c);

        c =  position.right();
        if (canAddToNextMovements(c))
            nextMovements.add(c);

        c = position.down().right();
        if (canAddToNextMovements(c))
            nextMovements.add(c);

        c = position.down();
        if (canAddToNextMovements(c))
            nextMovements.add(c);

        c = position.down().left();
        if (canAddToNextMovements(c))
            nextMovements.add(c);

        c = position.left();
        if (canAddToNextMovements(c))
            nextMovements.add(c);

        c = position.up().left();
        if (canAddToNextMovements(c))
            nextMovements.add(c);

        return nextMovements;
    }

    public enum Type {
        BLACK(Piece.Type.BLACK_KING), WHITE(Piece.Type.WHITE_KING);
        private Piece.Type type;

        Type(Piece.Type type) {
            this.type = type;
        }

        public Piece.Type getType() {
            return type;
        }
    }
}
