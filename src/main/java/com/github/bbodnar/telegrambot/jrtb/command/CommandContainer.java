package com.github.bbodnar.telegrambot.jrtb.command;

import com.github.bbodnar.telegrambot.jrtb.service.SendBotMessageService;
import com.google.common.collect.ImmutableMap;


import static com.github.bbodnar.telegrambot.jrtb.command.CommandName.*;

/**
 * Container of the {@link Command}s, which are using for handling telegram commands.
 */
public class CommandContainer {

    private final ImmutableMap commandMap;
    private final Command unknownCommand;

    public CommandContainer(SendBotMessageService sendBotMessageService) {
        commandMap = ImmutableMap.builder()
                .put(START.getCommandName(), new StartCommand(sendBotMessageService))
                .put(STOP.getCommandName(), new StopCommand(sendBotMessageService))
                .put(HELP.getCommandName(), new HelpCommand(sendBotMessageService))
                .put(NO.getCommandName(), new NoCommand(sendBotMessageService))
                .build();

        unknownCommand = new UnknownCommand(sendBotMessageService);
    }

    public Command retrieveCommand(String commandIdentifier) {
        return (Command) commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }
}
