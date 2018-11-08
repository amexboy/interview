package com.amanu.interview.view;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Amanuel Nega on November 07, 2018.
 */
public class HomeView implements View {

    private List<Menu> menus;

    public HomeView(Consumer<Menu> onStart) {
        this.menus = new ArrayList<>();

        this.menus.add(new Menu("Start Game", onStart));
    }

    @Override
    public String getTitle() {
        return "Home";
    }

    @Override
    public String getHeader() {
        return "Welcome to RPG" +
                "\n\n" +
                "You'll be learning a little bit of Amharic with this Game." +
                "\nYou will be taken through some lessons and at the end you'll take pop quizes." +
                "\nEach step on the lesson counts as 1 experience and the pop quiz counts as 5" +
                "\nYou'll get to the next level when you get to 13 experiences." +
                "\n\n\n\n" +
                "Enjoy";
    }

    @Override
    public List<Menu> getMenus() {
        return this.menus;
    }
}
