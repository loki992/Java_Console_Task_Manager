package pl.coderslab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.APPEND;

public class TasksMethods {

    public static ArrayList<String> loadWholeFile () {
        Path path = Paths.get("tasks.csv");
        ArrayList<String> tasksList;
        try {
            tasksList = new ArrayList<>(Files.readAllLines(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return tasksList;
    }

    public static void listingExistingTasks(ArrayList<String> list) {
        System.out.println();
        for (Object singleTask : list) {
            System.out.println(list.indexOf(singleTask)+": "+singleTask);
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

    public static ArrayList<String> removingExistingTask(ArrayList<String> originalListOfTasks) {
        System.out.println("removing existing task");
        Scanner scannIndexToRemove = new Scanner(System.in);
        int indexToRemove = Integer.parseInt(scannIndexToRemove.nextLine());
        originalListOfTasks.remove(indexToRemove);
        return originalListOfTasks;
    }
}
