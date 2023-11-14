package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendDice;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;

public class Bot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "TestTelegramBotJava";
    }

    @Override
    public String getBotToken() {
        return "6404701650:AAGO3oyq7K3h7oElgmiIMRTUPBZz5Z32OIo";
    }

    @Override
    public void onUpdateReceived(Update update) {
        var msg = update.getMessage();
        var user = msg.getFrom();
        var id = user.getId();

        sendText(id, msg.getText());

        System.out.println("First name: " + user.getFirstName() +
                " Last name: " + user.getLastName() + " Username: "
                + user.getUserName() + " User id: " + user.getId() +
                " Is user a bot: " + user.getIsBot() + " Language code: " +
                user.getLanguageCode() + " wrote " + msg.getText());
    }

    public void sendText(Long who, String what) {
        SendMessage sm = SendMessage.builder()
                .chatId(who.toString()) // Who are we sending a message to
                .text(what).build();    // Message content
        try {
            execute(sm);                        // Actually sending the message
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);      // Any error will be printed here
        }
    }

    public void sendSticker(Long who, String what) {
        SendMessage ss = SendMessage.builder()
                .chatId(who.toString()) // Who are we sending a message to
                .text(what).build();    // Sticker content
        try {
            execute(ss);                        // Actually sending the message
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);      // Any error will be printed here
        }
    }

    public void sendDice(Long who, String what) {
        SendDice sd = SendDice.builder()
                .chatId(who.toString())         // Who are we sending a message to
                .emoji(what).build();           // Emoji content
        try {
            execute(sd);                        // Actually sending the message
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);      // Any error will be printed here
        }
    }

    public void sendPhoto(Long who, String filePath, String caption) {
        // Создаем объект InputFile с файлом фото
        InputFile photo = new InputFile(new File(filePath));
        SendPhoto sph = SendPhoto.builder()
                .chatId(who.toString())
                .photo(photo)
                .caption(caption).build();
        try {
            execute(sph);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
