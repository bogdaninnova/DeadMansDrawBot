import org.telegram.telegrambots.meta.api.objects.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class Player {

    private User user;
    private ArrayList<Card> cards = new ArrayList<>();

    public Player(User user) {
        setUser(user);
    }

    public void addCards(ArrayList<Card> cards) {
        this.cards.addAll(cards);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public String getAllCardsToString() {
        HashMap<String, ArrayList<Integer>> map = getAllCards();

        StringBuilder sb = new StringBuilder();
        for (String picture : map.keySet()) {
            sb.append(picture);
            Collections.sort(map.get(picture));
            for (int number : map.get(picture))
                sb.append(Card.getStringNumber(number));
            sb.append("\n");
        }
        return sb.toString();
    }

    public HashMap<String, ArrayList<Integer>> getAllCards() {
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();

        for (Card card : cards) {
            if (map.containsKey(card.getPicture())) {
                map.get(card.getPicture()).add(card.getNumber());
            } else {
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(card.getNumber());
                map.put(card.getPicture(), arrayList);
            }
        }
        return map;
    }
}
