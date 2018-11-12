package com.amanu.interview;

import com.amanu.interview.display.GameDisplay;
import com.amanu.interview.display.GameDisplayFactory;
import com.amanu.interview.persistence.FileGamePlayPersistenceHandler;

public class Main {
    public static void main(String[] args) {
        GameDisplay gameDisplay = GameDisplayFactory.createCLIGameDisplay();

        Game game = new Game(gameDisplay, () -> {
            System.exit(0);
        });

        // Dome kind of DI :-) 
        game.setGamePlayPersistenceHandler(new FileGamePlayPersistenceHandler());

        new Thread(game).start();
    }
}