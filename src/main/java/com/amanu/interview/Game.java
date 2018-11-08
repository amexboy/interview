package com.amanu.interview;

import com.amanu.interview.display.GameDisplay;
import com.amanu.interview.game.GamePlay;
import com.amanu.interview.view.CreateCharacterView;
import com.amanu.interview.view.HomeView;
import com.amanu.interview.view.MainDecoratorView;

/**
 * @author Amanuel Nega on November 07, 2018.
 */
public class Game implements Runnable {
    
    private GameDisplay gameDisplay;
    
    private GamePlay gamePlay;
    private Runnable onFinishListener;

    public Game(GameDisplay gameDisplay, Runnable onFinishListener) {
        this.gameDisplay = gameDisplay;
        this.onFinishListener = onFinishListener;
    }

    @Override
    public void run() {
        showHomeView();

        onFinishListener.run();
    }

    public void showHomeView() {
        HomeView homeView = new HomeView((m) -> {
            showCreateCharacterView();
        });

        gameDisplay.draw(new MainDecoratorView(homeView, (s) -> {
            onFinishListener.run();
        }));
    }

    public void showCreateCharacterView() {
        gameDisplay.draw(new CreateCharacterView((menu) -> {
        }));
    }

}
