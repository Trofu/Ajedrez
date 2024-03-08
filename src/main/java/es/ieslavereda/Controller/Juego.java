package es.ieslavereda.Controller;

import es.ieslavereda.Model.*;
import java.io.Serializable;
import java.util.*;
import static com.diogonunes.jcolor.Ansi.colorize;
import java.util.stream.Collectors;

public class Juego implements Serializable {

    private Board tablero;
    private DeletedPieceManagerListImp piezas;

    private Map<Integer,List<Coordinate>> movements;


    public Juego() {
        tablero = new Board();
        piezas = new DeletedPieceManagerListImp();
        addPieces();
        tablero.setVivas(piezas);
        movements = new HashMap<>();
    }


    private void addPieces (){
        piezas.addPiece(new King(tablero,new Coordinate('E',1), King.Type.WHITE));
        piezas.addPiece(new King(tablero,new Coordinate('E',3), King.Type.BLACK));
        piezas.addPiece(new Queen(tablero,new Coordinate('D',1), Queen.Type.WHITE));
        piezas.addPiece(new Queen(tablero,new Coordinate('D',8), Queen.Type.BLACK));
        piezas.addPiece(new Bishop(tablero,new Coordinate('C',8), Bishop.Type.BLACK));
        piezas.addPiece(new Bishop(tablero,new Coordinate('F',8), Bishop.Type.BLACK));
        piezas.addPiece(new Bishop(tablero,new Coordinate('C',1), Bishop.Type.WHITE));
        piezas.addPiece(new Bishop(tablero,new Coordinate('F',1), Bishop.Type.WHITE));
        piezas.addPiece(new Knight(tablero,new Coordinate('B',8), Knight.Type.BLACK));
        piezas.addPiece(new Knight(tablero,new Coordinate('G',8), Knight.Type.BLACK));
        piezas.addPiece(new Knight(tablero,new Coordinate('B',1), Knight.Type.WHITE));
        piezas.addPiece(new Knight(tablero,new Coordinate('G',1), Knight.Type.WHITE));
        piezas.addPiece(new Rook(tablero,new Coordinate('A',8), Rook.Type.BLACK));
        piezas.addPiece(new Rook(tablero,new Coordinate('H',8), Rook.Type.BLACK));
        piezas.addPiece(new Rook(tablero,new Coordinate('A',1), Rook.Type.WHITE));
        piezas.addPiece(new Rook(tablero,new Coordinate('H',1), Rook.Type.WHITE));
        piezas.addPiece(new Pawn(tablero,new Coordinate('A',7), Pawn.Type.BLACK));
        piezas.addPiece(new Pawn(tablero,new Coordinate('B',7), Pawn.Type.BLACK));
        piezas.addPiece(new Pawn(tablero,new Coordinate('C',7), Pawn.Type.BLACK));
        piezas.addPiece(new Pawn(tablero,new Coordinate('D',7), Pawn.Type.BLACK));
        piezas.addPiece(new Pawn(tablero,new Coordinate('E',7), Pawn.Type.BLACK));
        piezas.addPiece(new Pawn(tablero,new Coordinate('F',7), Pawn.Type.BLACK));
        piezas.addPiece(new Pawn(tablero,new Coordinate('G',7), Pawn.Type.BLACK));
        piezas.addPiece(new Pawn(tablero,new Coordinate('H',7), Pawn.Type.BLACK));
        piezas.addPiece(new Pawn(tablero,new Coordinate('A',2), Pawn.Type.WHITE));
        piezas.addPiece(new Pawn(tablero,new Coordinate('B',2), Pawn.Type.WHITE));
        piezas.addPiece(new Pawn(tablero,new Coordinate('C',2), Pawn.Type.WHITE));
        piezas.addPiece(new Pawn(tablero,new Coordinate('D',2), Pawn.Type.WHITE));
        piezas.addPiece(new Pawn(tablero,new Coordinate('E',2), Pawn.Type.WHITE));
        piezas.addPiece(new Pawn(tablero,new Coordinate('F',2), Pawn.Type.WHITE));
        piezas.addPiece(new Pawn(tablero,new Coordinate('G',2), Pawn.Type.WHITE));
        piezas.addPiece(new Pawn(tablero,new Coordinate('H',2), Pawn.Type.WHITE));
    }

    public Board getTablero() {
        return tablero;
    }

