package commandManager.commands;

import exceptions.IncorrectArgumentException;
import exceptions.WrongAmountOfArgumentsException;
import models.Route;
import models.handlers.RoutesCollectionHandler;

import java.util.ArrayList;

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

    RoutesCollectionHandler rch = new RoutesCollectionHandler();
    ArrayList<Integer> idArrays = rch.getIdRoutesCollection();
    ArrayList<Route> routesArrays = rch.getRoutesCollection();
    @Override
    public void execute(String[] args) throws Exception {
        if (args.length == 1) {
            if (validateArg(args[0])) {
                Integer id = Integer.parseInt(args[0]);
                if (idArrays.remove(id)) {
                    for (int i = 0; i < routesArrays.size(); i++) {
                        if (routesArrays.get(i).getId() == id) {
                            routesArrays.remove(i);
                            rch.setIdRoutesCollection(idArrays);
                            rch.setRoutesCollection(routesArrays);
                            return;
                        }
                    }
                } else {
                    System.out.println("Коллекция итак не содержит элемента с id " + id);
                }
            } else {
                throw new IncorrectArgumentException("Команда " + this.getName() + " принимает целое число больше 0");
            }
        } else {
            throw new WrongAmountOfArgumentsException("Команда " + this.getName() + " приниамет только один аргумент");
        }
    }
    private boolean validateArg(String arg) {
        try {
            int temp = Integer.parseInt(arg);
            return temp > 0;
        }
        catch (Exception ex) {
            return false;
        }
    }
}
