package com.amanu.interview;

import java.util.List;

/**
 * @author Amanuel Nega on November 07, 2018.
 */
public interface GameLevel {

    /**
     * The entries involved in this level
     *
     * @return the level entries that will be involved in this level
     */
    List<LevelEntry> getLevelEntries();

    /**
     * Checks if the amount of experience is enough to play at this level
     *
     * @param experiences, the amount of experience to check
     * @return true if the amount of experience is enough to play this level, false otherwise
     */
    boolean qualifies(Integer experiences);

}
