package com.amanu.interview;

import com.amanu.interview.display.GameDisplay;
import com.amanu.interview.game.GameLevel;
import com.amanu.interview.game.GamePlay;
import com.amanu.interview.game.LevelEntry;
import com.amanu.interview.view.CreateCharacterView;
import com.amanu.interview.view.GamePlayView;
import com.amanu.interview.view.HomeView;
import com.amanu.interview.view.MainDecoratorView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Amanuel Nega on November 07, 2018.
 */
public class Game implements Runnable {
    
    private GameDisplay gameDisplay;
    private List<GameLevel> gameLevels;
    private GamePlay gamePlay;
    private Runnable onFinishListener;
    private GameLevel gameLevel;
    private Iterator<GameLevel> gameLevelIterator;
    private List<LevelEntry> currentLevelEntries;
    private Iterator<LevelEntry> currentLevelEntriesIterator;
    private LevelEntry currentLevelEntry;

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
        gameDisplay.draw(new CreateCharacterView((name) -> {
            //Just chose a character,
            initiateGamePlay(name);
            showGamePlayView();
        }));
    }

    public void initiateGamePlay(String name) {

        gamePlay = new GamePlay(name);
        prepareGameLevels();
    }

    public void showGamePlayView() {
        gameDisplay.draw(new GamePlayView(
                gamePlay,
                gameLevel,
                (exps) -> {
                    //Like saying next
//                    gamePlay.addToPoints(currentLevelEntry.getPoints());
                    if (gamePlay.getPoints() % 10 == 0) {
                        if (gameLevelIterator.hasNext()) {
                            gameLevel = gameLevelIterator.next();
                            showGamePlayView();
                        } else {
                            moveToNextLevel();
                        }
                    } else {
                        showGamePlayView();
                    }
                }));
    }

    private void showGameOver() {

    }

    private void moveToNextLevel() {

    }

    public void prepareGameLevels() {

        gameLevels = new ArrayList<>();

        gameLevels.add(
                GameLevel.builder()
                        .addLevelEntry(LevelEntry.of("Good Morning", "Endemn aderk", "Endemen adersh"))
                        .addLevelEntry(LevelEntry.of("Good Afternoon", "Endemn walk", "Endemen walish"))
                        .addLevelEntry(LevelEntry.of("Good Evening", "Endemn amesheh", "Endemen ameshesh"))
                        .build()
        );

        gameLevelIterator = gameLevels.iterator();
        gameLevel = gameLevelIterator.next();
        currentLevelEntries = gameLevel.getLevelEntries();
        currentLevelEntriesIterator = currentLevelEntries.iterator();
        currentLevelEntry = currentLevelEntriesIterator.next();

    }
}
