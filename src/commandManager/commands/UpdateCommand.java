package commandManager.commands;

import exceptions.IncorrectArgumentException;
import exceptions.StreamInterruptedException;
import exceptions.WrongAmountOfArgumentsException;
import models.Route;
import models.handlers.RoutesCollectionHandler;
import models.validators.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UpdateCommand implements ICommandable {
    @Override
    public String getName() {
        return "update";
    }

    @Override
    public String getDescription() {
        return "обновить значение элемента коллеции, id которого равен заданному";
    }

    @Override
    public String getArgs() {
        return "id {element}";
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input;
    RoutesCollectionHandler rch = new RoutesCollectionHandler();
    ArrayList<Route> routesArray = rch.getRoutesCollection();
    @Override
    public void execute(String[] args) throws Exception {
        if (args.length == 1) {
            if (validateArg(args[0])) {
                int id = Integer.parseInt(args[0]);
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

                for(int i = 0; i < routesArray.size(); i++) {
                    if (routesArray.get(i).getId() == id) {
                        Route r = new Route(name, coordinatesX, coordinatesY, locationFromName, locationFromX, locationFromY, locationToName, locationToX, locationToY, distance);
                        r.setId(id);
                        rch.changeRouteInCollection(i, r);
                    }
                }
            } else {
                throw new IncorrectArgumentException("Команда " + this.getName() + " принимает целое число больше 0, котрое является id одного из объекта");
            }
        } else {
            throw new WrongAmountOfArgumentsException("Команда " + this.getName() + " приниамет только один аргумент");
        }
    }
    private boolean validateArg(String arg) {
        try {
            int temp = Integer.parseInt(arg);
            return temp > 0 && new RoutesCollectionHandler().getIdRoutesCollection().contains(temp);
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
