package com.amanu.interview.view;

import com.amanu.interview.game.LevelEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Amanuel Nega on November 07, 2018.
 */
public class TranslationView implements View {


    private final List<Menu> menus;
    private LevelEntry levelEntry;
    private Consumer<Menu> done;

    public TranslationView(LevelEntry entry, Consumer<Menu> done) {
        levelEntry = entry;
        this.done = done;
        this.menus = new ArrayList<>();

        this.menus.add(new Menu("Next", done));
    }

    @Override
    public String getTitle() {
        return "Game";
    }

    @Override
    public String getHeader() {
        return levelEntry.getPhrase() + " Translates to \n\n" +
                "'" + levelEntry.getFemaleTranslation() + "' for a female and \n\n" +
                "'" + levelEntry.getMaleTranslation() + "' for a male";
    }

    @Override
    public List<Menu> getMenus() {
        return menus;
    }

}
