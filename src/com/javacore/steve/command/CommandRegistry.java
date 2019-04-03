package com.javacore.steve.command;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum CommandRegistry {
    INSTANCE;

    static Map<String, ACommand> commands;

    static {
        commands = new HashMap<>();
        CommandAuthor commandAuthor = new CommandAuthor("author");
        commands.put("version", new CommandVersion("version"));
        commands.put("author", commandAuthor);
        commands.put("creator", commandAuthor);
        commands.put("father", commandAuthor);
    }

    public boolean hasCommand (String name) {
        return commands.containsKey(name);
    }

    public ACommand getCommand(String name) {
        return commands.get(name);
    }

    public void listCommands() {
        Iterator iterator = commands.entrySet().iterator();
        System.out.println("List of commands");
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            System.out.println(entry.getKey());
        }
    }
}
