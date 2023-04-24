package main;

import commandManager.commands.HelpCommand;
import models.Route;
import models.handlers.RoutesCollectionHandler;
import models.validators.RouteValidator;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // TODO: когда я отправляю запрос в команд менеджер и он проходит без ОШИБКИ (catch не вызвался) я помещаю эту команду в history

        // TODO: try catch и вся отсальная обработка находится в валидаторах их вызывает
        //  эдд, валидаторы возвращают иулиан чтобы быть в вайле

        // TODO: при ctrl + D отключается выод и соответственно нужно прекратить программу
        //  но это не ексит поэтому сначала ловим ctrl + D, потом делаем сейв и потом ексит


//        System.out.println("\n\n");
//
//        String s = "3023-04-23T17:01:49.399099+03:00[Europe/Moscow]";
//
//        ZonedDateTime zdt = ZonedDateTime.parse(s);

//        System.out.println("\n\n");
//
//        new HelpCommand().execute(args);
//
//        ZonedDateTime zdt = ZonedDateTime.now();
//
//        System.out.println("\n\n");
//
//        System.out.println((zdt.compareTo(ZonedDateTime.now())));
//
//        System.out.println("\n\n");

        Route r = new Route();
        Route r1 = new Route();
        Route r2 = new Route();
        Route r3 = new Route();
        Route r4 = new Route();

        RoutesCollectionHandler bb = new RoutesCollectionHandler();
        bb.setRouteToCollection(r);
        bb.setRouteToCollection(r1);
        bb.setRouteToCollection(r2);
        bb.setRouteToCollection(r3);
        bb.setRouteToCollection(r4);

        Scanner s = new Scanner(System.in);

        System.out.println(r.getId());
        System.out.println(r1.getId());
        System.out.println(r2.getId());
        System.out.println(r3.getId());
        System.out.println(r4.getId());

        while (!RouteValidator.validateId(s.nextLine())) {

        }
        System.out.println("end");



//        RoutesCollectionHandler rch = new RoutesCollectionHandler();
//        boolean a = rch.getRoutesCollection().stream().anyMatch(route -> route.getId().equals(id))
    }
}