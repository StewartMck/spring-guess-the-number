package com.smckinlay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

public class NumberGeneratorImpl implements NumberGenerator{

    // == constants ==
    private static final Logger log = LoggerFactory.getLogger(NumberGeneratorImpl.class);

    // == fields ==
    private final Random random = new Random();

    @Autowired
    @MaxNumber
    private int maxNumber;

    @Autowired
    @MinNumber
    private int minNumber;

    // == Public methods ==

    @Override
    public int next() {
        return (int)Math.floor(Math.random()*(maxNumber-minNumber+1)+minNumber);
    }

    @Override
    public int getMinNumber() {
        return minNumber;
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }
}
