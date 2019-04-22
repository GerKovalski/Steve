package com.javacore.steve;

import com.javacore.steve.common.ConsoleCanvas;
import com.javacore.steve.db.DataBase;
import com.javacore.steve.db.Record;
import com.javacore.steve.db.Table;
import com.javacore.steve.state.ApplicationState;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    static public final String APP_NAME = "Steve";
    static public final String AUTHOR = "Author";
    static public final String VERSION = "1.0";

    static ApplicationState currentState;

    static public final String ALLOWEd_DOMAIN_NAMES = "^([a-zA-Z0-9]+\\.)+[a-zA-Z]+$";

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("developer.apple.com");
        list.add("google.com");
        list.add("wrong.");
        list.add(".another");
        list.add("this is wrong domain name");
        list.add("nasa.gov");
        list.add("yandex.ru");
        list.add("mail.ru");
        list.add("login.cincodias.elpais.com");

        printList(list, ALLOWEd_DOMAIN_NAMES);

    }

        public static void printList(List<String> list, String filter) {
            for (String s:list) {
                if (s.matches(filter)) {
                    System.out.println(s);
                }
            }
        }


//Работа с базой данных
//        List<String[]> records = DataBase.readDataFile("/Users/fima/Desktop/Рабочий стол — MacBook Air — Фёдор/EPAM/Steve/src/com/javacore/steve/DB.txt");
//        Table table = new Table("Criminals", Arrays.asList(new String[]{"id", "name", "deceased"}));
//        for (String[] s: records) {
//            Record record = new Record(table);
//            record.setValues(s);
//            table.insert(record);
//        }
//        Record record = new Record(table);
//        record.setValues(new String[]{"100", "Ivan", "false"});
//        try {
//            System.out.println(record.getInt("id"));
//            System.out.println(record.getBoolean("deceased"));
//        } catch (Record.FieldNotFoundException e) {
//            e.printStackTrace();
//        }
//        catch (NumberFormatException nfe) {
//            nfe.printStackTrace();
//        }

//К мониторам и многопоточности
//        DataBase dataBase = new DataBase();
//
//        Thread thread1 = new Thread() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                }
//                dataBase.select();
//            }
//        };
//
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                dataBase.update();
//            }
//        };
//
//        thread1.start();
//        new Thread(runnable).start();

//База данных
//        List<String> columns = new ArrayList<>();
//        columns.add("id");
//        columns.add("firstName");
//        columns.add("lastName");
//        Table criminalTable = new Table("Criminals", columns);
//        List<String> values = new ArrayList<>();
//        values.add("1");
//        values.add("Ivan");
//        values.add("Ivanov");
//        List<String> values1 = new ArrayList<>();
//        values1.add("2");
//        values1.add("Petr");
//        values1.add("Petrov");
//        criminalTable.insert(new Record(values));
//        criminalTable.insert(new Record(values1));
//
//        List<String> result = criminalTable.selectField("firstName");
//        System.out.println(result.toString());

//Рисование круга и квадртаа в консоли
//        ConsoleCanvas consoleCanvas = new ConsoleCanvas(100,100);
//        consoleCanvas.drawSquareAt(0,0,2);
//        consoleCanvas.drawCircleAt(37,37,25);
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


    public static void changeState(ApplicationState newState, String commandName) {
        if (currentState != null) {
            currentState.exit();
        }
        currentState = newState;
        newState.enter(commandName);
    }

}
