package models.handlers;

import models.Route;

import java.time.ZonedDateTime;
import java.util.ArrayList;

public class RoutesCollectionHandler {
    private static ZonedDateTime collectionInitializationDate = ZonedDateTime.now();

    private static ArrayList<Route> routesCollection = new ArrayList<Route>();
    private static ArrayList<Integer> idRoutesCollection = new ArrayList<Integer>();

    public ArrayList<Route> getRoutesCollection() {
        return routesCollection;
    }
    public ArrayList<Integer> getIdRoutesCollection() {
        return idRoutesCollection;
    }
    public ZonedDateTime getCollectionInitializationDate() {
        return collectionInitializationDate;
    }

    public void setRouteToCollection(Route route) {
        routesCollection.add(route);
    }
    public void changeRouteInCollection(int index, Route route) {
        routesCollection.set(index, route);
    }
    public void setRouteToCollection(int index, Route route) {
        routesCollection.add(index, route);
    }
    public void setIdToIdRoutesCollection(Integer id) {
        idRoutesCollection.add(id);
    }
    public void setRoutesCollection(ArrayList<Route> routesCollection) {
        this.routesCollection = routesCollection;
    }
    public void setIdRoutesCollection(ArrayList<Integer> idRoutesCollection) {
        this.idRoutesCollection = idRoutesCollection;
    }
}
