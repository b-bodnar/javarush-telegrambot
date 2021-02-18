package com.github.bbodnar.telegrambot.jrtb.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Enumeration for {@link Command}'s.
 */
@Getter
@AllArgsConstructor
public enum CommandName {

    START("/start"),
    STOP("/stop"),
    HELP("/help"),
    NO("/no");

    private final String commandName;
}
