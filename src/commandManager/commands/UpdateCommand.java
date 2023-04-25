package commandManager.commands;

import exceptions.WrongAmountOfArgumentsException;

public class UpdateCommand implements ICommandable {
    @Override
    public String getName() {
        return "update";
    }

    @Override
    public String getDescription() {
        return "обновить значение элемента коллеции, id которого равен заданному";
    }

    @Override
    public String getArgs() {
        return "id {element}";
    }

    @Override
    public void execute(String[] args) throws Exception {
        if (args.length == 1) {

        } else {
            throw new WrongAmountOfArgumentsException("Команда " + this.getName() + " приниамет только один аргумент");
        }
    }
}
