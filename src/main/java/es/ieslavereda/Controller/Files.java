package es.ieslavereda.Controller;

import java.io.*;
import java.util.Scanner;

public class Files {

    private static String ruta = "src/main/java/es/ieslavereda/games/";

    public static Juego load(String name) throws IOException,ClassNotFoundException{
        try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(ruta+name+".dat")))){
            return (Juego) ois.readObject();
        }
    }

    public static void save(String name, Juego game) throws IOException {
        try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(ruta+name+".dat")))){
            oos.writeObject(game);
        }
    }

    public static Juego loadGame() throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you wanna load a game? (YES/NO)");
        String maybe = sc.nextLine();
        if (maybe.equalsIgnoreCase("YES")){
            System.out.println("What is the name of the game? ");
            String game = sc.nextLine();
            return load(game);
        }else {
            return null;
        }
    }

    public static boolean saveGame(Juego juego) throws IOException  {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you wanna save a game? (YES/NO)");
        String maybe = sc.nextLine();
        if (maybe.equalsIgnoreCase("YES")){
            System.out.println("What is the name of the game? ");
            String game = sc.nextLine();
            save(game,juego);
            return true;
        }
        return false;
    }


}
