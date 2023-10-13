package pl.coderslab;

import java.util.Scanner;

public class Menu {
    public static void openMenu(){
        final String[] menuOptions = {"[1] add", "[2] remove", "[3] list", "[4] exit"};
        for (String menuOption : menuOptions) {
            System.out.println(menuOption);
        }
        System.out.println("Please choose one option");
    }

    public static int choosingMenuOption(){
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }
}
