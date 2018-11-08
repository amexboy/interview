package com.amanu.interview.display;

public class GameDisplayFactory {

    public static GameDisplay createCLIGameDisplay() {
        return new CLIGameDisplay();
    }

    public static GameDisplay createGUIGameDisplay() {
        throw new UnsupportedOperationException();
    }

}
