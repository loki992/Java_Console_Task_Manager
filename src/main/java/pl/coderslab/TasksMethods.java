package pl.coderslab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.APPEND;

public class TasksMethods {
    static Path path = Paths.get("tasks.csv");


    public static ArrayList<String> loadWholeFile() {

        ArrayList<String> tasksList;

        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

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
            System.out.println(ConsoleColors.BLUE + list.indexOf(singleTask) + ": " + singleTask);
        }
        System.out.println();
    }

    public static ArrayList<String> addingNewTask(ArrayList<String> originalListOfTasks) {
        System.out.println(ConsoleColors.GREEN + "adding new task");
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
            return originalListOfTasks;
        }
        try {
            Files.writeString(path, newTaskDescription + ", " + newTaskDate + ", " + newTaskImportance + "\n", APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        originalListOfTasks.add("\n" + newTaskDescription + ", " + newTaskDate + ", " + newTaskImportance);
        return originalListOfTasks;
    }

    public static ArrayList<String> removingExistingTask(ArrayList<String> originalListOfTasks) {

        System.out.println(ConsoleColors.RED + "Provide task id to remove or -1 to go back: ");
        Scanner scannIndexToRemove = new Scanner(System.in);
        int indexToRemove = -1;
        try {
            indexToRemove = Integer.parseInt(scannIndexToRemove.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Please provide number");
            return removingExistingTask(originalListOfTasks);
        }
        if (0 <= indexToRemove && indexToRemove < originalListOfTasks.size()) {
            originalListOfTasks.remove(indexToRemove);
            try {
                for (String task : originalListOfTasks) {
                    Files.writeString(path, task);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return originalListOfTasks;
        } else if (indexToRemove == -1) {
            System.out.println("Going back");
            return originalListOfTasks;
        } else {
            System.out.println("Wrong id, going back");
            return originalListOfTasks;
        }


    }

}