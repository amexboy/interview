package com.amanu.interview.view;

import com.amanu.interview.game.GamePlay;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class GamePlayDecoratorView implements View {

    private final View view;
    private final GamePlay gamePlay;
    private Consumer<Menu> onExit;

    public GamePlayDecoratorView(View view, GamePlay gamePlay, Consumer<Menu> onExit) {
        this.view = view;
        this.gamePlay = gamePlay;
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
                + "Score: " + gamePlay.getPoints() + "\t\tHero/Heroin: " + gamePlay.getName() + "\n\n"
                + view.getHeader();
    }

    @Override
    public List<Menu> getMenus() {
        List<Menu> menus = new ArrayList<>(view.getMenus());
        menus.add(Menu.of("Exit", onExit));

        return menus;
    }
}
