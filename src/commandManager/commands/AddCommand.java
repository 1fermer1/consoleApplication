package commandManager.commands;

import exceptions.IncorrectArgumentException;
import exceptions.WrongAmountOfArgumentsException;
import models.Route;
import models.Validator;

public class AddCommand implements ICommandable {
    @Override
    public String getName() {
        return "add";
    }

    @Override
    public String getDescription() {
        return "добавить новый элемент в коллекцию";
    }

    @Override
    public String getArgs() {
        return "{element}";
    }

    @Override
    public void execute(String[] args) throws Exception {
        if (args.length == 0) {

        } else {
            throw new WrongAmountOfArgumentsException("Команда " + this.getName() + " не принимает аргументы");
        }
    }
}
