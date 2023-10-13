package pl.coderslab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TasksMethods {

    public static void listingExistingTasks() {
        System.out.println();
        Path path = Paths.get("tasks.csv");
        try {
            for (String line: Files.readAllLines(path)){
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
    }
    public static void addingNewTask (){
        System.out.println("adding new task");
    }

    public static void removingExistingTask (){
        System.out.println("removing existing task");
    }
}
