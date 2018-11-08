package com.amanu.interview;

import com.amanu.interview.display.GameDisplay;
import com.amanu.interview.display.GameDisplayFactory;

public class Main {
    public static void main(String[] args) {
        GameDisplay gameDisplay = GameDisplayFactory.createCLIGameDisplay();

        Game game = new Game(gameDisplay);
        game.setOnFinishListener(() -> {
            System.exit(0);
        });


        new Thread(game).start();
    }
}