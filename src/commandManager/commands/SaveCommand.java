package commandManager.commands;

import exceptions.WrongAmountOfArgumentsException;

public class SaveCommand implements ICommandable {
    @Override
    public String getName() {
        return "save";
    }

    @Override
    public String getDescription() {
        return "сохранить коллекцию в файл";
    }

    @Override
    public void execute(String[] args) throws Exception {
        if (args.length == 0) {

        } else {
            throw new WrongAmountOfArgumentsException("Команда " + this.getName() + " не принимает аргументы");
        }
    }
}
