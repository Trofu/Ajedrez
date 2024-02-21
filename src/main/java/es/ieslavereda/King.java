package es.ieslavereda;

public class King extends Piece{
    public King(Board board, Coordinate position, Type type) {
        super(type.getType(), board.getCellAt(position));
    }

    //put your task here
    @Override
    protected Coordinate[] getNextMovements() {
        Coordinate[] nextMovements = new Coordinate[0];

        Coordinate myPosition = getCell().getCoordinate();
        Coordinate c;

        c=myPosition.right();
        if (canAddToNextMovements(c)) nextMovements = Tool.add(c,nextMovements);
        c=myPosition.left();
        if (canAddToNextMovements(c)) nextMovements = Tool.add(c,nextMovements);
        c=myPosition.up();
        if (canAddToNextMovements(c)) nextMovements = Tool.add(c,nextMovements);
        c=myPosition.down();
        if (canAddToNextMovements(c)) nextMovements = Tool.add(c,nextMovements);
        c=myPosition.right().up();
        if (canAddToNextMovements(c)) nextMovements = Tool.add(c,nextMovements);
        c=myPosition.right().down();
        if (canAddToNextMovements(c)) nextMovements = Tool.add(c,nextMovements);
        c=myPosition.left().up();
        if (canAddToNextMovements(c)) nextMovements = Tool.add(c,nextMovements);
        c=myPosition.left().down();
        if (canAddToNextMovements(c)) nextMovements = Tool.add(c,nextMovements);
        for (int i = 0; i < nextMovements.length; i++) {
            System.out.print("["+nextMovements[i]+"] ");
        }
        System.out.println();

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
