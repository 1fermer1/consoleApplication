package models.validators;

import models.Route;
import models.handlers.RoutesCollectionHandler;

import java.util.ArrayList;

public class IdValidator implements IValidatorable {
    @Override
    public boolean validate(String value) {
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
}
