import java.util.ArrayList;

public class Game {

    private long chatId;
    private ArrayList<Player> players;

    public Game(long chatId, ArrayList<Player> players) {
        setChatId(chatId);
        setPlayers(players);
    }


    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
}
