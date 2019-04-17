package com.javacore.steve;

import com.javacore.steve.db.Record;
import com.javacore.steve.db.Table;
import com.javacore.steve.state.ApplicationState;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static public final String APP_NAME = "Steve";
    static public final String AUTHOR = "Author";
    static public final String VERSION = "1.0";

    static ApplicationState currentState;

    public static void main(String[] args) {

        List<String> columns = new ArrayList<>();
        columns.add("id");
        columns.add("firstName");
        columns.add("lastName");
        Table criminalTable = new Table("Criminals", columns);
        List<String> values = new ArrayList<>();
        values.add("1");
        values.add("Ivan");
        values.add("Ivanov");
        List<String> values1 = new ArrayList<>();
        values1.add("2");
        values1.add("Petr");
        values1.add("Petrov");
        criminalTable.insert(new Record(values));
        criminalTable.insert(new Record(values1));

        List<String> result = criminalTable.selectField("firstName");
        System.out.println(result.toString());

//Рисование круга и квадртаа в консоли
//        ConsoleCanvas consoleCanvas = new ConsoleCanvas(15,15);
//        consoleCanvas.drawSquareAt(0,0,2);
//        consoleCanvas.drawCircleAt(6,6,5);
//        consoleCanvas.draw();


//MVC
//        ProfileController profileController = new ProfileController();
//        profileController.showProfile(5);

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
        if (currentState != null) {
            currentState.exit();
        }
        currentState = newState;
        newState.enter(commandName);
    }

}
