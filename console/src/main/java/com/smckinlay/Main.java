package com.smckinlay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

//    private static final Logger log = LoggerFactory.getLogger(Main.class);

//    private static final String CONFIG_LOCATION = "beans.xml_deleted";

    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);

        // create context (container)
//        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);

//        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(GameConfig.class);
//        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // get number generator bean from context (container)
//        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);

        // call method next() to get random number
//        int number = numberGenerator.next();

        // log generated number
//        log.info("number = {}", number);

        // get game bean from context (container)
//        Game game = context.getBean(Game.class);

        // reset
//        game.reset();

//        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);
//        log.info("getMainMessage= {}", messageGenerator.getMainMessage());
//        log.info("getResultsMessage= {}", messageGenerator.getResultMessage());

        // close context (container)
//        context.close();

    }

}
