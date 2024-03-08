package es.ieslavereda.View;

import es.ieslavereda.Controller.Juego;
import es.ieslavereda.Controller.Files;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Files load = new Files();
        Juego game = load.loadGame();
        if (game != null){
            game.playGame();
        }else {
            Juego j1 = new Juego();
            j1.playGame();
        }
    }
};
