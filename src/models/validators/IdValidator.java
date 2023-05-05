package models.validators;

import models.Route;
import models.handlers.RoutesCollectionHandler;

import java.util.ArrayList;
import java.util.HashSet;

public class IdValidator implements IValidatorable {
    @Override
    public boolean validate(String value) {
        try {
            int temp = Integer.parseInt(value);
            if (temp < 1) {
                return false;
            }
            ArrayList<Route> routesArray = RoutesCollectionHandler.getRoutesCollection();
            HashSet<Integer> idArray = RoutesCollectionHandler.getIdRoutesCollection();
            for (Route r : routesArray) {
                idArray.add(r.getId());
            }
            return !idArray.contains(temp);
        }
        catch (Exception ex) {
            return false;
        }
    }
}
