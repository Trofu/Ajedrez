package es.ieslavereda;

public class Bishop extends Piece {
    public Bishop(Board board, Coordinate position, Type type) {
        super(type.getType(), board.getCellAt(position));
    }

    //put your task here
    @Override
    protected Coordinate[] getNextMovements() {
        return getNextMovementsAsBishop(this);
    }

    public static Coordinate[] getNextMovementsAsBishop(Piece piece){
        Coordinate[] nextMovements = new Coordinate[0];
        Coordinate posicion = piece.getCell().getCoordinate();
        Coordinate c;
        Board board = piece.getCell().getBoard();
        c = posicion;
        do {
            c = c.up().left();
            if (piece.canAddToNextMovements(c))
                nextMovements = Tool.add(c, nextMovements);
        } while (board.contains(c) && board.getCellAt(c).getPiece() == null);
        c = posicion;
        do {
            c = c.up().right();
            if (piece.canAddToNextMovements(c))
                nextMovements = Tool.add(c, nextMovements);
        } while (board.contains(c) && board.getCellAt(c).getPiece() == null);
        c = posicion;
        do {
            c = c.down().left();
            if (piece.canAddToNextMovements(c))
                nextMovements = Tool.add(c, nextMovements);
        } while (board.contains(c) && board.getCellAt(c).getPiece() == null);
        c = posicion;
        do {
            c = c.down().right();
            if (piece.canAddToNextMovements(c))
                nextMovements = Tool.add(c, nextMovements);
        } while (board.contains(c) && board.getCellAt(c).getPiece() == null);

        for (int i = 0; i < nextMovements.length; i++) {
            System.out.print("["+nextMovements[i]+"] ");
        }
        System.out.println();

        return nextMovements;
    }

    public enum Type {
        BLACK(Piece.Type.BLACK_BISHOP), WHITE(Piece.Type.WHITE_BISHOP);
        private Piece.Type type;

        Type(Piece.Type type) {
            this.type = type;
        }

        public Piece.Type getType() {
            return type;
        }
    }
}
