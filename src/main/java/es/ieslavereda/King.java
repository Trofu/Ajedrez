package es.ieslavereda;

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

        position.up();
        if (canAddToNextMovements(position))
            nextMovements.add(position);

        position.up().right();
        if (canAddToNextMovements(position))
            nextMovements.add(position);

        position.right();
        if (canAddToNextMovements(position))
            nextMovements.add(position);

        position.down().right();
        if (canAddToNextMovements(position))
            nextMovements.add(position);

        position.down();
        if (canAddToNextMovements(position))
            nextMovements.add(position);

        position.down().left();
        if (canAddToNextMovements(position))
            nextMovements.add(position);

        position.left();
        if (canAddToNextMovements(position))
            nextMovements.add(position);

        position.up().left();
        if (canAddToNextMovements(position))
            nextMovements.add(position);

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
