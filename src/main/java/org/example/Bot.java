package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

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

        System.out.println(user.getFirstName() + " wrote " + msg.getText());
    }
}