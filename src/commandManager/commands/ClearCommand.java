package commandManager.commands;

import exceptions.WrongAmountOfArgumentsException;
import models.Route;
import models.handlers.RoutesCollectionHandler;

import java.util.ArrayList;

public class ClearCommand implements ICommandable {
    @Override
    public String getName() {
        return "clear";
    }

    @Override
    public String getDescription() {
        return "очистить коллекцию";
    }

    @Override
    public void execute(String[] args) throws WrongAmountOfArgumentsException {
        if (args.length == 0) {
            new RoutesCollectionHandler().setRoutesCollection(new ArrayList<Route>());
            new RoutesCollectionHandler().setIdRoutesCollection(new ArrayList<Integer>());
        } else {
            throw new WrongAmountOfArgumentsException("Команда " + this.getName() + " не принимает аргументы");
        }
    }
}
