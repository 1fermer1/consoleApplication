package models.comparators;

import models.Route;

import java.util.Comparator;

public class DefaultComparator implements Comparator<Route> {
    @Override
    public int compare(Route a, Route b) {
        return a.getName().compareTo(b.getName());
    }
}
