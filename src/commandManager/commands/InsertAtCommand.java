package commandManager.commands;

import exceptions.IncorrectArgumentException;
import exceptions.StreamInterruptedException;
import exceptions.WrongAmountOfArgumentsException;
import models.Route;
import models.handlers.RoutesCollectionHandler;
import models.validators.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InsertAtCommand implements ICommandable {
    @Override
    public String getName() {
        return "insert_at";
    }

    @Override
    public String getDescription() {
        return "добавить новый элемент в заданную позицию";
    }

    @Override
    public String getArgs() {
        return "index {element}";
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input;
    RoutesCollectionHandler rch = new RoutesCollectionHandler();
    @Override
    public void execute(String[] args) throws Exception {
        if (args.length == 1) {
            if (validateArg(args[0])) {
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
                rch.setRouteToCollection(Integer.parseInt(args[0]), r);
                rch.setIdToIdRoutesCollection(r.getId());
            } else {
                throw new IncorrectArgumentException("Команда " + this.getName() + " принимает целое число больше -1");
            }
        } else {
            throw new WrongAmountOfArgumentsException("Команда " + this.getName() + " приниамет только один аргумент");
        }
    }
    private boolean validateArg(String arg) {
        try {
            int temp = Integer.parseInt(arg);
            return temp > -1 && temp < new RoutesCollectionHandler().getRoutesCollection().size() + 1;
        }
        catch (Exception ex) {
            return false;
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
