package pl.coderslab;

import java.util.Scanner;

public class Menu {
    public static void openMenu() {
        final String[] menuOptions = {"add", "remove", "list", "exit"};

        for (int i = 0; i < menuOptions.length; i = i + 2) {
            System.out.println(ConsoleColors.YELLOW_BOLD + i + ": " + menuOptions[i]);
            System.out.println(ConsoleColors.BLUE_BOLD + (i + 1) + ": " + menuOptions[i + 1]);
        }
        System.out.println(ConsoleColors.GREEN_BOLD + "Please choose one option");
    }

    public static int choosingMenuOption() {
        Scanner scanner = new Scanner(System.in);
        String menuChoiceTemp = scanner.nextLine();
        try {
            return Integer.parseInt(menuChoiceTemp);
        } catch (NumberFormatException e) {
            if (menuChoiceTemp.trim().equalsIgnoreCase("add") || menuChoiceTemp.trim().equalsIgnoreCase("a")) {
                return 0;
            } else if (menuChoiceTemp.trim().equalsIgnoreCase("remove") || menuChoiceTemp.trim().equalsIgnoreCase("r")) {
                return 1;
            } else if (menuChoiceTemp.trim().equalsIgnoreCase("list") || menuChoiceTemp.trim().equalsIgnoreCase("l")) {
                return 2;
            } else if (menuChoiceTemp.trim().equalsIgnoreCase("exit") || menuChoiceTemp.trim().equalsIgnoreCase("e")) {
                System.exit(0);
            } else {
                System.out.println("Please provide correct choice");
                choosingMenuOption();
            }

        }
        return 2;
    }
}
