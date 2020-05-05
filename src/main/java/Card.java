public class Card {

    private String picture;
    private int number;

    public Card(String picture, int number) {
        setPicture(picture);
        setNumber(number);
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return picture + getStringNumber(number);
    }

    public static String getStringNumber(int number) {
        String result;
        switch (number) {
            case 2 : result = Const.TWO_EMOJI; break;
            case 3 : result = Const.THREE_EMOJI; break;
            case 4 : result = Const.FOUR_EMOJI; break;
            case 5 : result = Const.FIVE_EMOJI; break;
            case 6 : result = Const.SIX_EMOJI; break;
            case 7 : result = Const.SEVEN_EMOJI; break;
            case 8 : result = Const.EIGHT_EMOJI; break;
            case 9 : result = Const.NINE_EMOJI; break;
            default: result = "unknown";
        }
        return result;
    }
}
