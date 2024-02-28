//package es.ieslavereda.add;
//
//import es.ieslavereda.chess.model.pieces.PieceColor;
//
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.io.Serializable;
//import java.net.InetAddress;
//import java.net.Socket;
//
//public class Player implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//    private String name;
//    private ObjectOutputStream oos;
//    private ObjectInputStream ois;
//    private InetAddress ip;
//    private PieceColor color;
//
//    public Player(String name,PieceColor color,InetAddress ip) {
//        this.color=color;
//        this.name=name;
//        this.ip=ip;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public InetAddress getIp() {
//        return ip;
//    }
//
//    public PieceColor getColor() {
//        return color;
//    }
//
//    public ObjectOutputStream getOos() {
//        return oos;
//    }
//
//    public ObjectInputStream getOis() {
//        return ois;
//    }
//
//    public void setOos(ObjectOutputStream oos) {
//        this.oos = oos;
//    }
//
//    public void setOis(ObjectInputStream ois) {
//        this.ois = ois;
//    }
//
//    @Override
//    public String toString() {
//        return "Player [name=" + name + ", oos=" + oos + ", ois=" + ois + ", ip=" + ip
//                + ", color=" + color + "]";
//    }
//
//    public void closeStreams() {
//        if(oos!=null) {
//            try {
//                oos.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        if(ois!=null) {
//            try {
//                ois.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
