package main;

import commandManager.CommandManager;
import commandManager.commands.AddCommand;
import commandManager.commands.HistoryCommand;
import commandManager.commands.ICommandable;
import commandManager.commands.ShowCommand;
import models.Route;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) {
        // TODO: когда я отправляю запрос в команд менеджер и он проходит без ОШИБКИ (catch не вызвался) я помещаю эту команду в history

        // TODO: при ctrl + D отключается ввод и соответственно нужно прекратить программу
        //  но это не ексит поэтому сначала ловим ctrl + D, потом делаем сейв и потом ексит

        // TODO: если при выполнении команды в юзер моде вылетел ексепшин мы заставляем пользователя чтобы он ввел
        //  все нормально, а в скрипт моде забиваем на эту команду и идем к следующей


        // TODO: запись хистори

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

//        Route r = new Route();
//        Route r1 = new Route();
//        Route r2 = new Route();
//        Route r3 = new Route();
//        Route r4 = new Route();
//
//        RoutesCollectionHandler bb = new RoutesCollectionHandler();
//        bb.setRouteToCollection(r);
//        bb.setRouteToCollection(r1);
//        bb.setRouteToCollection(r2);
//        bb.setRouteToCollection(r3);
//        bb.setRouteToCollection(r4);
//
//        Scanner s = new Scanner(System.in);
//
//        System.out.println(r.getId());
//        System.out.println(r1.getId());
//        System.out.println(r2.getId());
//        System.out.println(r3.getId());
//        System.out.println(r4.getId());
//
//        while (!RouteValidator.validateId(s.nextLine())) {
//
//        }
//        System.out.println("end");

//        try {
//            new ShowCommand().execute(new String[1]);
//            new AddCommand().execute(new String[0]);
//            new ShowCommand().execute(new String[0]);
//        } catch (Exception ex) {
//            System.out.println("\n\nException!!!\n\n" + ex.getMessage());
//        }


//        ArrayList<Integer> tt = new ArrayList<Integer>();
//        tt.add(1);
//        tt.add(2);
//        tt.add(3);
//        tt.add(4);
//        tt.add(5);
//        tt.add(5, 100);
//
//        for (Integer i : tt) {
//            System.out.println(i);
//        }

        /*InputStreamReader isr = new InputStreamReader(System.in);
        Gson gson = new GsonBuilder().create();
        //Route r = gson.fromJson();*/

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, ICommandable> commands = new CommandManager().getCommands();
        String command;
        String[] splitCommand;
        Arrays.fill(HistoryCommand.historyArray, "");
        while (true) {
            try {
                command = br.readLine();
                splitCommand = command.split(" ");
                if (splitCommand.length == 1) {
                    commands.get(splitCommand[0]).execute(new String[0]);
                } else {
                    commands.get(splitCommand[0]).execute(Arrays.copyOfRange(splitCommand, 1, splitCommand.length));
                }
                new HistoryCommand().pushLastCommand(splitCommand[0]);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

    }
}