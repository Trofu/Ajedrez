//package es.ieslavereda.add;
//
//import es.ieslavereda.chess.controller.ServerGameController;
//
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//
//public class SocketCommunication {
//    private final ServerGameController serverGame;
//    public SocketCommunication(ServerGameController serverGame){
//        this.serverGame = serverGame;
//    }
//
//    public void sendInformation(String information) {
//        sendInformation(serverGame.getWhite(), information);
//        sendInformation(serverGame.getBlack(), information);
//    }
//
//    public void sendInformation(Player player, String information) {
//        try {
//            // TO DO
//            // Create a new Message of GAME_INFORMATION with the information
//            // and send it to the player
//
//            System.out.println("-> Game " + serverGame.getIdGame() + " send to " + player.getName() + " ("+player.getIp().getHostAddress()+") the message: " + mOut);
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//    }
//    public Coordinate requestCoordinate(Player player) {
//        Coordinate c = null;
//
//        try {
//
//            ObjectOutputStream oos = player.getOos();
//            ObjectInputStream ois = player.getOis();
//
//            Message mOut, mIn;
//
//            mOut = new Message(Message.Type.COORDINATE_REQUEST, "Requesting movement coordinate");
//            oos.writeObject(mOut);
//            System.out.println("-> Game " + serverGame.getIdGame() + " send the message: " + mOut);
//
//            mIn = (Message) ois.readObject();
//            System.out.println("<- Game " + serverGame.getIdGame() + " receives the message: " + mIn);
//
//            if (mIn.getMessageType() != Message.Type.SEND_COORDINATE) {
//                mOut = new Message(Message.Type.COORDINATE_REQUEST, "Requesting movement coordinate");
//                oos.writeObject(mOut);
//                System.out.println("-> Game " + serverGame.getIdGame() + " send the message: " + mOut);
//
//            } else {
//                c = mIn.getCoordinate();
//            }
//
//        } catch (IOException | ClassNotFoundException e) {
//
//            e.printStackTrace();
//        }
//
//        return c;
//    }
//}
