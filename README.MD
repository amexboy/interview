# Interview Role Playing Game

This repository holds a small project to create a small RPG to show off my coding skills. I wouldn't exactly say it's big enough to show off but I belive it's enough to show my coding practices.
I tried to utilize some common design patters without over using it.

## The Game

The game tries to teach some basic phrases to non Amharic speakers (Amharic is one of the 80+ languages spoken in Ethiopia).
It saves game progress to file. (Restoring a game will just get the points, but not the level :-( will improve) 

You, as a game player, will get an introduction to some phrases and will take a challenge
at the end of each level. The game has only been configured for two levels.

The easiest way to run the game is via gradle (Gradle will have somethings around it, sorry).

    $ ./gradlew run
    
If you miss a challenge, your points will be taken back and you'll take the lesson again.

Game over currently just finishes the game. :-( 

## The Tests

The tests are proof of concepts. I used spock test. I als used Mockito  to do some mocking.

The tests can  be run via gradle using

    $ ./gradlew test
    
## The Design Patterns

### Factory Pattern

`GameDisplayFactory` Is a factory for game displays. It is capable of creating CLI or GUI game displays.
The later would just through an exception. 

`MainDecoratorView` and `GamePlayDecoratorView` Use the decorator pattern to enhance a view to add more functionality.
They implement the `View` interface themselves.

`GameLevel` has a builder `GameLevel.Builder` which uses the builder pattern. 

