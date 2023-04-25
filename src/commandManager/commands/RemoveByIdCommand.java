package commandManager.commands;

import exceptions.WrongAmountOfArgumentsException;

public class RemoveByIdCommand implements ICommandable {
    @Override
    public String getName() {
        return "remove_by_id";
    }

    @Override
    public String getDescription() {
        return "удалить элемент из коллекции по его id";
    }

    @Override
    public String getArgs() {
        return "id";
    }

    @Override
    public void execute(String[] args) throws Exception {
        if (args.length == 1) {

        } else {
            throw new WrongAmountOfArgumentsException("Команда " + this.getName() + " приниамет только один аргумент");
        }
    }
}
