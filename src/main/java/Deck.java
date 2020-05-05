import java.util.*;

public class Deck {

    Random rand = new Random();

    private ArrayList<Card> newCards = new ArrayList<>();
    private ArrayList<Card> oldCards = new ArrayList<>();
    private ArrayList<Card> tableCards = new ArrayList<>();

    public Deck() {
        newCards.add(new Card(Const.BRIEFCASE_EMOJI, 3));
        newCards.add(new Card(Const.OCTOPUS_EMOJI, 3));
        newCards.add(new Card(Const.ANCHOR_EMOJI, 3));
        newCards.add(new Card(Const.PICK_EMOJI, 3));
        newCards.add(new Card(Const.DAGGER_EMOJI, 3));
        newCards.add(new Card(Const.OLD_KEY_EMOJI, 3));
        newCards.add(new Card(Const.CRYSTAL_BALL_EMOJI, 3));
        newCards.add(new Card(Const.BOMB_EMOJI, 3));
        newCards.add(new Card(Const.WORLD_MAP_EMOJI, 3));
        newCards.add(new Card(Const.MERMAID_EMOJI, 5));

        newCards.add(new Card(Const.BRIEFCASE_EMOJI, 4));
        newCards.add(new Card(Const.OCTOPUS_EMOJI, 4));
        newCards.add(new Card(Const.ANCHOR_EMOJI, 4));
        newCards.add(new Card(Const.PICK_EMOJI, 4));
        newCards.add(new Card(Const.DAGGER_EMOJI, 4));
        newCards.add(new Card(Const.OLD_KEY_EMOJI, 4));
        newCards.add(new Card(Const.CRYSTAL_BALL_EMOJI, 4));
        newCards.add(new Card(Const.BOMB_EMOJI, 4));
        newCards.add(new Card(Const.WORLD_MAP_EMOJI, 4));
        newCards.add(new Card(Const.MERMAID_EMOJI, 6));

        newCards.add(new Card(Const.BRIEFCASE_EMOJI, 5));
        newCards.add(new Card(Const.OCTOPUS_EMOJI, 5));
        newCards.add(new Card(Const.ANCHOR_EMOJI, 5));
        newCards.add(new Card(Const.PICK_EMOJI, 5));
        newCards.add(new Card(Const.DAGGER_EMOJI, 5));
        newCards.add(new Card(Const.OLD_KEY_EMOJI, 5));
        newCards.add(new Card(Const.CRYSTAL_BALL_EMOJI, 5));
        newCards.add(new Card(Const.BOMB_EMOJI, 5));
        newCards.add(new Card(Const.WORLD_MAP_EMOJI, 5));
        newCards.add(new Card(Const.MERMAID_EMOJI, 7));

        newCards.add(new Card(Const.BRIEFCASE_EMOJI, 6));
        newCards.add(new Card(Const.OCTOPUS_EMOJI, 6));
        newCards.add(new Card(Const.ANCHOR_EMOJI, 6));
        newCards.add(new Card(Const.PICK_EMOJI, 6));
        newCards.add(new Card(Const.DAGGER_EMOJI, 6));
        newCards.add(new Card(Const.OLD_KEY_EMOJI, 6));
        newCards.add(new Card(Const.CRYSTAL_BALL_EMOJI, 6));
        newCards.add(new Card(Const.BOMB_EMOJI, 6));
        newCards.add(new Card(Const.WORLD_MAP_EMOJI, 6));
        newCards.add(new Card(Const.MERMAID_EMOJI, 8));

        newCards.add(new Card(Const.BRIEFCASE_EMOJI, 7));
        newCards.add(new Card(Const.OCTOPUS_EMOJI, 7));
        newCards.add(new Card(Const.ANCHOR_EMOJI, 7));
        newCards.add(new Card(Const.PICK_EMOJI, 7));
        newCards.add(new Card(Const.DAGGER_EMOJI, 7));
        newCards.add(new Card(Const.OLD_KEY_EMOJI, 7));
        newCards.add(new Card(Const.CRYSTAL_BALL_EMOJI, 7));
        newCards.add(new Card(Const.BOMB_EMOJI, 7));
        newCards.add(new Card(Const.WORLD_MAP_EMOJI, 7));
        newCards.add(new Card(Const.MERMAID_EMOJI, 9));

        oldCards.add(new Card(Const.BRIEFCASE_EMOJI, 2));
        oldCards.add(new Card(Const.OCTOPUS_EMOJI, 2));
        oldCards.add(new Card(Const.ANCHOR_EMOJI, 2));
        oldCards.add(new Card(Const.PICK_EMOJI, 2));
        oldCards.add(new Card(Const.DAGGER_EMOJI, 2));
        oldCards.add(new Card(Const.OLD_KEY_EMOJI, 2));
        oldCards.add(new Card(Const.CRYSTAL_BALL_EMOJI, 2));
        oldCards.add(new Card(Const.BOMB_EMOJI, 2));
        oldCards.add(new Card(Const.WORLD_MAP_EMOJI, 2));
        oldCards.add(new Card(Const.MERMAID_EMOJI, 4));
    }

    public Card getCardFromDeck() {
        Card card = newCards.remove(rand.nextInt(newCards.size()));
        tableCards.add(card);
        return card;
    }

    public ArrayList<Card> getNewCards() {
        return newCards;
    }

    public void setNewCards(ArrayList<Card> newCards) {
        this.newCards = newCards;
    }

    public ArrayList<Card> getOldCards() {
        return oldCards;
    }


    public ArrayList<Card> getTableCards() {
        return tableCards;
    }

    public void setOldCards(ArrayList<Card> oldCards) {
        this.oldCards = oldCards;
    }

    public String getTableString() {
        if (tableCards.isEmpty())
            return "Table is empty!";

        StringBuilder sb = new StringBuilder();
        for (Card card : tableCards) {
            sb.append(card.toString());
            sb.append(" ");
        }
        return sb.toString();
    }

    public ArrayList<Card> takeTableCards() {
        ArrayList<Card> result = new ArrayList<>(tableCards);
        tableCards.clear();
        return result;
    }

    public void throwCardsToTrash() {
        oldCards.addAll(tableCards);
        tableCards.clear();
    }

    public boolean checkDuplicatesOnTable() {
        ArrayList<String> unique = new ArrayList<>();
        for (Card card : tableCards) {
            if (unique.contains(card.getPicture()))
                return true;
            unique.add(card.getPicture());
        }
        return false;
    }

}
