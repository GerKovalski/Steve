package com.javacore.steve.command;

import static com.javacore.steve.Application.VERSION;

public class CommandVersion extends ACommand {

    public CommandVersion(String name) {
        super(name);
    }

    @Override
    public void execute() {
        System.out.println("Version is " + VERSION);
    }
}
