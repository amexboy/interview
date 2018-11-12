package com.amanu.interview.persistence;

import com.amanu.interview.Game;
import com.amanu.interview.game.GamePlay;
import com.sun.nio.file.ExtendedOpenOption;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.StandardOpenOption;

/**
 * @author Amanuel Nega on November 12, 2018.
 */
public class FileGamePlayPersistenceHandler implements GamePlayPersistenceHandler {
    @Override
    public void persistGamePlay(GamePlay gamePlay) {
        File file = new File(".rpg.save");

        try (OutputStream outputStream = Files.newOutputStream(file.toPath(), StandardOpenOption.CREATE)) {
            PrintWriter printWriter = new PrintWriter(outputStream);

            int points = gamePlay.getPoints();
            int persistablePoints = points - (points % Game.POINTS_PER_LEVEL);
            
            printWriter.write(gamePlay.getName() + ":" + persistablePoints);
            printWriter.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public GamePlay getPreviousGamePlay() {
        File file = new File(".rpg.save");

        try (BufferedReader reader = Files.newBufferedReader(file.toPath())) {

            String line = reader.readLine();
            if (line == null || line.isEmpty() || !line.contains(":")) {
                return null;
            }

            String[] tokens = line.split(":");
            if (tokens.length != 2) {
                return null;
            }

            String name = tokens[0];
            int points = Integer.parseInt(tokens[1]);

            GamePlay gamePlay = new GamePlay(name);
            gamePlay.addToPoints(points);

            return gamePlay;
        } catch (Exception ignored) {
        }

        return null;
    }
}
