package com.amanu.interview.persistence;

import com.amanu.interview.game.GamePlay;

/**
 * @author Amanuel Nega on November 12, 2018.
 */
public interface GamePlayPersistenceHandler {
    
    void persistGamePlay(GamePlay gamePlay);

    GamePlay getPreviousGamePlay();
    
}
