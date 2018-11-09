package com.amanu.interview.game;

/**
 * @author Amanuel Nega on November 07, 2018.
 */
public class GamePlay {

    private final String name;
    private Integer points = 0;

    public GamePlay(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public void addToPoints(int points) {
        this.points += points;
    }
}
