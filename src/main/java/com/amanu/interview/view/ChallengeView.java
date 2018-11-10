package com.amanu.interview.view;

import com.amanu.interview.game.GameLevel;
import com.amanu.interview.game.GamePlay;
import com.amanu.interview.game.LevelEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

/**
 * @author Amanuel Nega on November 07, 2018.
 */
public class ChallengeView implements View {

    private final GamePlay gamePlay;
    private final GameLevel gameLevel;
    private final List<Menu> menus;
    private final Consumer<Menu> wrong;
    private Consumer<Menu> correct;
    private final String header;

    public ChallengeView(GamePlay gamePlay, GameLevel gameLevel,
                         Consumer<Menu> correct, Consumer<Menu> wrong) {

        this.gamePlay = gamePlay;
        this.gameLevel = gameLevel;
        this.correct = correct;
        this.wrong = wrong;

        Random random = new Random();

        boolean askForFemaleTranslation = random.nextBoolean();
        List<LevelEntry> entries = new ArrayList<>(gameLevel.getLevelEntries());
        int index = random.nextInt(entries.size()) ;

        LevelEntry randomlySelectedEntry = entries.remove(index);
        header = "What does '" + randomlySelectedEntry.getPhrase() + "' translate to for a " + (askForFemaleTranslation ? "female" : "male") + "?";


        this.menus = prepareMenus(entries, randomlySelectedEntry, askForFemaleTranslation, correct, wrong);
    }

    public List<Menu> prepareMenus(List<LevelEntry> entries, LevelEntry randomlySelectedEntry, boolean askForFemaleTranslation, Consumer<Menu> correct, Consumer<Menu> wrong) {
        List<Menu> menus = new ArrayList<>();

        menus.add(new Menu(randomlySelectedEntry.getFemaleTranslation(), askForFemaleTranslation ? correct : wrong));
        menus.add(new Menu(askForFemaleTranslation ? entries.get(0).getMaleTranslation() : entries.get(0).getFemaleTranslation(), wrong));
        menus.add(new Menu(randomlySelectedEntry.getMaleTranslation(), askForFemaleTranslation ? wrong : correct));

        return menus;
    }

    @Override
    public String getTitle() {
        return "Game";
    }

    @Override
    public String getHeader() {
        return header;
    }

    @Override
    public List<Menu> getMenus() {
        return menus;
    }

}
