package es.ieslavereda;

public class Knight extends Piece {

    public Knight(Board board, Coordinate position, Knight.Type type) {
        super(type.getType(), board.getCellAt(position));
    }

    @Override
    public Coordinate[] getNextMovements() {

        Coordinate[] nextMovements = new Coordinate[0];

        Coordinate myPosition = getCell().getCoordinate();
        Coordinate c;

        //Up
        c = myPosition.up().up().left();
        if(canAddToNextMovements(c)) nextMovements = Tool.add(c,nextMovements);

        c = myPosition.up().up().right();
        if(canAddToNextMovements(c)) nextMovements = Tool.add(c,nextMovements);

        //Down
        c = myPosition.down().down().left();
        if(canAddToNextMovements(c)) nextMovements = Tool.add(c,nextMovements);

        c = myPosition.down().down().right();
        if(canAddToNextMovements(c)) nextMovements = Tool.add(c,nextMovements);

        //Left
        c = myPosition.left().left().up();
        if(canAddToNextMovements(c)) nextMovements = Tool.add(c,nextMovements);

        c = myPosition.left().left().down();
        if(canAddToNextMovements(c)) nextMovements = Tool.add(c,nextMovements);

        //Right
        c = myPosition.right().right().up();
        if(canAddToNextMovements(c)) nextMovements = Tool.add(c,nextMovements);

        c = myPosition.right().right().down();
        if(canAddToNextMovements(c)) nextMovements = Tool.add(c,nextMovements);

        for (int i = 0; i < nextMovements.length; i++) {
            System.out.print("["+nextMovements[i]+"] ");
        }
        System.out.println();

        return nextMovements;
    }

    private boolean canMoveTo(Coordinate c) {

        Board board = getCell().getBoard();

        if(!board.contains(c)) return false;

        if(board.getCellAt(c).isEmpty()) return true;

        if(board.getCellAt(c).getPiece().getColor()!=getColor()) return true;

        return false;
    }

    public enum Type {
        BLACK(Piece.Type.BLACK_KNIGHT), WHITE(Piece.Type.WHITE_KNIGHT);
        private Piece.Type type;

        Type(Piece.Type type) {
            this.type = type;
        }

        public Piece.Type getType() {
            return type;
        }
    }
}