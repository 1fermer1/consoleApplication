package commandManager.commands;

import commandManager.CommandManager;
import exceptions.WrongAmountOfArgumentsException;

public class HelpCommand implements ICommandable {
    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "вывести справку по доступным командам";
    }

    @Override
    public void execute(String args) throws WrongAmountOfArgumentsException {
        CommandManager cm = new CommandManager();
        cm.getCommands().forEach((name, command) -> System.out.println(name + " " + command.getArgs() + " -- " + command.getDescription()));
    }
}
