//package es.ieslavereda.add;
//
//import es.ieslavereda.chess.model.Board;
//import es.ieslavereda.chess.model.Coordinate;
//import es.ieslavereda.chess.model.Player;
//import es.ieslavereda.chess.model.SocketCommunication;
//import es.ieslavereda.chess.model.pieces.Piece;
//import es.ieslavereda.chess.model.pieces.PieceColor;
//import es.ieslavereda.chess.view.Screen;
//
//import java.io.IOException;
//import java.io.Serializable;
//
//import static es.ieslavereda.chess.model.pieces.PieceColor.BLACK;
//import static es.ieslavereda.chess.model.pieces.PieceColor.WHITE;
//
//public class ServerGameController implements Serializable, Runnable {
//
//    private static final long serialVersionUID = 1L;
//    private final int idGame;
//    private Player white;
//    private Player black;
//    private final Board board;
//    private final ServerController chessServer;
//    private PieceColor turn;
//    private final SocketCommunication sc;
//
//    public ServerGameController(ServerController server) {
//        this.chessServer = server;
//        sc = new SocketCommunication(this);
//        this.idGame = server.getNewIdGame();
//        board = new Board();
//        board.placePieces();
//        turn = PieceColor.WHITE;
//    }
//
//    public Player getWhite() {
//        return white;
//    }
//
//    public Player getBlack() {
//        return black;
//    }
//
//    public void setWhite(Player white) {
//        this.white = white;
//    }
//
//    public void setBlack(Player black) {
//        this.black = black;
//    }
//
//    private String screenFor(Player player) {
//        return "\033[H\033[2J" + Screen.getView(board, player.getColor());
//    }
//
//    public int getIdGame() {
//        return idGame;
//    }
//
//    public void run() {
//
//        sc.sendInformation("Let's go.");
//
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e1) {
//            e1.printStackTrace();
//        }
//
//        sc.sendInformation(white, screenFor(white));
//        sc.sendInformation(black, screenFor(black));
//
//        // TO DO
//        // Game
//
//        if (board.checkmate(BLACK))
//            sc.sendInformation(PieceColor.WHITE + " wins.");
//        else
//            sc.sendInformation(PieceColor.BLACK + " wins.");
//
//
//        white.closeStreams();
//        black.closeStreams();
//        chessServer.gameFinish(idGame);
//    }
//
//    private void changeTrun() {
//        turn = turn.next();
//    }
//
//    private void movePiece() {
//
//        Player player = (turn == WHITE) ? white : black;
//        Coordinate c;
//        Piece p;
//
//        sc.sendInformation("Move -> " + player.getColor() + "  (" + player.getName() + ").");
//        sc.sendInformation(player, "Wait for the other player to finish moving...");
//
//        // GAME
//    }
//}