package commandManager.commands;

import exceptions.WrongAmountOfArgumentsException;
import models.Route;
import models.comparators.DescendingComparator;
import models.handlers.RoutesCollectionHandler;

import java.util.ArrayList;
import java.util.TreeSet;

public class PrintDescendingCommand implements ICommandable {
    @Override
    public String getName() {
        return "print_descending";
    }

    @Override
    public String getDescription() {
        return "вывести элементы коллекции в порядке убывания";
    }

    TreeSet<Route> descendingRoutesCollection = new TreeSet<Route>(new DescendingComparator());
    ArrayList<Route> routesCollection = new RoutesCollectionHandler().getRoutesCollection();
    @Override
    public void execute(String[] args) throws WrongAmountOfArgumentsException {
        if (args.length == 0) {
            descendingRoutesCollection.addAll(routesCollection);
            if (descendingRoutesCollection.size() == 0) {
                System.out.println("В коллекции нет элементов");
                return;
            }
            System.out.println(descendingRoutesCollection.pollFirst());
            for (int i = 1; i < descendingRoutesCollection.size(); i++) {
                System.out.println(",\n" + descendingRoutesCollection.pollFirst());
            }
        } else {
            throw new WrongAmountOfArgumentsException("Команда " + this.getName() + " не принимает аргументы");
        }
    }
}
