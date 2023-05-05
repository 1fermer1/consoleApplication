package main;

import commandManager.CommandManager;
import commandManager.commands.ExecuteScriptCommand;
import commandManager.commands.HistoryCommand;
import commandManager.commands.ICommandable;
import commandManager.commands.SaveCommand;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class LauncherService {
    public static void init() {
        UserInputService.setMode(Mode.DEFAULT);
        //UserInputService.setScriptFile(new File("script.txt"));
        Arrays.fill(HistoryCommand.historyArray, "");
        System.out.println("welcome to los pollos hermanos");
        LauncherService.launcher();
    }

    public static void launcher() {
        while (true) {
            switch (UserInputService.getMode()) {
                case DEFAULT:
                    UserInputService.setBufferedReader(new BufferedReader(new InputStreamReader(System.in)));
                    while (true) {
                        defaultCommandExecute();
                    }
                case FILE:
                    try {
                        UserInputService.setBufferedReader(new BufferedReader(new InputStreamReader(new FileInputStream(UserInputService.getScriptFile()))));
                        fileCommandExecute();
                        if (!UserInputService.getScriptFile().exists() || !UserInputService.getScriptFile().isFile() || !UserInputService.getScriptFile().canRead()) {
                            System.out.println("File error");
                            return;
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("Ошибка обработки файла. Проверьте, корректно ли указано имя файла, а также права доступа к нему");
                    }
                    UserInputService.setMode(Mode.DEFAULT);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + UserInputService.getMode());
            }
        }
    }
    public static void fileCommandExecute() {
        LinkedHashMap<String, ICommandable> commands = new CommandManager().getCommands();
        String command;
        String[] splitCommand;
        try {
            command = "";
            while ((command = UserInputService.getBufferedReader().readLine()) != null && command.length() != 0) {
                splitCommand = command.split(" ");
                if (splitCommand.length == 1) {
                    commands.get(splitCommand[0]).execute("");
                } else {
                    commands.get(splitCommand[0]).execute(splitCommand[1]);
                }
                new HistoryCommand().pushLastCommand(splitCommand[0]);
            }
            UserInputService.setMode(Mode.DEFAULT);
            return;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void defaultCommandExecute() {
        LinkedHashMap<String, ICommandable> commands = new CommandManager().getCommands();
        String command;
        String[] splitCommand;
        try {
            command = UserInputService.getBufferedReader().readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            splitCommand = command.split(" ");
            if (splitCommand.length == 1) {
                try {
                    commands.get(splitCommand[0]).execute("");
                } catch (Exception e) {
                    System.out.println("Введена некорректная команда, либо указаны неправильные аргументы. Вы можете ознакомиться со списком существующих команд, используя help");

                }
            } else {
                try {
                    commands.get(splitCommand[0]).execute(splitCommand[1]);
                } catch (Exception e) {
                    System.out.println("Введена некорректная команда, либо указаны неправильные аргументы. Вы можете ознакомиться со списком существующих команд, используя help");
                }
            }
            new HistoryCommand().pushLastCommand(splitCommand[0]);
        } catch (NullPointerException e) {
            System.out.println("Ctrl d detected");
            new SaveCommand().execute("");
            System.exit(0);
        }



    }
}
