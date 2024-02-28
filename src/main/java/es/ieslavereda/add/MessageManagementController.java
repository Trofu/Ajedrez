//package es.ieslavereda.add;
//
//
//import es.ieslavereda.chess.model.Message;
//import es.ieslavereda.chess.model.Message.Type;
//import es.ieslavereda.chess.model.Player;
//import es.ieslavereda.chess.model.pieces.PieceColor;
//
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.net.Socket;
//import java.util.Map;
//import java.util.TreeMap;
//
//public class MessageManagementController {
//
//    private final Socket socket;
//    private final ObjectOutputStream oos;
//    private final ObjectInputStream ois;
//    private final ServerController chessServer;
//    private ServerGameController game;
//
//    public MessageManagementController(Socket socket, ObjectOutputStream oos, ObjectInputStream ois, ServerController chessServer) {
//
//        this.socket = socket;
//        this.oos = oos;
//        this.ois = ois;
//        this.chessServer = chessServer;
//
//    }
//
//    public Message processInput(Message m) {
//
//        Message mContestacion = null;
//
//        switch (m.getMessageType()) {
//
//            case CREATE_GAME:
//                mContestacion = createGame(m);
//                break;
//            case ADD_TO_GAME:
//                mContestacion = addToGame(m);
//                break;
//            case GET_CREATED_GAMES:
//                mContestacion = new Message(Message.Type.LIST_GAMES, "List of games");
//                mContestacion.setListOfGames(listGame());
//                break;
//            default:
//                break;
//        }
//
//        return mContestacion;
//    }
//
//    private Message addToGame(Message m) {
//
//        ServerGameController game;
//        Message mOut;
//        Player player = m.getPlayer();
//
//        player.setOos(oos);
//        player.setOis(ois);
//
//        game = chessServer.addPlayerToPlay(m.getGameId(), player);
//
//        if (game != null) {
//            mOut = new Message(Type.ADDED_TO_GAME, "Added to the game " + m.getGameId());
//            mOut.setGameId(m.getGameId());
//
//        } else {
//            mOut = new Message(Type.NOT_ADDED,
//                    "Not added to the game " + m.getGameId() + " , the game has already started.");
//        }
//
//        return mOut;
//    }
//
//    private Map<Integer, String[]> listGame() {
//        String[] gameInfo;
//        ServerGameController game;
//        Map<Integer, String[]> summary = new TreeMap<>();
//        Map<Integer, ServerGameController> games = chessServer.getWaitingGames();
//
//        // TO DO
//        // Create a Map<Integer, String[]>  where the key is the gameId
//        // and the array contains the name of the white player in the position 0
//        // of the array, and the name of the black player is placed int the position 1
//        // Finally, you have to return the map.
//
//        return summary;
//    }
//
//    private Message createGame(Message m) {
//
//        Message mOut;
//        Player player;
//
//        if (m.getPlayer() == null) {
//            mOut = new Message(Type.ASKING_FOR_PLAYER, "Asking for player");
//            mOut.setGameId(game.getIdGame());
//        } else {
//
//            game = new ServerGameController(chessServer);
//            player = m.getPlayer();
//            m.getPlayer().setOos(oos);
//            m.getPlayer().setOis(ois);
//
//            if (player.getColor() == PieceColor.WHITE)
//                game.setWhite(player);
//            else
//                game.setBlack(player);
//
//            chessServer.addGame(game);
//            mOut = new Message(Type.GAME_CREATED_WAITING,
//                    "Game created as id " + game.getIdGame() + ".\n" + "Wait to start playing...");
//            mOut.setGameId(game.getIdGame());
//        }
//
//        return mOut;
//    }
//
//}
