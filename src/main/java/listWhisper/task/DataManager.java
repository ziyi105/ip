package listWhisper.task;

// Inspired by TaskS
import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;

public abstract class DataManager {
    private final static String userWorkingDirectory = System.getProperty("user.dir");
    private final static  java.nio.file.Path FILE_PATH = java.nio.file.Paths.get(userWorkingDirectory, "data.txt");

    public static void saveList(String listOfFormattedTasks) throws IOException {
        Files.delete(FILE_PATH);
        Files.writeString(FILE_PATH, listOfFormattedTasks);
    }

    public static ArrayList<String> readFile() throws IOException {
        boolean directoryExists = java.nio.file.Files.exists(FILE_PATH);

        if (!directoryExists) {
            Files.createFile(FILE_PATH);
        }

        return (ArrayList<String>) Files.readAllLines(FILE_PATH);
    }
}
