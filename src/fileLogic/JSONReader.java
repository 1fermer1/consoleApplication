package fileLogic;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import fileLogic.editors.DateEditor;
import models.Coordinates;
import models.Location;
import models.Route;
import models.validators.*;

import java.io.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Properties;

public class JSONReader {
    public static ArrayList<Route> read() {
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
                int id;
                if (obj.get("id") == null) {
                    break;
                } else {
                    String idString = obj.get("id").getAsString();
                    if (new IdValidator().validate(idString)) {
                        id = Integer.parseInt(idString);
                    } else {
                        break;
                    }
                }

                String name;
                if (obj.get("name") == null) {
                    break;
                } else {
                    String nameString = obj.get("name").getAsString();
                    if (new NameValidator().validate(nameString)) {
                        name = nameString;
                    } else {
                        break;
                    }
                }

                Coordinates coordinates = new Coordinates();
                if (obj.get("coordinates") == null) {
                    break;
                } else {
                    JsonObject coordinatesObj = obj.get("coordinates").getAsJsonObject();
                    if (coordinatesObj.get("x") == null) {
                        break;
                    } else {
                        String coordinatesXString = coordinatesObj.get("x").getAsString();
                        if (new CoordinatesXValidator().validate(coordinatesXString)) {
                            coordinates.setX(Long.parseLong(coordinatesXString));
                        } else {
                            break;
                        }
                    }
                    if (coordinatesObj.get("y") == null) {
                        break;
                    } else {
                        String coordinatesYString = coordinatesObj.get("y").getAsString();
                        if (new CoordinatesYValidator().validate(coordinatesYString)) {
                            coordinates.setX(Integer.parseInt(coordinatesYString));
                        } else {
                            break;
                        }
                    }
                }

                ZonedDateTime creationDate;
                if (obj.get("creationDate") == null) {
                    break;
                } else {
                    String creationDateString = obj.get("creationDate").getAsString();
                    if (new CreationDateValidator().validate(creationDateString)) {
                        creationDate = ZonedDateTime.parse(creationDateString);
                    } else {
                        break;
                    }
                }

                Location from = new Location();
                if (obj.get("from") == null) {
                    from = null;
                } else {
                    JsonObject fromObj = obj.get("from").getAsJsonObject();
                    if (fromObj.get("name") == null) {
                        from.setName(null);
                    } else {+
                        String locationNameString = fromObj.get("x").getAsString();
                        if (new CoordinatesXValidator().validate(coordinatesXString)) {
                            coordinates.setX(Long.parseLong(coordinatesXString));
                        } else {
                            break;
                        }
                    }
                    if (fromObj.get("x") == null) {
                        break;
                    } else {
                        String coordinatesXString = fromObj.get("x").getAsString();
                        if (new CoordinatesXValidator().validate(coordinatesXString)) {
                            coordinates.setX(Long.parseLong(coordinatesXString));
                        } else {
                            break;
                        }
                    }
                    if (fromObj.get("y") == null) {
                        break;
                    } else {
                        String coordinatesYString = fromObj.get("y").getAsString();
                        if (new CoordinatesYValidator().validate(coordinatesYString)) {
                            coordinates.setX(Integer.parseInt(coordinatesYString));
                        } else {
                            break;
                        }
                    }
                }

                JsonObject fromObj = obj.get("from").getAsJsonObject();
                String fromName = fromObj.get("name").getAsString();
                Double fromX = fromObj.get("x").getAsDouble();
                Double fromY = fromObj.get("y").getAsDouble();
                JsonObject toObj = obj.get("to").getAsJsonObject();
                String toName = toObj.get("name").getAsString();
                Double toX = toObj.get("x").getAsDouble();
                Double toY = toObj.get("y").getAsDouble();
                int distance = obj.get("distance").getAsInt();
                Route route = new Route(id, name, x, y, creationDate, fromName, fromX, fromY, toName, toX, toY, distance);
                routeList.add(route);
            }
            jsonReader.endArray();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return routeList;
    }
}
