package com.amanu.interview.view;

import com.amanu.interview.game.GameLevel;
import com.amanu.interview.game.GamePlay;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/**
 * @author Amanuel Nega on November 07, 2018.
 */
public class GamePlayView implements View {

    private final GamePlay gamePlay;
    private final GameLevel gameLevel;
    private Consumer<?> done;

    public GamePlayView(GamePlay gamePlay, GameLevel gameLevel,
                        Consumer<?> done) {

        this.gamePlay = gamePlay;
        this.gameLevel = gameLevel;
        this.done = done;
    }

    @Override
    public String getTitle() {
        return "Game";
    }

    @Override
    public String getHeader() {
        return "";
    }

    @Override
    public List<Menu> getMenus() {
        return null;
    }

}
