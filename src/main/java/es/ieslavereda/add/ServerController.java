//package es.ieslavereda.add;
//
//import es.ieslavereda.chess.model.Player;
//import es.ieslavereda.chess.model.pieces.PieceColor;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.IOException;
//import java.net.ServerSocket;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//public class ServerController {
//
//    static Logger logger = LoggerFactory.getLogger(ServerController.class);
//
//    private final Map<Integer, ServerGameController> games;
//
//    private int connectionsActives = 0;
//    private int newIdGame = 1;
//
//    private final int portNumber;
//
//    public ServerController(int port) {
//        games = new HashMap<>();
//        portNumber = port;
//    }
//
//    public void run() {
//
//        logger.info("ServerSocket started on the port " + portNumber);
//
//        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
//            do {
//                new Thread(new GameManagerController(serverSocket.accept(), this)).start();
//                logger.info("Connection nº: " + (++connectionsActives));
//            } while (true);
//        } catch (IOException e) {
//            logger.error("Server cannot listen on the port " + portNumber);
//            System.exit(-1);
//        }
//    }
//
//    public synchronized int getNewIdGame() {
//        return newIdGame++;
//    }
//
//    public void addGame(ServerGameController game) {
//        // TO DO
//        // Add the game to the collection
//    }
//
//    public synchronized ServerGameController addPlayerToPlay(int id, Player p) {
//
//        ServerGameController game;
//
//        synchronized (games) {
//
//            game = games.get(id);
//
//            if (game != null) {
//                if(p.getColor()== PieceColor.WHITE)
//                    game.setWhite(p);
//                else
//                    game.setBlack(p);
//            }
//        }
//        return game;
//    }
//    public synchronized void gameFinish(int id){
//        games.remove(id);
//    }
//
//    public void startGame(int key){
//        new Thread(games.get(key)).start();
//    }
//
//    public Map<Integer, ServerGameController> getWaitingGames() {
//
//        Map<Integer, ServerGameController> gamesWaiting = new HashMap<>();
//
//        // TO DO
//        // Return a Map with the games waiting. (back or white are null)
//
//        return gamesWaiting;
//    }
//
//}