package commandManager.commands;

import exceptions.WrongAmountOfArgumentsException;
import models.Route;
import models.comparators.AscendingComparator;
import models.handlers.RoutesCollectionHandler;

import java.util.ArrayList;
import java.util.TreeSet;

public class PrintAscendingCommand implements ICommandable {
    @Override
    public String getName() {
        return "print_ascending";
    }

    @Override
    public String getDescription() {
        return "вывести элементы коллекции в порядке возрастания";
    }

    TreeSet<Route> ascendingRoutesCollection = new TreeSet<Route>(new AscendingComparator());
    ArrayList<Route> routesCollection = new RoutesCollectionHandler().getRoutesCollection();
    @Override
    public void execute(String[] args) throws WrongAmountOfArgumentsException {
        if (args.length == 0) {
            ascendingRoutesCollection.addAll(routesCollection);
            if (ascendingRoutesCollection.size() == 0) {
                System.out.println("В коллекции нет элементов");
                return;
            }
            System.out.println(ascendingRoutesCollection.pollFirst());
            for (int i = 1; i < ascendingRoutesCollection.size(); i++) {
                System.out.println(",\n" + ascendingRoutesCollection.pollFirst());
            }
        } else {
            throw new WrongAmountOfArgumentsException("Команда " + this.getName() + " не принимает аргументы");
        }
    }
}
