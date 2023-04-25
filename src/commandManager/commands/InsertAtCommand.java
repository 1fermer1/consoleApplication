package commandManager.commands;

import exceptions.WrongAmountOfArgumentsException;

public class InsertAtCommand implements ICommandable {
    @Override
    public String getName() {
        return "insert_at";
    }

    @Override
    public String getDescription() {
        return "добавить новый элемент в заданную позицию";
    }

    @Override
    public String getArgs() {
        return "index {element}";
    }

    @Override
    public void execute(String[] args) throws Exception {
        if (args.length == 1) {

        } else {
            throw new WrongAmountOfArgumentsException("Команда " + this.getName() + " приниамет только один аргумент");
        }
    }
}
