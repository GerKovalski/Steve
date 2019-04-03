package com.javacore.steve.command;

public abstract class ACommand {
    protected String name;

    public ACommand(String name) {
        this.name = name;
    }
    public void execute() {
        System.out.println("Command " + name + " not supported!");
    }

}
