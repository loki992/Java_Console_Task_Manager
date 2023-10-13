package pl.coderslab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.APPEND;

public class TasksMethods {

    public static void listingExistingTasks() {
        System.out.println();
        Path path = Paths.get("tasks.csv");
        try {
            for (String line : Files.readAllLines(path)) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
    }

    public static void addingNewTask() {
        System.out.println("adding new task");
        System.out.println("New task description:");
        Scanner scannerAddingTask = new Scanner(System.in);
        String newTaskDescription = scannerAddingTask.nextLine();
        System.out.println("New task due date:");
        String newTaskDate = scannerAddingTask.nextLine();
        System.out.println("Is the new task important? [y]es / [n]o :");
        boolean newTaskImportance;
        String utilTaskImportance = scannerAddingTask.nextLine().trim().toLowerCase();
        if (utilTaskImportance.equals("y")) {
            newTaskImportance = true;
        } else if (utilTaskImportance.equals("n")) {
            newTaskImportance = false;
        } else {
            System.out.println("Wrong input, going back to menu");
            return;
        }
        Path path = Paths.get("tasks.csv");
        try {
            Files.writeString(path, "\n" + newTaskDescription + ", " + newTaskDate + ", " + newTaskImportance, APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void removingExistingTask() {
        System.out.println("removing existing task");
    }
}
