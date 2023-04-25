package commandManager.commands;

import exceptions.WrongAmountOfArgumentsException;
import models.Route;
import models.handlers.RoutesCollectionHandler;

import java.util.*;

public class ReorderCommand implements ICommandable {
    @Override
    public String getName() {
        return "reorder";
    }

    @Override
    public String getDescription() {
        return "отсортировать коллекцию в порядке, обратном нынешнему";
    }


    ArrayList<Route> routesCollection = new RoutesCollectionHandler().getRoutesCollection();
    int size = routesCollection.size();
    ArrayList<Route> reorderRoutesCollection = new ArrayList<Route>();
    @Override
    public void execute(String[] args) throws WrongAmountOfArgumentsException {
        if (args.length == 0) {
            for (int i = 0; i < size; i++) {
                reorderRoutesCollection.add(routesCollection.get(size - i - 1));
                new RoutesCollectionHandler().setRoutesCollection(routesCollection);
            }
        } else {
            throw new WrongAmountOfArgumentsException("Команда " + this.getName() + " не принимает аргументы");
        }
    }
}
