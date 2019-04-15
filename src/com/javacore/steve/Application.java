package com.javacore.steve;

import com.javacore.steve.command.ACommand;
import com.javacore.steve.command.CommandRegistry;
import com.javacore.steve.command.Tinterface;
import com.javacore.steve.profile.ProfileController;
import com.javacore.steve.profile.ProfileModel;
import com.javacore.steve.profile.ProfileView;
import com.javacore.steve.state.ApplicationState;
import com.javacore.steve.state.StateIdle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;

public class Application {
    static public final String APP_NAME = "Steve";
    static public final String AUTHOR = "Author";
    static public final String VERSION = "1.0";

    static ApplicationState cuurrentState;

    public static void main(String[] args) throws IOException {
        ProfileController profileController = new ProfileController();
        profileController.showProfile(5);

//State Pattern
//        changeState(new StateIdle(), "idle");
//        currentState = new StateIdle();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        while (true) {
//            String inputCommand = reader.readLine();
//            if (inputCommand.isEmpty() || !CommandRegistry.INSTANCE.hasCommand(inputCommand)) {
//                System.out.println("Input another command");
//                continue;
//            }
//            ACommand command = CommandRegistry.INSTANCE.getCommand(inputCommand);
//            command.execute();
//        }

        //        String commandName = "test command";
        //        cuurrentState.onCommand(commandName);
        //        for (int i = 0; i < 10; i++) {
        //            cuurrentState.onCommand(commandName + i);
        //        }

//К командам
//        ACommand command1 = new ACommand("awd") {
//            @Override
//            public void execute() {
//                System.out.println("123");
//            }
//        };
//        Tinterface tinterface = new Tinterface() {
//            @Override
//            public void execute() {
//                System.out.println("456");
//            }
//        };
//        tinterface.execute();
//        System.out.println("Hello, my name is " + APP_NAME);
//        System.out.println("My author is " + AUTHOR);
//        String commandName = "version";
////        if (CommandRegistry.INSTANCE.hasCommand(commandName)) {
////            ACommand command = CommandRegistry.INSTANCE.getCommand(commandName);
////            command.execute();
////        }
//        ACommand command = CommandRegistry.INSTANCE.getCommand(commandName);
//        command.execute();
//        commandName = "father";
//        command = CommandRegistry.INSTANCE.getCommand(commandName);
//        command.execute();
//        CommandRegistry.INSTANCE.listCommands();

    }

    public static void changeState(ApplicationState newState, String commandName) {
        if (cuurrentState != null) {
            cuurrentState.exit();
        }
        cuurrentState = newState;
        newState.enter(commandName);
    }

}
