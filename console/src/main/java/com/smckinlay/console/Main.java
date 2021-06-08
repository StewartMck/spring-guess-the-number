package com.smckinlay.console;

import com.smckinlay.config.AppConfig;
import com.smckinlay.Game;
import com.smckinlay.MessageGenerator;
import com.smckinlay.NumberGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

//    private static final String CONFIG_LOCATION = "beans.xml_deleted";

    public static void main(String[] args) {
        log.info("Guess The Number Game");

        // create context (container)
//        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);

        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // get number generator bean from context (container)
        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);

        // call method next() to get random number
        int number = numberGenerator.next();

        // log generated number
        log.info("number = {}", number);

        // get game bean from context (container)
        Game game = context.getBean(Game.class);

        // reset
//        game.reset();

        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);
        log.info("getMainMessage= {}", messageGenerator.getMainMessage());
        log.info("getResultsMessage= {}", messageGenerator.getResultMessage());

        // close context (container)
        context.close();

    }

}
