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

    public static Juego loadGame(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to load a game? (YES/NO)");
        String maybe = sc.nextLine();
        try{
            if (maybe.equalsIgnoreCase("YES")){
                System.out.println("What is the name of the game? ");
                String game = sc.nextLine();
                return load(game);
            }
        } catch (ClassNotFoundException e){
            System.out.println("Cant load game, Start a new game");
        }catch (IOException e){
            System.out.println("This game dont exist, Start a new game");
        }
        return null;
    }

    public static boolean saveGame(Juego juego) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want save a game? (YES/NO)");
        String maybe = sc.nextLine();
        try {
            if (maybe.equalsIgnoreCase("YES")){
                System.out.println("What is the name of the game? ");
                String game = sc.nextLine();
                save(game,juego);
                return true;
            }
            return false;
        }catch (IOException e){
            System.out.println("You can't save this game");
        }
        return false;

    }


}
