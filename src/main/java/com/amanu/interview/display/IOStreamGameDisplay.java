package com.amanu.interview.display;

import com.amanu.interview.view.Menu;
import com.amanu.interview.view.View;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

/**
 * @author Amanuel Nega on November 08, 2018.
 */
public class IOStreamGameDisplay implements GameDisplay {

    private final PrintStream out;
    private final InputStream in;
    private Scanner scanner;

    public IOStreamGameDisplay(PrintStream out, InputStream in) {
        this.out = out;
        this.in = in;

        this.scanner = new Scanner(this.in);
    }

    @Override
    public void draw(View view) {
        out.println(view.getTitle());

        out.println(view.getHeader());

        List<Menu> menus = view.getMenus();
        for (int i = 0; i < menus.size(); i++) {
            Menu m = menus.get(i);
            out.println((i + 1) + ". " + m.getTitle());
        }

        if (!menus.isEmpty()) {
            int index = -1;
            
            for (int i = 0; i < 5; i++) {
                out.println("Enter your choice: ");


                try {
                    index = waitForMenuIndexInput(menus.size());

                    break;
                } catch (Exception ex) {
                    out.println("Invalid input.");
                }
            }

            if (index > 0) {
                Menu menu = menus.get(index - 1);
                menu.getConsumer().accept(menu);
            }
        }
    }

    public int waitForMenuIndexInput(int totalMenus) {
        String input = scanner.nextLine();
        int index = Integer.parseInt(input);

        if (index > totalMenus) {
            throw new RuntimeException();
        }

        return index;
    }
}
