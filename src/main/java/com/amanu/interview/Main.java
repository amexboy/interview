package com.amanu.interview;

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