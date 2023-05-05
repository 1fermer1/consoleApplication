package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class UserInputService {
    private static BufferedReader bufferedReader;
    private static Mode mode;
    private static File scriptFile;

    public static void setScriptFile(File scriptFile) {
        UserInputService.scriptFile = scriptFile;
    }

    public static File getScriptFile() {
        return scriptFile;
    }

    public static BufferedReader getBufferedReader() {
        return bufferedReader;
    }

    public static Mode getMode() {
        return mode;
    }

    public static void setBufferedReader(BufferedReader bufferedReader) {
        UserInputService.bufferedReader = bufferedReader;
    }

    public static void setMode(Mode mode) {
        UserInputService.mode = mode;
    }
}
