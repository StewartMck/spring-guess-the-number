package com.smckinlay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class MessageGeneratorImpl implements MessageGenerator {

    // == constants ==
    private static final Logger logger = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    // == fields ==
    @Autowired
    private Game game;

    // == init ==
    @PostConstruct
    public void init() {
        logger.info("game = {}", game);
    }

    // == public methods ==

    @Override
    public String getMainMessage() {
        return "Number is between " +
                game.getSmallest() +
                " and " + game.getBiggest() +
                ". Can you guess it?";
    }

    @Override
    public String getResultMessage() {
        if(game.isGameWon()) {
            return "You guessed it! The number was " + game.getNumber();
        } else if(game.isGameLost()) {
            return "You Lost! The number was " + game.getNumber();
        } else if (!game.isValidNumberRange()) {
            return "Invalid number range!";
        } else if(game.getRemainingGuesses() == game.getGuessCount()) {
            return "What is you first guess?";
        } else {
            String direction = "Lower";
            if(game.getGuess() < game.getNumber()) {
                direction = "higher";
                return direction + "! You have " + game.getRemainingGuesses() + (game.getRemainingGuesses() > 1 ? " guesses" : " guess")  + " left.";
            } else if(game.getGuessCount() > game.getNumber()) {
                return direction + "! You have " + game.getRemainingGuesses() + (game.getRemainingGuesses() > 1 ? " guesses" : " guess")  + " left.";
            }
        }
        return "GetResultsMessage() called";
    }
}
