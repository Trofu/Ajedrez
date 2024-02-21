package es.ieslavereda;

public class Queen extends Piece{
    public Queen(Board board, Coordinate position, Type type) {
        super(type.getType(), board.getCellAt(position));
    }

    //put your task here
    @Override
    protected Coordinate[] getNextMovements() {
        Coordinate[] nextMovements = new Coordinate[0];
        nextMovements = Bishop.getNextMovementsAsBishop(this);

        Coordinate[] nextMovementsRook = new Coordinate[0];
        nextMovementsRook=Rook.getNextMovementsAsRook(this);
        for (Coordinate coordinate:nextMovementsRook)
            nextMovements=Tool.add(coordinate,nextMovements);
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
