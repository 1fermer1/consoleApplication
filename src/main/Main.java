package main;

import fileLogic.Parser;
import models.handlers.RoutesCollectionHandler;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        RoutesCollectionHandler.setRoutesCollection(Parser.parse());
        LauncherService.init();


    }
}