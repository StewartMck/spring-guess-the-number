package com.smckinlay.config;

import com.smckinlay.GuessCount;
import com.smckinlay.MaxNumber;
import com.smckinlay.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.smckinlay")
@PropertySource("classpath:config/game.properties")
public class GameConfig {

    // ==   fields  ==
    @Value("${game.maxNumber:20}")
    private int maxNumber;

    @Value("${game.guessCount:5}")
    private int guessCount;

    @Value("${game.minNumber:1}")
    private int minNumber;

    // ==   bean methods    ==

    @Bean
    @MinNumber
    public int minNumber() {
        return minNumber;
    }

    @Bean
    @MaxNumber
    public int maxNumber() {
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount() {
        return guessCount;
    }

}
