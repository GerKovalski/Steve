package com.javacore.steve.state;

import com.javacore.steve.Application;

public class StateExecutingCommand extends ApplicationState {
    @Override
    public void enter(String commandName) {
        System.out.println("Entering State Executing Command..." + commandName);
        //get command by name
        //command execute
        executeCommand(commandName);
    }

    private void executeCommand(String commandName) {
        //code for executions
        Application.changeState(new StateIdle(), "idle");
    }

    @Override
    public void onCommand(String commandName) {
        System.out.println("Busy executing command..." + commandName + " has to wait!");
    }

    @Override
    public void exit() {
        System.out.println("Leaving state executing");
    }
}
