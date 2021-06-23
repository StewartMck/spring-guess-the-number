package com.smckinlay;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class MessageGeneratorImpl implements MessageGenerator {

    // == constants ==
    private static final String MAIN_MESSAGE = "game.message.main";
    public static final String FIRST = "game.message.first";
    private static final String WIN = "game.message.win";
    private static final String LOST = "game.message.lost";
    private static final String INVALID = "game.message.invalid";
    private static final String LOWER = "game.message.lower";
    private static final String HIGHER = "game.message.higher";
    private static final String REMAINING = "game.message.remaining";

//    private static final Logger logger = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    // == fields ==
    private final Game game;
    private final MessageSource messageSource;

    // == constructors ==
    @Autowired
    public MessageGeneratorImpl(Game game, MessageSource messageSource)
    {
        this.game = game;
        this.messageSource = messageSource;
    }

    // == init ==
    @PostConstruct
    public void init() {
        log.info("game = {}", game);
    }

    // == public methods ==
    @Override
    public String getMainMessage() {
        return getMessage(MAIN_MESSAGE, game.getSmallest(), game.getBiggest());
//        return "Number is between " +
//                game.getSmallest() +
//                " and " + game.getBiggest() +
//                ". Can you guess it?";
    }

    @Override
    public String getResultMessage() {
        if(game.isGameWon()) {
            return getMessage(WIN, game.getNumber());
        } else if(game.isGameLost()) {
            return getMessage(LOST, game.getNumber());
        } else if (!game.isValidNumberRange()) {
            return getMessage(INVALID);
        } else if(game.getRemainingGuesses() == game.getGuessCount()) {
            return getMessage(FIRST);
        } else {
            String direction = getMessage(LOWER);
            if(game.getGuess() < game.getNumber()) {
                direction = getMessage(HIGHER);
            }
                return getMessage(REMAINING, direction, game.getRemainingGuesses());
        }
//        return "GetResultsMessage() called";
    }

    // == private methods ==
    private String getMessage(String code, Object... args) {
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }
}
