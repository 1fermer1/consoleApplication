package commandManager.commands;

import exceptions.StreamInterruptedException;
import exceptions.WrongAmountOfArgumentsException;
import models.Route;
import models.handlers.RoutesCollectionHandler;
import models.validators.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AddCommand implements ICommandable {
    @Override
    public String getName() {
        return "add";
    }

    @Override
    public String getDescription() {
        return "добавить новый элемент в коллекцию";
    }

    @Override
    public String getArgs() {
        return "{element}";
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input;
    RoutesCollectionHandler rch = new RoutesCollectionHandler();
    @Override
    public void execute(String[] args) throws Exception {
        if (args.length == 0) {
            checkInputValue("Введите имя объекта, оно должно быть представленно не пустой строкой: ", new NameValidator());
            name = input;

            checkInputValue("Введите Х для coordinates, он должен быть целым числом: ", new CoordinatesXValidator());
            coordinatesX = Long.parseLong(input);

            checkInputValue("Введите Y для coordinates, он должен быть целым числом большим -807: ", new CoordinatesYValidator());
            coordinatesY = Integer.parseInt(input);

            System.out.println("Введите имя location from: ");
            input = br.readLine();
            if (input == null) {
                throw new StreamInterruptedException("Программа завершается...");
            }
            locationFromName = input.equals("") ? null : input;

            checkInputValue("Введите Х для location from, он должен быть вещественным числом: ", new LocationXValidator());
            locationFromX = Double.parseDouble(input);

            checkInputValue("Введите Y для location from, он должен быть вещественным числом: ", new LocationYValidator());
            locationFromY = Double.parseDouble(input);

            System.out.println("Введите имя location to: ");
            input = br.readLine();
            if (input == null) {
                throw new StreamInterruptedException("Программа завершается...");
            }
            locationToName = input.equals("") ? null : input;

            checkInputValue("Введите Х для location to, он должен быть вещественным числом: ", new LocationXValidator());
            locationToX = Double.parseDouble(input);

            checkInputValue("Введите Y для location to, он должен быть вещественным числом: ", new LocationYValidator());
            locationToY = Double.parseDouble(input);

            checkInputValue("Введите дистанцию объекта, она должна быть целым числом большим 1: ", new DistanceValidator());
            distance = Integer.parseInt(input);

            Route r = new Route(name, coordinatesX, coordinatesY, locationFromName, locationFromX, locationFromY, locationToName, locationToX, locationToY, distance);
            rch.setRouteToCollection(r);
            rch.setIdToIdRoutesCollection(r.getId());
        } else {
            throw new WrongAmountOfArgumentsException("Команда " + this.getName() + " не принимает аргументы");
        }
    }
    private void checkInputValue(String messege, IValidatorable v) throws Exception {
        do {
            System.out.println(messege);
            input = br.readLine();
            if (input == null) {
                throw new StreamInterruptedException("Программа завершается...");
            }
        } while (!v.validate(input));
    }
    String name;
    long coordinatesX;
    Integer coordinatesY;
    String locationFromName;
    Double locationFromX;
    Double locationFromY;
    String locationToName;
    Double locationToX;
    Double locationToY;
    int distance;
}
