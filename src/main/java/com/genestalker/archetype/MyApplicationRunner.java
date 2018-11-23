package com.genestalker.archetype;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * App's logic belongs here
 */
@Component
public class MyApplicationRunner implements ApplicationRunner {

    private final String helloWorld, helloUniverse;


    public MyApplicationRunner(String helloWorld, String helloUniverse) {
        this.helloWorld = helloWorld;
        this.helloUniverse = helloUniverse;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        /*
         * Implement code here
         */
        System.out.println(helloWorld);
        System.out.println(helloUniverse);
    }
}
