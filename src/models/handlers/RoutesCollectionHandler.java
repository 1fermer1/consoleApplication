package models.handlers;

import models.Route;

import java.time.ZonedDateTime;
import java.util.ArrayList;

public class RoutesCollectionHandler {
    public static ZonedDateTime collectionInitializationDate;

    private static ArrayList<Route> routesCollection = new ArrayList<Route>();
    private static ArrayList<Integer> idRoutesCollection = new ArrayList<Integer>();

    public ArrayList<Route> getRoutesCollection() {
        return routesCollection;
    }
    public ArrayList<Integer> getIdRoutesCollection() {
        return idRoutesCollection;
    }

    public void setRouteToCollection(Route route) {
        routesCollection.add(route);
    }
    public void setIdToIdRoutesCollection(Integer id) {
        idRoutesCollection.add(id);
    }
}
