package fileLogic;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import models.Route;
import models.handlers.RoutesCollectionHandler;
import models.validators.*;

import java.io.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

        public class Parser {
            static Gson gson = new GsonBuilder().registerTypeAdapter(Random.class, new RandomAdapter()).registerTypeAdapter(ZonedDateTime.class, new ZonedDateTimeAdapter()).create();
            public static ArrayList<Route> parse() {

                ArrayList<Route> routeList = new ArrayList<>();
                Properties prop = new Properties();
                InputStream input = null;
                try {
                    input = new FileInputStream("config.env");
                    prop.load(input);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (input != null) {
                        try {
                            input.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                String filename = prop.getProperty("FILE_NAME");
                try (JsonReader reader = new JsonReader(new FileReader(filename))) {
                    reader.beginArray();
                    while (reader.hasNext()) {
                        JsonObject obj = JsonParser.parseReader(reader).getAsJsonObject();
                        Route route = gson.fromJson(obj, Route.class);
                        if (new NameValidator().validate(route.getName()) &&
                                new IdValidator().validate(route.getId().toString()) &&
                                new CreationDateValidator().validate(route.getCreationDate().toString()) &&
                                new CoordinatesYValidator().validate(route.getCoordinates().getY().toString()) &&
                                (route.getFrom() == null || !route.getFrom().getName().equals("") &&
                                        new LocationXValidator().validate(route.getFrom().getX().toString()) &&
                                        new LocationYValidator().validate(route.getFrom().getX().toString())) &&
                                (route.getTo() == null || !route.getTo().getName().equals("") &&
                                        new LocationXValidator().validate(route.getTo().getX().toString()) &&
                                        new LocationYValidator().validate(route.getTo().getX().toString())) &&
                                new DistanceValidator().validate(Integer.toString(route.getDistance()))) {
                            routeList.add(route);
                            System.out.println(route);
                        } else {
                            System.out.println("Incorrect object input");
                        }
                    }
                    reader.endArray();
                    System.out.println("Import successful");
                    return routeList;
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Import error");
                }
                return null;
            }

            public static void write(ArrayList<Route> collection) {
                try (PrintWriter out = new PrintWriter(new FileWriter("routes_res.json"))) {
                    JsonWriter writer = gson.newJsonWriter(out);
                    writer.setIndent("\t");
                    writer.setSerializeNulls(true);
                    writer.beginArray();
                    for (Route elem : collection) {
                        gson.toJson(elem, Route.class, writer);
                    }
                    writer.endArray();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



//
//        }
//    }
//}
