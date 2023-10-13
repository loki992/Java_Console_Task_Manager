package pl.coderslab;

public class Main {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("<------Console Task Manager------>");
        while(true) {
            Menu.openMenu();
            switch (Menu.choosingMenuOption()){
                case 1:
                    TasksMethods.addingNewTask();
                    break;
                case 2:
                    TasksMethods.removingExistingTask();
                    break;
                case 3:
                    TasksMethods.listingExistingTasks();
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}