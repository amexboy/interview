package com.amanu.interview;

import java.util.List;
import java.util.Scanner;

public class GameDisplayFactory {

    public static GameDisplay createCLIGameDisplay() {
        return new CLIGameDisplay();
    }

    public static GameDisplay createGUIGameDisplay() {
        throw new UnsupportedOperationException();
    }

    private static class CLIGameDisplay implements GameDisplay {

        private Scanner scanner;

        private CLIGameDisplay() {
            this.scanner = new Scanner(System.in);
        }

        @Override
        public void draw(View view) {
            //TODO Clear the cli first

            System.out.println(view.getTitle());

            System.out.println(view.getHeader());

            List<Menu> menus = view.getMenus();
            for (int i = 0; i < menus.size(); i++) {
                Menu m = menus.get(i);
                System.out.println((i + 1) + ". " + m.getTitle());
            }

            if (!menus.isEmpty()) {
                int index;
                while (true) {
                    System.out.println("Enter your choice: ");

                    String input = scanner.nextLine();

                    try {
                        index = Integer.parseInt(input);
                        if (index >= menus.size()) {
                            throw new RuntimeException();
                        }

                        break;
                    } catch (Exception ex) {
                        System.out.println("Invalid input.");
                    }
                }

                Menu menu = menus.get(index - 1);
                menu.getConsumer().accept(menu.getTitle());
            }
        }
    }
}
