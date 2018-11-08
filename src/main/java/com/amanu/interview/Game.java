package com.amanu.interview;

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

        gameDisplay.draw(new DecoratorView(homeView, (s) -> {
            onFinishListener.run();
        }));
    }

}
