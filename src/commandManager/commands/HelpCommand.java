package commandManager.commands;

import commandManager.CommandManager;

import java.util.LinkedHashMap;

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
    public void execute(String[] args) {
        CommandManager cm = new CommandManager();
        if (args.length == 0) {
            cm.getCommands().forEach((name, command) -> System.out.println(name + " " + command.getArgs() + " -- " + command.getDescription()));
        } else {
            // TODO: сделать аргумент ексепшен (чтобы команда не попала в историю)
        }
    }
}
