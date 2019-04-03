package com.javacore.steve.command;

import static com.javacore.steve.Application.AUTHOR;

public class CommandAuthor extends ACommand {

    public CommandAuthor(String name) {
        super(name);
    }

    @Override
    public void execute() {
        System.out.println("My author: " + AUTHOR);
    }
}
