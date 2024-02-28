//package es.ieslavereda.add;
//
//import java.io.Serializable;
//import java.util.Map;
//import java.util.TreeMap;
//
//public class Message implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//
//    public static enum Type {
//        CREATE_GAME,
//        NOT_CREATED,
//        GAME_CREATED_WAITING,
//        GET_CREATED_GAMES,
//        LIST_GAMES,
//        ADD_TO_GAME,
//        ADDED_TO_GAME,
//        NOT_ADDED,
//        ASKING_FOR_PLAYER,
//        GAME_INFORMATION,
//        COORDINATE_REQUEST,
//        SEND_COORDINATE
//    }
//
//    private String description;
//    private int gameId;
//    private Type messageType;
//    private String information;
//    private Player player;
//    private Map<Integer, String[]> listOfGames;
//    private Coordinate coordinate;
//
//    public Message(Type messageType, String description) {
//        this.description = description;
//        this.messageType = messageType;
//        this.gameId = 0;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public Type getMessageType() {
//        return messageType;
//    }
//
//    public int getGameId() {
//        return gameId;
//    }
//
//    public void setGameId(int gameId) {
//        this.gameId = gameId;
//    }
//
//    public String getInformation() {
//        return information;
//    }
//
//    public void setInformation(String informacion) {
//        this.information = informacion;
//    }
//
//    public Player getPlayer() {
//        return player;
//    }
//
//    public void setPlayer(Player player) {
//        this.player = player;
//    }
//
//    public Map<Integer, String[]> getListOfGames() {
//        return listOfGames;
//    }
//
//    public void setListOfGames(Map<Integer, String[]> listado) {
//        this.listOfGames = listado;
//    }
//
//    public Coordinate getCoordinate() {
//        return coordinate;
//    }
//
//    public void setCoordinate(Coordinate coordinate) {
//        this.coordinate = coordinate;
//    }
//
//    @Override
//    public String toString() {
//        String list="";
//        if(listOfGames!=null){
//            for(Integer key:listOfGames.keySet()){
//                list+= "["+key+"="+"White:"+ listOfGames.get(key)[0]+ "-Black:"+ listOfGames.get(key)[1] +"]," ;
//            }
//            list=list.substring(0, list.length()-1); // remove last character ','
//            list="["+list+"]";
//        }
//        return "Message ["+
//                ((description!=null)?"description=" + description.replaceAll("\n", ""):"") +
//                ((gameId!=0)?", gameId=" + gameId:"")+
//                ((messageType!=null)?", messageType=" + messageType:"")	+
//                ((information!=null)?", information=skipped game information":"") +
//                ((player!=null)?", player=" + player.getName()+", color="+ player.getColor() +", IP="+ player.getIp().getHostAddress():"") +
//                ((listOfGames!=null)?", listOfGames=" + list:"") +
//                "]";
//    }
//}