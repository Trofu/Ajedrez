package es.ieslavereda.Model;

import java.io.Serializable;

public class Coordinate implements Serializable {
    private char letter;
    private int number;

    public Coordinate(char letter, int number) {
        this.letter = String.valueOf(letter).toUpperCase().charAt(0);
        this.number = number;
    }

    public Coordinate up() {
        return new Coordinate(letter, number - 1);
    }

    public Coordinate down() {
        return new Coordinate(letter, number + 1);
    }

    public Coordinate left() {
        return new Coordinate((char) (letter - 1), number);
    }

    public Coordinate right() {
        return new Coordinate((char) (letter + 1), number);
    }

    public char getLetter() {
        return letter;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null)
            return false;
        return (obj instanceof Coordinate)?((Coordinate) obj).letter==letter && ((Coordinate) obj).number==number:false;
    }

    @Override
    public int hashCode() {
        return number+letter;
    }

    @Override
    public String toString() {
        return "(" + letter + "," + number + ")";
    }
}
