package com.amanu.interview.view;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MainDecoratorView implements View {

    private final View view;
    private Consumer<Menu> onExit;

    public MainDecoratorView(View view, Consumer<Menu> onExit) {
        this.view = view;
        this.onExit = onExit;
    }

    @Override
    public String getTitle() {
        return "RPG::" + view.getTitle();
    }

    @Override
    public String getHeader() {
        return " .----------------.  .----------------.  .----------------.  .----------------. \n" +
                "| .--------------. || .--------------. || .--------------. || .--------------. |\n" +
                "| |    ______    | || |      __      | || | ____    ____ | || |  _________   | |\n" +
                "| |  .' ___  |   | || |     /  \\     | || ||_   \\  /   _|| || | |_   ___  |  | |\n" +
                "| | / .'   \\_|   | || |    / /\\ \\    | || |  |   \\/   |  | || |   | |_  \\_|  | |\n" +
                "| | | |    ____  | || |   / ____ \\   | || |  | |\\  /| |  | || |   |  _|  _   | |\n" +
                "| | \\ `.___]  _| | || | _/ /    \\ \\_ | || | _| |_\\/_| |_ | || |  _| |___/ |  | |\n" +
                "| |  `._____.'   | || ||____|  |____|| || ||_____||_____|| || | |_________|  | |\n" +
                "| |              | || |              | || |              | || |              | |\n" +
                "| '--------------' || '--------------' || '--------------' || '--------------' |\n" +
                " '----------------'  '----------------'  '----------------'  '----------------' \n" +
                "\n\n"
                + view.getHeader();
    }

    @Override
    public List<Menu> getMenus() {
        List<Menu> menus = new ArrayList<>(view.getMenus());
        menus.add(Menu.of("Exit", onExit));

        return menus;
    }
}
