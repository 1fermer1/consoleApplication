package models.validators;

import models.Route;
import models.handlers.RoutesCollectionHandler;

import java.time.ZonedDateTime;
import java.util.ArrayList;

public class RouteValidator {
    public static boolean validateId (String value) {
        try {
            int temp = Integer.parseInt(value);
            if (temp < 1) {
                return false;
            }
            ArrayList<Route> routesArray = new RoutesCollectionHandler().getRoutesCollection();
            ArrayList<Integer> idArray = new ArrayList<Integer>();
            for (Route r : routesArray) {
                idArray.add(r.getId());
            }
            return !idArray.contains(temp);
        }
        catch (Exception ex) {
            return false;
        }
    }
    public boolean validateName (String value) {
        return !value.equals("");
    }
    public boolean validateCreationDate (String value) {
        try {
            ZonedDateTime temp = ZonedDateTime.parse(value);
            return temp.compareTo(ZonedDateTime.now()) < 1;
        }
        catch (Exception ex) {
            return false;
        }
    }
    public boolean validateDistance (String value) {
        try {
            int temp = Integer.parseInt(value);
            return temp > 1;
        }
        catch (Exception ex) {
            return false;
        }
    }
}
