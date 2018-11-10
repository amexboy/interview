package com.amanu.interview

import com.amanu.interview.display.IOStreamGameDisplay
import spock.lang.Specification

import static org.mockito.ArgumentMatchers.anyInt
import static org.mockito.Mockito.*

/**
 * @author Amanuel Nega on November 08, 2018.
 */


class GameTest extends Specification {
    def "Verify first page has the required menus"() {

        given:
        def out = new ByteArrayOutputStream()
        PipedOutputStream inputSrc = new PipedOutputStream()

        def display = spy(new IOStreamGameDisplay(new PrintStream(out), new PipedInputStream(inputSrc)))
        doReturn(1)
                .when(display)
                .waitForMenuIndexInput(anyInt())

        Game game = new Game(display, new Runnable() {
            @Override
            void run() {
            }
        })

        when:
        game.startGame()

        then:
        out.toString().contains("1. Start Game")
        out.toString().contains("2. Exit")

    }

    def "Verify choosing a menu calles the correct call back"() {

        given:
        def out = new ByteArrayOutputStream()
        PipedOutputStream inputSrc = new PipedOutputStream()

        def display = new IOStreamGameDisplay(new PrintStream(out), new PipedInputStream(inputSrc))

        def game = spy(new Game(display, new Runnable() {
            @Override
            void run() {
            }
        }))

        when:
        inputSrc.write("1\n1\n".bytes)
        inputSrc.flush()
        game.startGame()

        then:
        verify(game, times(1)).showCreateCharacterView()

        def output = out.toString()
        
        output.contains("Which hero/heroin do you want to be?")
        output.contains("1. Tarzan")
        output.contains("2. Robin Hood")
        output.contains("3. Ashwini")
        output.contains("4. Rad")

    }

}