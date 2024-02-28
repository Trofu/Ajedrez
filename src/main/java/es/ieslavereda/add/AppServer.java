//package es.ieslavereda.add;
//
//import es.ieslavereda.add.ServerController;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.util.logging.Level;
//
//public class AppServer {
//
//    static Logger logger = LoggerFactory.getLogger(AppServer.class);
//
//    public static void main (String[] args){
//
//        int port;
//
//        if(args.length==0){
//            port=6000;
//        }else{
//            try{
//                port = Integer.parseInt(args[0]);
//            }catch(Exception e){
//                port=6000;
//                logger.info("The server cannot start on the port " + args[0]);
//                logger.info("Trying to start on the port " + port);
//            }
//        }
//        ServerController chessServer = new ServerController(port);
//        chessServer.run();
//    }
//}
