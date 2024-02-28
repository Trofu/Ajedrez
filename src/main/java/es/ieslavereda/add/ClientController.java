//package es.ieslavereda.add;
//
//import es.ieslavereda.chess.model.Coordinate;
//import es.ieslavereda.chess.model.Input;
//import es.ieslavereda.chess.model.Message;
//import es.ieslavereda.chess.model.Player;
//import es.ieslavereda.chess.model.pieces.PieceColor;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.net.Socket;
//import java.util.Map;
//import java.util.TreeMap;
//
//public class ClientController {
//
//    static Logger logger = LoggerFactory.getLogger(ClientController.class);
//    private Socket socket;
//    private ObjectOutputStream oos;
//    private ObjectInputStream ois;
//
//    public void start() {
//        Input sc = new Input();
//        int option;
//
//        do {
//            showStartMenu();
//            option = sc.getInt("Enter option (0-Exit):");
//            switch (option) {
//                case 1:
//                    connect();
//                    createGame();
//                    break;
//                case 2:
//                    connect();
//                    addToGame();
//                    break;
//                default:
//                    showStartMenu();
//                    System.out.println("Option not valid. Enter option (0-Exit):");
//                    break;
//            }
//        } while (option != 0);
//
//    }
//
//    private void createGame() {
//
//        Message mOut, mIn;
//        Player player = getPlayer();
//
//        connect();
//
//        mOut = new Message(Message.Type.CREATE_GAME, "Create game for " + player.getName());
//        mOut.setPlayer(player);
//        mIn = sendMessageAndWaitResponse(mOut);
//
//        if (mIn.getMessageType() == Message.Type.GAME_CREATED_WAITING) {
//            System.out.println(mIn.getDescription());
//            play();
//        } else {
//            showStartMenu();
//            System.out.println("The game could not be created.");
//        }
//
//    }
//
//    private void addToGame() {
//
//        Input sc = new Input();
//        Message mOut, mIn;
//        Player jugador = getPlayer();
//        int game;
//
//        mOut = new Message(Message.Type.GET_CREATED_GAMES,
//                "Requesting the list of games waiting for the player " + jugador.getName());
//        mOut.setPlayer(jugador);
//
//        mIn = sendMessageAndWaitResponse(mOut);
//        Map<Integer, String[]> games = mIn.getListOfGames();
//        Map<Integer, String[]> gamesForPlayer = new TreeMap<>();
//
//        // TO DO
//        // Put in gamesForPlayer only the games for player
//
//        do {
//            showGames(gamesForPlayer);
//            game = sc.getInt("Select the id of the desired game");
//            if (!mIn.getListOfGames().containsKey(game))
//                System.out.println("The game does not exist.");
//
//        } while (!mIn.getListOfGames().containsKey(game) && game != 0);
//
//        mOut = new Message(Message.Type.ADD_TO_GAME, "Requesting to add the player " + jugador.getName() + " to the game " + game);
//        mOut.setGameId(game);
//        mOut.setPlayer(jugador);
//
//        mIn = sendMessageAndWaitResponse(mOut);
//        if (mIn.getMessageType() == Message.Type.ADDED_TO_GAME)
//            play();
//
//    }
//
//    private Player getPlayer() {
//
//        // TO DO
//        // Ask the user and create the player
//
//        Player player = new Player(name, color,socket.getLocalAddress());
//
//        return player;
//    }
//
//    private void play() {
//
//        try {
//
//            Message mOut, mIn;
//            Input sc = new Input();
//            Coordinate c;
//
//            while ((mIn = (Message) ois.readObject()) != null) {
//
//                if (mIn.getMessageType() == Message.Type.GAME_INFORMATION) {
//                    update();
//                    System.out.println(mIn.getInformation());
//                } else if (mIn.getMessageType() == Message.Type.COORDINATE_REQUEST) {
//
//                    // TO DO
//                    // Get a coordinate and create a message to send using oos
//                    // You have to use the correct Message.Type
//                }
//            }
//
//        } catch (ClassNotFoundException | IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    private Message sendMessageAndWaitResponse(Message mOut) {
//
//        Message mIn = null;
//
//        try {
//
//            oos.writeObject(mOut);
//            mIn = (Message) ois.readObject();
//
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        return mIn;
//    }
//
//    private void connect() {
//
//        Input sc = new Input();
//
//        while (socket == null) {
//
//            String ip = sc.getString("Enter the server IP: ");
//            int port = sc.getInt("Enter the port: ");
//
//            try {
//
//                // TO DO
//                // Inicialize the socket for the correct IP and Port
//                // Set oos and ois from the socket to send and receive objects
//
//
//                logger.info("Connection made successfully.");
//
//            } catch (IOException e) {
//                logger.error(e.getMessage());
//            }
//
//            if (socket == null)
//                logger.info("Could not connect to the server.");
//        }
//    }
//
//    private void showStartMenu() {
//
//        update();
//        System.out.println(" ╔════════════════════════════╗");
//        System.out.println(" ║            Menu            ║");
//        System.out.println(" ╟────────────────────────────╢");
//        System.out.println(" ║      1- Create game        ║");
//        System.out.println(" ║      2- Add to game        ║");
//        System.out.println(" ╟────────────────────────────╢");
//        System.out.println(" ║      0- Exit               ║");
//        System.out.println(" ╚════════════════════════════╝");
//
//    }
//
//    private void showGames(Map<Integer, String[]> listado) {
//
//        update();
//        System.out.println("────────────────────────────────────────────");
//        System.out.println("                 Game list                  ");
//        System.out.println("────────────────────────────────────────────");
//        for (Integer key : listado.keySet()) {
//            System.out.println(
//                    "Id: " + key + "   Whites: " + ((listado.get(key)[0] != null) ? listado.get(key)[0] : "          ")
//                            + "   Blacks: " + ((listado.get(key)[1] != null) ? listado.get(key)[1] : "          "));
//        }
//        System.out.println("────────────────────────────────────────────");
//
//    }
//
//    private void update() {
//        System.out.flush();
//    }
//
//}
