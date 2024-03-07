package es.ieslavereda.Model;

import com.diogonunes.jcolor.Attribute;

import java.util.*;

import static com.diogonunes.jcolor.Ansi.colorize;

public abstract class Piece{

    private Type type;
    private Cell cell;

    public Piece(Type type, Cell cell){
        this.type = type;
        this.cell = cell;
        place();
    }
    protected void place() {
        if(cell!=null)
            cell.setPiece(this);
    }

    public boolean canMoveTo(Coordinate coordinate){
        Set<Coordinate> nextMovements = getNextMovements();
        return nextMovements.contains(coordinate);
    }
    public void remove(){
        if(cell!=null){
            cell.setPiece(null);
            cell = null;
        }
    }

    protected boolean canAddToNextMovements(Coordinate c) {

        Board board = getCell().getBoard();

        if(!board.contains(c)) return false;

        if(board.getCellAt(c).isEmpty()) return true;

        if(board.getCellAt(c).getPiece().getColor()!=getColor()) return true;

        return false;
    }

    public boolean moveTo(Coordinate coordinate){
        if(!canMoveTo(coordinate))
            return false;
        Board board = cell.getBoard();
        if(!board.getCellAt(coordinate).isEmpty()) {
            board.getVivas().remove(board.getCellAt(coordinate).getPiece());
            board.getMuertas().addPiece(board.getCellAt(coordinate).getPiece());
            board.getCellAt(coordinate).getPiece().remove();
        }
        remove();
        setCell(board.getCellAt(coordinate));
        place();
        return true;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }
    public Type getType() {
        return type;
    }
    public Cell getCell() {
        return cell;
    }
    public Color getColor(){
        return type.getColor();
    }


    @Override
    public String toString(){
        if(cell==null){
            return colorize(type.getShape(),type.getColor().getAttribute());
        }else{
            return colorize(type.getShape(),type.getColor().getAttribute(),cell.getColor().getAttribute());
        }
    }

    public abstract Set<Coordinate> getNextMovements();

    public enum Color {

        WHITE(Attribute.TEXT_COLOR(255,255,255)),
        BLACK(Attribute.TEXT_COLOR(0, 0, 0));

        private Attribute color;

        Color(Attribute color) {
            this.color = color;
        }

        public Attribute getAttribute() {
            return color;
        }

    }

    public enum Type {

        WHITE_KING("♚", Color.WHITE),
        WHITE_QUEEN("♛", Color.WHITE),
        WHITE_ROOK("♜", Color.WHITE),
        WHITE_BISHOP("♝", Color.WHITE),
        WHITE_KNIGHT("♞", Color.WHITE),
        WHITE_PAWN("♟", Color.WHITE),
        BLACK_KING("♚", Color.BLACK),
        BLACK_QUEEN("♛", Color.BLACK),
        BLACK_ROOK("♜", Color.BLACK),
        BLACK_BISHOP("♝", Color.BLACK),
        BLACK_KNIGHT("♞", Color.BLACK),
        BLACK_PAWN("♟", Color.BLACK);

        private final String shape;
        private final Color color;

        Type(String shape, Color color) {
            this.shape = shape;
            this.color = color;
        }

        public String getShape() {
            return shape;
        }
        public Color getColor(){
            return color;
        }
    }

}