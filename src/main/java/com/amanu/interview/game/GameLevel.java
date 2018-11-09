package com.amanu.interview.game;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Amanuel Nega on November 07, 2018.
 */
public class GameLevel {

    private List<LevelEntry> levelEntries;

    public List<LevelEntry> getLevelEntries() {
        if (levelEntries == null) {
            levelEntries = new ArrayList<>();
        }

        return levelEntries;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {
        private GameLevel gameLevel = new GameLevel();

        public Builder addLevelEntry(LevelEntry entry) {
            gameLevel.getLevelEntries().add(entry);

            return this;
        }

        public GameLevel build() {
            return gameLevel;
        }
    }

}
