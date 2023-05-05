package commandManager.commands;

import exceptions.IncorrectArgumentException;
import exceptions.WrongAmountOfArgumentsException;
import models.Route;
import models.handlers.RoutesCollectionHandler;
import models.validators.DistanceValidator;

import java.util.ArrayList;

public class CountLessThanDistanceCommand implements ICommandable {
    @Override
    public String getName() {
        return "count_less_than_distance";
    }

    @Override
    public String getDescription() {
        return "вывести количество элементов, значение поля distance которых меньше заданного";
    }

    @Override
    public String getArgs() {
        return "distance";
    }

    DistanceValidator dv = new DistanceValidator();
    int count = 0;
    int distance = 0;
    ArrayList<Route> routesCollection = new RoutesCollectionHandler().getRoutesCollection();
    @Override
    public void execute(String args) throws Exception {
        if (dv.validate(args)) {
            distance = Integer.parseInt(args);
            for (Route r : routesCollection) {
                if (r.getDistance() < distance) {
                    count++;
                }
            }
            System.out.println("Количество элементов, значение поля distance которых меньше чем " + distance + " равно " + count);
        } else {
            throw new IncorrectArgumentException("Команда " + this.getName() + " принимает целое число больше 1");
        }
    }
}
