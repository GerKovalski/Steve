package com.javacore.steve;

import com.javacore.steve.command.ACommand;
import com.javacore.steve.command.CommandRegistry;

public class Application {
    static public final String APP_NAME = "Steve";
    static public final String AUTHOR = "Author";
    static public final String VERSION = "1.0";

    public static void main(String[] args) {
        ACommand command = new ACommand("awd") {};
        System.out.println("Hello, my name is " + APP_NAME);
        System.out.println("My author is " + AUTHOR);
        String commandName = "version";
//        if (CommandRegistry.INSTANCE.hasCommand(commandName)) {
//            ACommand command = CommandRegistry.INSTANCE.getCommand(commandName);
//            command.execute();
//        }
        ACommand command = CommandRegistry.INSTANCE.getCommand(commandName);
        command.execute();
        commandName = "father";
        command = CommandRegistry.INSTANCE.getCommand(commandName);
        command.execute();
        CommandRegistry.INSTANCE.listCommands();
    }

}
