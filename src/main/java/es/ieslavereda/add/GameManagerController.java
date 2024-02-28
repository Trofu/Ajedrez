//package es.ieslavereda.add;
//
//
//import es.ieslavereda.chess.model.Message;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.net.Socket;
//
//public class GameManagerController implements Runnable {
//
//    static Logger logger = LoggerFactory.getLogger(GameManagerController.class);
//    private final Socket socket;
//    private final ServerController chessServer;
//
//    public GameManagerController(Socket socket, ServerController chessServer) {
//        this.socket = socket;
//        this.chessServer = chessServer;
//    }
//
//    public void run() {
//
//        logger.info(" -> Connection successful from IP " + socket.getRemoteSocketAddress().toString());
//        try {
//
//            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
//            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
//
//            Message mOut = null, mIn;
//            MessageManagementController gm = new MessageManagementController(socket, oos, ois, chessServer);
//            boolean exit = false;
//
//            while (!exit && (mIn = (Message) ois.readObject()) != null) {
//
//                logger.info("<- GameManager receives the message: " + mIn);
//
//                mOut = gm.processInput(mIn);
//
//                logger.info("-> GameManager send the message: " + mOut);
//
//                oos.writeObject(mOut);
//
//                // Cases in which we decided to close GameManager
//                switch (mOut.getMessageType()) {
//
//                    case GAME_CREATED_WAITING:
//                    case ADDED_TO_GAME:
//                    case NOT_ADDED:
//                        exit = true;
//                    default:
//                        break;
//                }
//            }
//
//            // If both players are already in the game, we start
//            if ((mOut != null ? mOut.getMessageType() : null) == Message.Type.ADDED_TO_GAME) {
//                chessServer.startGame(mOut.getGameId());
//            }
//
//            logger.info("GameManager finalize for the IP " + socket.getRemoteSocketAddress().toString());
//
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//}