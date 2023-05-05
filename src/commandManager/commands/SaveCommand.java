package commandManager.commands;

import exceptions.WrongAmountOfArgumentsException;
import fileLogic.Parser;
import models.handlers.RoutesCollectionHandler;

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
    public void execute(String args) {
        Parser.write(RoutesCollectionHandler.getRoutesCollection());
    }
}
