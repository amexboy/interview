package com.amanu.interview;

import com.amanu.interview.display.GameDisplay;
import com.amanu.interview.game.GamePlay;
import com.amanu.interview.view.MainDecoratorView;
import com.amanu.interview.view.HomeView;

/**
 * @author Amanuel Nega on November 07, 2018.
 */
public class Game implements Runnable {
    
    private GameDisplay gameDisplay;
    
    private GamePlay gamePlay;
    private Runnable onFinishListener;

    public Game(GameDisplay gameDisplay) {
        this.gameDisplay = gameDisplay;
    }

    public void setOnFinishListener(Runnable action) {
        this.onFinishListener = action;
    }

    @Override
    public void run() {
        showHomeView();

        onFinishListener.run();
    }

    private void showHomeView() {
        HomeView homeView = new HomeView((s) -> {
//            showGameView();
//            TODO: Create a character
        });

        gameDisplay.draw(new MainDecoratorView(homeView, (s) -> {
            onFinishListener.run();
        }));
    }

}
