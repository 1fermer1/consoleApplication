package models.handlers;

import models.Route;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;

public class RoutesCollectionHandler {
    private static ZonedDateTime collectionInitializationDate = ZonedDateTime.now();

    private static ArrayList<Route> routesCollection = new ArrayList<Route>();
    private static HashSet<Integer> idRoutesCollection = new HashSet<>();

    public static ArrayList<Route> getRoutesCollection() {
        return routesCollection;
    }
    public static HashSet<Integer> getIdRoutesCollection() {
        return idRoutesCollection;
    }
    public static ZonedDateTime getCollectionInitializationDate() {
        return collectionInitializationDate;
    }

    public static void setRouteToCollection(Route route) {
        routesCollection.add(route);
    }
    public static void changeRouteInCollection(int index, Route route) {
        routesCollection.set(index, route);
    }
    public static void setRouteToCollection(int index, Route route) {
        routesCollection.add(index, route);
    }
    public static void setIdToIdRoutesCollection(Integer id) {
        idRoutesCollection.add(id);
    }
    public static void setRoutesCollection(ArrayList<Route> routesCollection) {
        RoutesCollectionHandler.routesCollection = routesCollection;
    }
    public static void setIdRoutesCollection(HashSet<Integer> idRoutesCollection) {
        RoutesCollectionHandler.idRoutesCollection = idRoutesCollection;
    }
}
