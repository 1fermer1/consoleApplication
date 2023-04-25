package models;

import models.handlers.RoutesCollectionHandler;

import java.time.ZonedDateTime;
import java.util.ArrayList;

public class Validator {
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
    public static boolean validateName (String value) {
        return !value.equals("");
    }
    public static boolean validateCreationDate (String value) {
        try {
            ZonedDateTime temp = ZonedDateTime.parse(value);
            return temp.compareTo(ZonedDateTime.now()) < 1;
        }
        catch (Exception ex) {
            return false;
        }
    }
    public static boolean validateDistance (String value) {
        try {
            int temp = Integer.parseInt(value);
            return temp > 1;
        }
        catch (Exception ex) {
            return false;
        }
    }



    public static boolean locationValidateX (String value) {
        try {
            double temp = Double.parseDouble(value);
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }
    public static boolean locationValidateY (String value) {
        try {
            double temp = Double.parseDouble(value);
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }



    public static boolean coordinatesValidateX (String value) {
        try {
            long temp = Long.parseLong(value);
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }
    public static boolean coordinatesValidateY (String value) {
        try {
            int temp = Integer.parseInt(value);
            return temp > -807;
        }
        catch (Exception ex) {
            return false;
        }
    }
}
