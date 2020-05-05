import com.vdurmont.emoji.EmojiParser;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeadMansDrawBot extends TelegramLongPollingBot {


    Deck deck = new Deck();
    Player player;

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage()) {

            String text = update.getMessage().getText();
            User user = update.getMessage().getFrom();
            long chatId = update.getMessage().getChatId();

            if (player == null)
                player = new Player(user);

            System.out.println(text);
            System.out.println(user);

            if (text.equals("/next")) {
                nextAction(chatId);
            }

            if (text.equals("/pass")) {
                passAction(chatId);
            }


            if (text.equals("/show")) {
                sendSimpleMessage(EmojiParser.parseToUnicode(player.getAllCardsToString()), chatId);
            }

            if (text.equals("test")) {
                sendInlineKeyBoardMessage(new ArrayList<>(player.getAllCards().keySet()), chatId);
            }
        } else if (update.hasCallbackQuery()) {
            long chatId = update.getCallbackQuery().getMessage().getChatId();
            String action = update.getCallbackQuery().getData();
            if (action.equals("More action"))
                nextAction(chatId);
            else if (action.equals("Pass action"))
                passAction(chatId);


        }






    }


    public void nextAction(long chatId) {
        deck.getCardFromDeck();

        if (deck.checkDuplicatesOnTable()) {
            sendSimpleMessage(EmojiParser.parseToUnicode(deck.getTableString()), chatId);
            sendSimpleMessage("You lost all!", chatId);
            deck.throwCardsToTrash();
        } else {
            ArrayList<String> resultTable = new ArrayList<>();

            for (Card card : deck.getTableCards())
                resultTable.add(card.toString());

            sendInlineKeyBoardMessage(resultTable, chatId);
        }
    }

    public void passAction(long chatId) {
        player.addCards(deck.takeTableCards());
        sendSimpleMessage(EmojiParser.parseToUnicode(player.getCards().toString()), chatId);
    }

    public void sendInlineKeyBoardMessage(ArrayList<String> list, long chatId) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();

        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow2 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow3 = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (i < 5)
                keyboardButtonsRow1.add(new InlineKeyboardButton().setText(EmojiParser.parseToUnicode((list.get(i)))).setCallbackData("action" + list.get(i)));
            else
                keyboardButtonsRow2.add(new InlineKeyboardButton().setText(EmojiParser.parseToUnicode((list.get(i)))).setCallbackData("action" + list.get(i)));
        }

        rowList.add(keyboardButtonsRow1);
        if (!keyboardButtonsRow2.isEmpty())
            rowList.add(keyboardButtonsRow2);

        keyboardButtonsRow3.add(new InlineKeyboardButton().setText("More").setCallbackData("More action"));
        keyboardButtonsRow3.add(new InlineKeyboardButton().setText("Pass").setCallbackData("Pass action"));
        rowList.add(keyboardButtonsRow3);

        inlineKeyboardMarkup.setKeyboard(rowList);

        try {
            execute(new SendMessage().setChatId(chatId).setText("Пример").setReplyMarkup(inlineKeyboardMarkup));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }


    private void sendSimpleMessage(String text, long chatId) {
        SendMessage message = new SendMessage().setChatId(chatId).setText(text);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "deadMansDrawBot";
    }

    @Override
    public String getBotToken() {
        return "1120984930:AAGL7OZj5qPdB_JK4jd_jgxaqjuOuCK32eM";
    }
}
