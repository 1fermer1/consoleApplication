package main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import commandManager.CommandManager;
import commandManager.commands.HistoryCommand;
import commandManager.commands.ICommandable;
//import fileLogic.JSONReader;
import fileLogic.Parser;
import fileLogic.editors.DateEditor;
import models.Route;
import models.handlers.RoutesCollectionHandler;

import java.io.*;
import java.time.ZonedDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        RoutesCollectionHandler.setRoutesCollection(Parser.parse());
        LauncherService.init();

    }

}