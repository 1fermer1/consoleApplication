package commandManager.commands;

import exceptions.StreamInterruptedException;
import exceptions.WrongAmountOfArgumentsException;
import main.Mode;
import main.UserInputService;
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

    BufferedReader br = UserInputService.getBufferedReader();
    String input;
    RoutesCollectionHandler rch = new RoutesCollectionHandler();
    @Override
    public void execute(String args) throws Exception {
        checkInputValue("Введите имя объекта, оно должно быть представленно не пустой строкой: ", new NameValidator(), UserInputService.getMode());
        name = input;

        checkInputValue("Введите Х для coordinates, он должен быть целым числом: ", new CoordinatesXValidator(), UserInputService.getMode());
        coordinatesX = Long.parseLong(input);

        checkInputValue("Введите Y для coordinates, он должен быть целым числом большим -807: ", new CoordinatesYValidator(), UserInputService.getMode());
        coordinatesY = Integer.parseInt(input);

        if (UserInputService.getMode().equals(Mode.DEFAULT)) {
            System.out.println("Введите имя location from: ");
        }
        input = br.readLine();
        if (input == null) {
            throw new StreamInterruptedException("Программа завершается...");
        }
        locationFromName = input.equals("") ? null : input;

        checkInputValue("Введите Х для location from, он должен быть вещественным числом: ", new LocationXValidator(), UserInputService.getMode());
        locationFromX = Double.parseDouble(input);

        checkInputValue("Введите Y для location from, он должен быть вещественным числом: ", new LocationYValidator(), UserInputService.getMode());
        locationFromY = Double.parseDouble(input);

        if (UserInputService.getMode().equals(Mode.DEFAULT)) {
            System.out.println("Введите имя location to: ");
        }
        input = br.readLine();
        if (input == null) {
            throw new StreamInterruptedException("Программа завершается...");
        }
        locationToName = input.equals("") ? null : input;

        checkInputValue("Введите Х для location to, он должен быть вещественным числом: ", new LocationXValidator(), UserInputService.getMode());
        locationToX = Double.parseDouble(input);

        checkInputValue("Введите Y для location to, он должен быть вещественным числом: ", new LocationYValidator(), UserInputService.getMode());
        locationToY = Double.parseDouble(input);

        checkInputValue("Введите дистанцию объекта, она должна быть целым числом большим 1: ", new DistanceValidator(), UserInputService.getMode());
        distance = Integer.parseInt(input);

        Route r = new Route(name, coordinatesX, coordinatesY, locationFromName, locationFromX, locationFromY, locationToName, locationToX, locationToY, distance);
        rch.setRouteToCollection(r);
        rch.setIdToIdRoutesCollection(r.getId());
    }
    private void checkInputValue(String messege, IValidatorable v, Mode mode) throws Exception {
        do {
            if (mode.equals(Mode.DEFAULT)) {
                System.out.println(messege);
            }
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