    public void playGame(){
        boolean save ;
        int i = movements.size();
        do {
            List<Coordinate> movement = new ArrayList<>();
            System.out.println("\n-------------------------------");
            System.out.println("\n"+colorize(" ♚ PLAYER "+(tablero.isWhite() ? "WHITE" : "BLACK")+" YOUR TURN ♚ ",(tablero.isWhite() ? Piece.Color.WHITE.getAttribute():Piece.Color.BLACK.getAttribute()),(!tablero.isWhite() ? Cell.Color.WHITE.getAttribute(): Cell.Color.BLACK.getAttribute()))+"\n");
            if (save = Files.saveGame(this)){
                break;
            }
            System.out.println(tablero);
            Coordinate c1;
            boolean yes = false, maybe=false;
            do {
                if (yes){
                    if (maybe){
                        System.err.println("Select a piece can move");
                    }else {
                        System.err.println("Select a " + (tablero.isWhite() ? "white" : "black") +  " piece");
                    }
                }else {
                    System.out.println("Which piece do you want to move?");
                }
                c1 = pedirCordenada();
                maybe = !tablero.getCellAt(c1).isEmpty() && tablero.getCellAt(c1).getPiece().getNextMovements().isEmpty();
            }while (yes = (tablero.getCellAt(c1).isEmpty()||(tablero.getCellAt(c1).getPiece().getColor() == (tablero.isWhite()?Piece.Color.BLACK:Piece.Color.WHITE))
                    ||tablero.getCellAt(c1).getPiece().getNextMovements().size()==0));
            tablero.highLight(tablero.getCellAt(c1).getPiece().getNextMovements());
            Coordinate c2;
            do {
                if (yes){
                    System.err.println("Select one of all posible movements");
                }else {
                    System.out.println("In what cell do you want to place it?");
                }
                c2 = pedirCordenada();
            }while (yes = (!tablero.getCellAt(c1).getPiece().getNextMovements().contains(c2)));
            tablero.getCellAt(c1).getPiece().moveTo(c2);
            if (!tablero.kingDEAD()){
                List<Piece> king = tablero.getVivas().getPieceList().stream().filter(piece -> piece.getType()==(tablero.isWhite()?Piece.Type.BLACK_KING:Piece.Type.WHITE_KING)).collect(Collectors.toList());
                for (Coordinate coordinate:tablero.getCellAt(c2).getPiece().getNextMovements()){
                    if (king.get(0).getCell() != null && coordinate.equals(king.get(0).getCell().getCoordinate())){
                        System.out.println((tablero.isWhite() ? "white" : "black")+" king are in check");
                        tablero.getCellAt(coordinate).highlightJaque();
                    }
                }
            }
            tablero.setWhite(!tablero.isWhite());
            i++;
            movement.add(c1);
            movement.add(c2);
            movements.put(i,movement);
        }while (!tablero.kingDEAD());


        if (save){
            System.out.println("Game Save");
            movements.toString();
        }else {
            System.out.println("\n"+colorize(" WIN "+(tablero.isWhite() ? "WHITE" : "BLACK")+" PLAYER ",(tablero.isWhite() ? Piece.Color.WHITE.getAttribute():Piece.Color.BLACK.getAttribute()),(!tablero.isWhite() ? Cell.Color.WHITE.getAttribute(): Cell.Color.BLACK.getAttribute()))+"\n");
            System.out.println("MOVEMENTS ");
            for (Map.Entry<Integer, List<Coordinate>> entry : movements.entrySet()) {
                int numero = entry.getKey();
                List<Coordinate> coordenadas = entry.getValue();
                System.out.print("Move " + numero+":  ");
                for (int j = 0; j < 2; j++) {
                    if (j == 0) System.out.print("["+coordenadas.get(j)+" --> ");
                    else System.out.println(coordenadas.get(j)+"]");
                }
            }
        }

    }

    public Coordinate pedirCordenada(){
        Scanner sc = new Scanner(System.in);
        boolean yes=false,yes2=false;
        Coordinate coord;
        System.out.println("Enter a coordinate: ");
        do {
            if (yes){
                System.err.println("Coordinate out of bounds");
            }
            String cord;
            do {
                if (yes2){
                    System.err.println("Coordinate incorrect try: (Letter(A-H)/Number(1-8))");
                }
                cord = sc.nextLine();
            }while ( yes2 = !(cord.length()==2));
            char c1 = cord.toUpperCase().charAt(0);
            int c2 = cord.charAt(1)-48;
            coord = new Coordinate(c1,c2);
        }while (yes = !tablero.contains(coord));
        return coord;
    }


    @Override
    public String toString(){
        return getTablero()+"";
    }
}
