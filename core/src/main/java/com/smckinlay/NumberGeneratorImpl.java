package com.smckinlay;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Slf4j
@Getter
public class NumberGeneratorImpl implements NumberGenerator{

    // == constants ==
//    private static final Logger log = LoggerFactory.getLogger(NumberGeneratorImpl.class);

    // == fields ==
    @Getter(AccessLevel.NONE)
    private final Random random = new Random();

//    @Autowired
//    @MaxNumber
//    private int maxNumber;
//    @Autowired
//    @MinNumber
//    private int minNumber;

    private final int maxNumber;
    private final int minNumber;

    @Autowired
    public NumberGeneratorImpl(@MaxNumber int maxNumber, @MinNumber int minNumber) {
        this.maxNumber = maxNumber;
        this.minNumber = minNumber;
    }

    // == Public methods ==

    @Override
    public int next() {
        return (int)Math.floor(Math.random()*(maxNumber-minNumber+1)+minNumber);
    }

//    @Override
//    public int getMinNumber() {
//        return minNumber;
//    }
//
//    @Override
//    public int getMaxNumber() {
//        return maxNumber;
//    }
}
