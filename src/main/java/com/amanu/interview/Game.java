package com.amanu.interview;

import com.amanu.interview.display.GameDisplay;
import com.amanu.interview.game.GameLevel;
import com.amanu.interview.game.GamePlay;
import com.amanu.interview.game.LevelEntry;
import com.amanu.interview.view.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Amanuel Nega on November 07, 2018.
 */
public class Game implements Runnable {

    public static final int POINTS_PER_LEVEL = 10;
    public static final int POINTS_BEFORE_CHALLENGE = 3;
    public static final int LEVEL_ENTRY_POINTS = 1;
    public static final int CHALLENGE_POINTS = 7;
    private GameDisplay gameDisplay;
    private List<GameLevel> gameLevels;
    private GamePlay gamePlay;
    private Runnable onFinishListener;
    private GameLevel gameLevel;
    private Iterator<GameLevel> gameLevelIterator;
    private Iterator<LevelEntry> currentLevelEntriesIterator;
    private LevelEntry currentLevelEntry;

    public Game(GameDisplay gameDisplay, Runnable onFinishListener) {
        this.gameDisplay = gameDisplay;
        this.onFinishListener = onFinishListener;
    }

    public void startGame() {
        showHomeView();
    }

    public void finishGame() {
        onFinishListener.run();
    }

    public void showHomeView() {
        HomeView homeView = new HomeView((m) -> showCreateCharacterView());

        drawWithDecorator(homeView);
    }

    public void drawWithDecorator(View view) {
        gameDisplay.draw(new MainDecoratorView(view, (s) -> finishGame()));
    }

    public void showCreateCharacterView() {
        CreateCharacterView view = new CreateCharacterView((name) -> {
            //Just chose a character,
            initiateGamePlay(name);
            showGamePlayView();
        });

        drawWithDecorator(view);
    }

    public void initiateGamePlay(String name) {

        gamePlay = new GamePlay(name);
        prepareGameLevels();
    }

    public void showGamePlayView() {

        while (true) {
            if (hasMoreEntries()) {
                moveToNextLevelEntry();
                showTranslationView();
            } else {
                if (isReadyForChallenge()) {
                    showChallengeView();
                } else if (!hasMoreEntries()) {
                    moveToNextLevel();
                } else {
                    showGameOver();
                    break;
                }
            }
        }
    }

    public boolean isReadyForChallenge() {
        int pointsAfterLastLevel = gamePlay.getPoints() % POINTS_PER_LEVEL;

        return pointsAfterLastLevel > 0 && pointsAfterLastLevel % POINTS_BEFORE_CHALLENGE == 0;
    }

    private void showChallengeView() {

        drawWithDecorator(new ChallengeView(
                gamePlay,
                gameLevel,
                (o) -> {
                    gamePlay.addToPoints(CHALLENGE_POINTS);
                },
                (o) -> {
                    restartLevel();
                    gamePlay.addToPoints(0 - Math.min(gamePlay.getPoints(), POINTS_BEFORE_CHALLENGE));
                }));
    }

    private void restartLevel() {
        currentLevelEntriesIterator = gameLevel.getLevelEntries().iterator();
        currentLevelEntry = null;
    }

    private void showTranslationView() {

        drawWithDecorator(new TranslationView(
                currentLevelEntry,
                (exps) -> {
                    //Like saying next
                    gamePlay.addToPoints(LEVEL_ENTRY_POINTS);
                }));
    }

    private void showGameOver() {
    }

    private void moveToNextLevel() {

        gameLevel = gameLevelIterator.next();
        currentLevelEntriesIterator = gameLevel.getLevelEntries().iterator();
    }

    public void prepareGameLevels() {

        gameLevels = fetchGameLevels();

        gameLevelIterator = gameLevels.iterator();
    }

    public List<GameLevel> fetchGameLevels() {
        List<GameLevel> gameLevels = new ArrayList<>();

        gameLevels.add(
                GameLevel.builder()
                        .addLevelEntry(LevelEntry.of("Good Morning", "Endemn aderk", "Endemen adersh"))
                        .addLevelEntry(LevelEntry.of("Good Afternoon", "Endemn walk", "Endemen walish"))
                        .addLevelEntry(LevelEntry.of("Good Evening", "Endemn amesheh", "Endemen ameshesh"))
                        .build()
        );

        gameLevels.add(
                GameLevel.builder()
                        .addLevelEntry(LevelEntry.of("Let me buy you dinner", "Erat legabzeh", "Erat Legabzesh"))
                        .addLevelEntry(LevelEntry.of("Are you feeling better?", "Teshaleh?", "Teshalesh?"))
                        .addLevelEntry(LevelEntry.of("I'm going to kill you", "Egelehalew", "Egeleshalew"))
                        .build()
        );

        return gameLevels;
    }

    private boolean hasMoreLevels() {
        return gameLevelIterator != null && gameLevelIterator.hasNext();
    }

    private boolean hasMoreEntries() {
        return currentLevelEntriesIterator != null && currentLevelEntriesIterator.hasNext();
    }

    public void moveToNextLevelEntry() {
        currentLevelEntry = currentLevelEntriesIterator.next();
    }

    @Override
    public void run() {
        startGame();
    }
}
