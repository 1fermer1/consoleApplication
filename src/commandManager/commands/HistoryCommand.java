package commandManager.commands;

import exceptions.WrongAmountOfArgumentsException;

import java.util.Arrays;

public class HistoryCommand implements ICommandable {
    @Override
    public String getName() {
        return "history";
    }

    @Override
    public String getDescription() {
        return "вывести последние 5 команд (без их аргументов)";
    }

    @Override
    public void execute(String args[]) throws WrongAmountOfArgumentsException {
        if (args.length == 0) {
            if (historyArray[0].equals("")) {
                System.out.println("Истории команд нет");
                return;
            }
            for (String c : historyArray) {
                if (c.equals("")) {
                    break;
                }
                System.out.println("> " + c);
            }
        } else {
            throw new WrongAmountOfArgumentsException("Команда " + this.getName() + " не принимает аргументы");
        }
    }

    public void pushLastCommand(String commandName) {
        for (int i = historyArray.length - 1; i > 0; i--) {
            historyArray[i] = historyArray[i - 1];
        }
        historyArray[0] = commandName;
    }

    public static String historyArray[] = new String[5];
}
