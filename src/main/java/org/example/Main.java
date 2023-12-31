package org.example;

import com.vdurmont.emoji.EmojiParser;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        Bot bot = new Bot();                  // We moved this line out of the register method, to access it later
        botsApi.registerBot(bot);
        bot.sendText(692500222L, "Hello World!");  // The L just turns the Integer into a Long
        bot.sendSticker(692500222L, EmojiParser.parseToUnicode(":blush:")); // The L just turns the Integer into a Long
        bot.sendDice(692500222L, "\uD83C\uDFAF");  // The L just turns the Integer into a Long
        bot.sendPhoto(692500222L, "C:/Users/User/Desktop/JPEG_example_flower.jpg", "Просто JPEG файл");
    }
}