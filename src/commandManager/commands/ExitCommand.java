package commandManager.commands;

import exceptions.WrongAmountOfArgumentsException;

public class ExitCommand implements ICommandable {
    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getDescription() {
        return "завершить программу (без сохранения в файл)";
    }

    @Override
    public void execute(String args) throws WrongAmountOfArgumentsException {
        System.exit(0);
    }
}
