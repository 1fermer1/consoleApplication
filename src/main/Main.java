package main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import commandManager.CommandManager;
import commandManager.commands.HistoryCommand;
import commandManager.commands.ICommandable;
import fileLogic.editors.DateEditor;
import models.Route;

import java.io.*;
import java.time.ZonedDateTime;
import java.util.*;

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
        //InputStreamReader cin = new InputStreamReader(System.in);


//        Gson gson = new GsonBuilder().create();
//
//        BufferedReader reader = null;
//        String file = "";
//        String path = ".\\routes.json";
//        try {
//            reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
//            String line = "";
//            while((line = reader.readLine()) != null){
//                file += line + '\n';
//            }
//            reader.close();
//            System.out.println(gson.fromJson(file, Route.class));
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());;
//        }


//        ArrayList<Route> array = new ArrayList<Route>();
//        Gson gson = new GsonBuilder().registerTypeAdapter(ZonedDateTime.class, new DateEditor()).create();
//
//        BufferedReader reader = null;
//        String file = "";
//        String path = "config.env";




//        try {
//            reader = new BufferedReader(new InputStreamReader(new FileInputStream("config.env")));
//            String line = "";
//            while((line = reader.readLine()) != null){
//                file += line + '\n';
//            }
//            reader.close();
//            System.out.println(gson.fromJson(file, Route.class));
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());;
//        }


/*

        //Gson gson = new GsonBuilder().registerTypeAdapter(ZonedDateTime.class, new DateEditor()).create();
        Gson gson = new GsonBuilder().create();
        //ArrayList<Map<String, Route>> routeMapsList = new ArrayList<Map<String, Route>>();
        ArrayList<Map<String, String>> routeMapsList = new ArrayList<Map<String, String>>();
        Properties prop = new Properties();
        BufferedReader input = null;
        try {
            input = new BufferedReader(new InputStreamReader(new FileInputStream("config.env")));
            prop.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        String filename = prop.getProperty("FILE_NAME");
        try(JsonReader reader = new JsonReader(new BufferedReader(new InputStreamReader(new FileInputStream(filename))))) {
            reader.beginArray();
            while (reader.hasNext()) {
                JsonObject obj = JsonParser.parseReader(reader).getAsJsonObject();
                //Route route = gson.fromJson(obj, Route.class);
                Map<String, String> route = gson.fromJson(obj, Map.class);
                routeMapsList.add(route);
            }
            reader.endArray();


            for (Map<String, String> r : routeMapsList) {
                System.out.println(r);

                System.out.println("\n\n\n");
                System.out.println(new IdValidator().validate(r.get("id")));

                System.out.println(r.get("name"));

                Coordinates coordinates = gson.fromJson(JsonParser.parseString(String.valueOf(r.get("coordinates"))).getAsJsonObject(), Coordinates.class);
                System.out.println(coordinates);

                //System.out.println(ZonedDateTime.parse(r.get("creationDate")).toLocalDate());
                System.out.println(ZonedDateTime.parse(String.valueOf(r.get("creationDate"))));

                Location from = gson.fromJson(JsonParser.parseString(String.valueOf(r.get("from"))).getAsJsonObject(), Location.class);
                System.out.println(from);

                Location to = gson.fromJson(JsonParser.parseString(String.valueOf(r.get("to"))).getAsJsonObject(), Location.class);
                System.out.println(to);

                System.out.println(r.get("distance"));
                System.out.println("\n\n\n");
            }
            System.out.println("\n\n");



        } catch (Exception e) {
            System.out.println("\n\njjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj\n\n" + e.getMessage() + "\n\n");
        }

*/


        // JsonReader reader = new JsonReader(new FileReader(filename))




//chat gpt попытка 1

/*


        Gson gson = new GsonBuilder().registerTypeAdapter(ZonedDateTime.class, new DateEditor()).setPrettyPrinting().create();
        Properties prop = new Properties();
        BufferedReader input = null;
        try {
            input = new BufferedReader(new InputStreamReader(new FileInputStream("config.env")));
            prop.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        String filename = prop.getProperty("FILE_NAME");
        ArrayList<Route> routes = new ArrayList<>();
        //try(JsonReader reader = new JsonReader(new BufferedReader(new InputStreamReader(new FileInputStream(filename)))))
        try (Reader reader = new FileReader(filename)) {
            JsonReader jsonReader = new JsonReader(reader);
        /////////////////
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                //JsonObject obj = JsonParser.parseReader(jsonReader).getAsJsonObject();
                String jsonString = gson.fromJson(jsonReader, String.class);
                System.out.println(jsonString);
                //Route route = gson.fromJson(obj, Route.class);
                //routes.add(route);
            }
            jsonReader.endArray();
        } catch (IOException e) {
            e.getMessage();
        }

        for (Route r : routes) {
            System.out.println("\n\n\n" + r);
        }
        System.out.println("\n\n\n");

*/





        Properties prop = new Properties();
        BufferedReader input = null;
        try {
            input = new BufferedReader(new InputStreamReader(new FileInputStream("config.env")));
            prop.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        String filename = prop.getProperty("FILE_NAME");
        Gson gson = new GsonBuilder().registerTypeAdapter(ZonedDateTime.class, new DateEditor()).create();
        ArrayList<Route> routeList = new ArrayList<Route>();
        try (Reader reader = new FileReader(filename)) {
            JsonReader jsonReader = new JsonReader(reader);
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                JsonObject obj = JsonParser.parseReader(jsonReader).getAsJsonObject();
                System.out.println(obj.get("id").getAsInt());
            }
            jsonReader.endArray();
        } catch (Exception ex) {
            ex.printStackTrace();
        }







        System.exit(0);


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, ICommandable> commands = new CommandManager().getCommands();
        String command;
        String[] splitCommand;
        Arrays.fill(HistoryCommand.historyArray, "");
        System.out.println("welcome to los pollos hermanos");
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

    public static int Foo(int i) {
        if (i > 2) {
            return Foo(i / 2);
        }
        return i;
    }
}