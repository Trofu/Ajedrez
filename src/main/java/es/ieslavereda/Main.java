package es.ieslavereda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        /*
        Board tablero = new Board();

        King reyB = new King(tablero,new Coordinate('D',1), King.Type.WHITE);
        King reyN = new King(tablero,new Coordinate('D',8), King.Type.BLACK);

        Queen reinaB = new Queen(tablero,new Coordinate('E',1), Queen.Type.WHITE);
        Queen reinaN = new Queen(tablero,new Coordinate('E',8), Queen.Type.BLACK);

        Bishop alfilN1 = new Bishop(tablero,new Coordinate('C',8), Bishop.Type.BLACK);
        Bishop alfilN2 = new Bishop(tablero,new Coordinate('F',8), Bishop.Type.BLACK);
        Bishop alfilB1 = new Bishop(tablero,new Coordinate('C',1), Bishop.Type.WHITE);
        Bishop alfilB2 = new Bishop(tablero,new Coordinate('F',1), Bishop.Type.WHITE);

        Knight caballoN1 = new Knight(tablero,new Coordinate('B',8), Knight.Type.BLACK);
        Knight caballoN2 = new Knight(tablero,new Coordinate('G',8), Knight.Type.BLACK);
        Knight caballoB1 = new Knight(tablero,new Coordinate('B',1), Knight.Type.WHITE);
        Knight caballoB2 = new Knight(tablero,new Coordinate('G',1), Knight.Type.WHITE);

        Rook torreN1 = new Rook(tablero,new Coordinate('A',8), Rook.Type.BLACK);
        Rook torreN2 = new Rook(tablero,new Coordinate('H',8), Rook.Type.BLACK);
        Rook torreB1 = new Rook(tablero,new Coordinate('A',1), Rook.Type.WHITE);
        Rook torreB2 = new Rook(tablero,new Coordinate('H',1), Rook.Type.WHITE);

        Pawn peonN1 = new Pawn(tablero,new Coordinate('A',7), Pawn.Type.BLACK);
        Pawn peonN2 = new Pawn(tablero,new Coordinate('B',7), Pawn.Type.BLACK);
        Pawn peonN3 = new Pawn(tablero,new Coordinate('C',7), Pawn.Type.BLACK);
        Pawn peonN4 = new Pawn(tablero,new Coordinate('D',7), Pawn.Type.BLACK);
        Pawn peonN5 = new Pawn(tablero,new Coordinate('E',7), Pawn.Type.BLACK);
        Pawn peonN6 = new Pawn(tablero,new Coordinate('F',7), Pawn.Type.BLACK);
        Pawn peonN7 = new Pawn(tablero,new Coordinate('G',7), Pawn.Type.BLACK);
        Pawn peonN8 = new Pawn(tablero,new Coordinate('H',7), Pawn.Type.BLACK);
        Pawn peonB1 = new Pawn(tablero,new Coordinate('A',2), Pawn.Type.WHITE);
        Pawn peonB2 = new Pawn(tablero,new Coordinate('B',2), Pawn.Type.WHITE);
        Pawn peonB3 = new Pawn(tablero,new Coordinate('C',2), Pawn.Type.WHITE);
        Pawn peonB4 = new Pawn(tablero,new Coordinate('D',2), Pawn.Type.WHITE);
        Pawn peonB5 = new Pawn(tablero,new Coordinate('E',2), Pawn.Type.WHITE);
        Pawn peonB6 = new Pawn(tablero,new Coordinate('F',2), Pawn.Type.WHITE);
        Pawn peonB7 = new Pawn(tablero,new Coordinate('G',2), Pawn.Type.WHITE);
        Pawn peonB8 = new Pawn(tablero,new Coordinate('H',2), Pawn.Type.WHITE);

        tablero.highLight(caballoB2.getNextMovements());
        System.out.println(tablero);
        tablero.highLight_out();
        caballoB2.moveTo(new Coordinate('F',3));
        tablero.highLight(caballoB2.getNextMovements());
        System.out.println(tablero);
        */
        String cord = sc.nextLine();
        Coordinate Jugador = new Coordinate(cord.charAt(0),cord.charAt(1)-48);

        Juego j1 = new Juego();
        j1.getTablero().highLight(j1.getPiezas().get("PB4").getNextMovements());
        System.out.println(j1.getTablero().toString());





    }
}
