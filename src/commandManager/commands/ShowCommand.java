package commandManager.commands;

import exceptions.WrongAmountOfArgumentsException;
import models.Route;
import models.handlers.RoutesCollectionHandler;

import java.util.ArrayList;

public class ShowCommand implements ICommandable {
    @Override
    public String getName() {
        return "show";
    }

    @Override
    public String getDescription() {
        return "вывести в стандартный поток вывода все эементы коллекции в строковом представлении";
    }

    ArrayList<Route> routesCollection = new RoutesCollectionHandler().getRoutesCollection();
    @Override
    public void execute(String args) throws WrongAmountOfArgumentsException {
        if (routesCollection.size() == 0) {
            System.out.println("В коллекции нет элементов");
            return;
        }
        System.out.print(routesCollection.get(0));
        for (int i = 1; i < routesCollection.size(); i++) {
            System.out.print("\n\n" + routesCollection.get(i));
        }
    }
}
