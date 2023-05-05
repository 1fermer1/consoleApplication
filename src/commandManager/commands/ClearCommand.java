package commandManager.commands;

import exceptions.WrongAmountOfArgumentsException;
import models.Route;
import models.handlers.RoutesCollectionHandler;

import java.util.ArrayList;
import java.util.HashSet;

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
    public void execute(String args) throws WrongAmountOfArgumentsException {
        RoutesCollectionHandler.setRoutesCollection(new ArrayList<Route>());
        RoutesCollectionHandler.setIdRoutesCollection(new HashSet<>());
    }
}
