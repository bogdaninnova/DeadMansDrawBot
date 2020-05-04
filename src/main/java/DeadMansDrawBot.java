import com.vdurmont.emoji.EmojiParser;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class DeadMansDrawBot extends TelegramLongPollingBot {

    private final String BRIEFCASE_EMOJI = ":briefcase:";
    private final String OCTOPUS_EMOJI = ":octopus:";
    private final String ANCHOR_EMOJI = ":anchor:";
    private final String PICK_EMOJI = ":pick:";
    private final String DAGGER_EMOJI = ":dagger:";
    private final String OLD_KEY_EMOJI = ":old_key:";
    private final String CRYSTAL_BALL_EMOJI = ":crystal_ball:";
    private final String BOMB_EMOJI = ":bomb:";
    private final String WORLD_MAP_EMOJI = ":world_map:";
    private final String MERMAID_EMOJI = ":mermaid:";
    private final String TWO_EMOJI = ":two:";
    private final String THREE_EMOJI = ":three:";
    private final String FOUR_EMOJI = ":four:";
    private final String FIVE_EMOJI = ":five:";
    private final String SIX_EMOJI = ":six:";
    private final String SEVEN_EMOJI = ":seven:";
    private final String EIGHT_EMOJI = ":eight:";
    private final String NINE_EMOJI = ":nine:";



    @Override
    public void onUpdateReceived(Update update) {

        String text = update.getMessage().getText();
        User user = update.getMessage().getFrom();
        long chatId = update.getMessage().getChatId();

        String pics = EmojiParser.parseToUnicode(
                BRIEFCASE_EMOJI +
                        OCTOPUS_EMOJI +
                        ANCHOR_EMOJI +
                        PICK_EMOJI +
                        DAGGER_EMOJI +
                        OLD_KEY_EMOJI +
                        CRYSTAL_BALL_EMOJI +
                        BOMB_EMOJI +
                        WORLD_MAP_EMOJI +
                        MERMAID_EMOJI
        );
        String numbers = EmojiParser.parseToUnicode(
                TWO_EMOJI +
                        THREE_EMOJI +
                        FOUR_EMOJI +
                        FIVE_EMOJI +
                        SIX_EMOJI +
                        SEVEN_EMOJI +
                        EIGHT_EMOJI +
                        NINE_EMOJI
        );
        sendSimpleMessage(pics, chatId);
        sendSimpleMessage(numbers, chatId);

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
