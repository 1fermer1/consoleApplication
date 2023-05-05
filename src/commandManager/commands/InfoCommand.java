package commandManager.commands;

import exceptions.WrongAmountOfArgumentsException;
import models.Route;
import models.handlers.RoutesCollectionHandler;

import java.util.ArrayList;

public class InfoCommand implements ICommandable {
    @Override
    public String getName() {
        return "info";
    }

    @Override
    public String getDescription() {
        return "вывести в стандртный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }

    RoutesCollectionHandler rch = new RoutesCollectionHandler();
    @Override
    public void execute(String args) throws WrongAmountOfArgumentsException {
        System.out.println("Информация о коллекции:\n\tТип коллекции: " + rch.getClass().getName());
        if (rch.getCollectionInitializationDate() == null) {
            System.out.println("\tКоллекция не инициализирована\n\tКоллекция пуста. Содержит 0 элементов");
        } else {
            System.out.println("\tДата инициализации коллекции: " + rch.getCollectionInitializationDate().toLocalDate()
                    + "\n\tКоличество эелементов в коллекции: " + rch.getRoutesCollection().size());
        }
    }
}
