package com.github.bbodnar.telegrambot.jrtb.service.impl;

import com.github.bbodnar.telegrambot.jrtb.bot.JavarushTelegramBot;
import com.github.bbodnar.telegrambot.jrtb.service.SendBotMessageService;
import lombok.AllArgsConstructor;
import org.jvnet.hk2.annotations.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * Implementation of {@link SendBotMessageService} interface.
 */
@Service
@AllArgsConstructor
public class SendBotMessageServiceImpl implements SendBotMessageService {

    private final JavarushTelegramBot javarushBot;

    @Override
    public void sendMessage(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);
        try {
            javarushBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            //TODO Add logging to the project.
            e.printStackTrace();
        }
    }
}
