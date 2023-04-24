package models.comparators;

import models.Route;

import java.util.Comparator;

public class DescendingComparator implements Comparator<Route> {
    @Override
    public int compare(Route a, Route b) {
        return -a.getId().compareTo(b.getId());
    }
}
