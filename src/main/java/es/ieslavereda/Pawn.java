package es.ieslavereda;

public class Pawn extends Piece{
    public Pawn(Board board, Coordinate position, Type type) {
        super(type.getType(), board.getCellAt(position));
    }

    //put your task here
    @Override
    protected Coordinate[] getNextMovements() {
        Coordinate[] nextMovements = new Coordinate[0];
        Coordinate myPosition = getCell().getCoordinate();
        Coordinate c;
        Board board = getCell().getBoard();
        c=myPosition;
        if (this.getColor() == Color.BLACK){
            // ADELANTE
            c=c.up();
            if (canAddToNextMovements(c)) nextMovements = Tool.add(c,nextMovements);
            // POSICION INICIAL
            if (myPosition.getNumber()==7){
                c=myPosition;
                int i = 0;
                do {
                    c = c.up();
                    if (canAddToNextMovements(c)) nextMovements = Tool.add(c, nextMovements);
                    i++;
                }while (i!=2&&board.getCellAt(c).getPiece() == null);
            }
            //diagonal mata
            c=myPosition.up().right();
            if (board.contains(c)&&board.getCellAt(c).getPiece()!= null&&board.getCellAt(c).getPiece().getColor()!=getColor()){
                if (canAddToNextMovements(c)) nextMovements = Tool.add(c, nextMovements);
            }
            c=myPosition.up().left();
            if (board.contains(c)&&board.getCellAt(c).getPiece()!= null&&board.getCellAt(c).getPiece().getColor()!=getColor()){
                if (canAddToNextMovements(c)) nextMovements = Tool.add(c, nextMovements);
            }
        }else {
            // ADELANTE
            if (myPosition.getNumber()!=7){
                c=c.down();
            }
            if (canAddToNextMovements(c)) nextMovements = Tool.add(c,nextMovements);
            // POSICION INICIAL
            if (myPosition.getNumber()==7){
                c=myPosition;
                int i = 0;
                do {
                    c = c.down();
                    if (canAddToNextMovements(c)) nextMovements = Tool.add(c, nextMovements);
                    i++;
                }while (i!=2&&board.getCellAt(c).getPiece() == null);
            }
            //diagonal mata
            c=myPosition.down().right();
            if (board.contains(c)&&board.getCellAt(c).getPiece()!= null&&board.getCellAt(c).getPiece().getColor()!=getColor()){
                if (canAddToNextMovements(c)) nextMovements = Tool.add(c, nextMovements);
            }
            c=myPosition.down().left();
            if (board.contains(c)&&board.getCellAt(c).getPiece()!= null&&board.getCellAt(c).getPiece().getColor()!=getColor()){
                if (canAddToNextMovements(c)) nextMovements = Tool.add(c, nextMovements);
            }
        }
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
        BLACK(Piece.Type.BLACK_PAWN), WHITE(Piece.Type.WHITE_PAWN);
        private Piece.Type type;

        Type(Piece.Type type) {
            this.type = type;
        }

        public Piece.Type getType() {
            return type;
        }
    }
}
