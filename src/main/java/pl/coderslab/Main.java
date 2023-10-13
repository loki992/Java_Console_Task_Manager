package pl.coderslab;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> loadedList = TasksMethods.loadWholeFile();
        System.out.println();
        System.out.println("<------Console Task Manager------>");
        while(true) {
            Menu.openMenu();
            switch (Menu.choosingMenuOption()){
                case 1:
                    TasksMethods.addingNewTask();
                    break;
                case 2:
                    TasksMethods.removingExistingTask(loadedList);
                    break;
                case 3:
                    TasksMethods.listingExistingTasks(loadedList);
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}