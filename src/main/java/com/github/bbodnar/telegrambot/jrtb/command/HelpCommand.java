package com.github.bbodnar.telegrambot.jrtb.command;

import com.github.bbodnar.telegrambot.jrtb.service.SendBotMessageService;
import lombok.AllArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.github.bbodnar.telegrambot.jrtb.command.CommandName.*;

/**
 * Help {@link Command}.
 */
@AllArgsConstructor
public class HelpCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    public static final String HELP_MESSAGE = String.format("✨Доступные команды✨\n\n"

                    + "Начать\\закончить работу с ботом\n"
                    + "%s - начать работу со мной\n"
                    + "%s - приостановить работу со мной\n\n"
                    + "%s - получить помощь в работе со мной\n",
            START.getCommandName(), STOP.getCommandName(), HELP.getCommandName());

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), HELP_MESSAGE);
    }
}
