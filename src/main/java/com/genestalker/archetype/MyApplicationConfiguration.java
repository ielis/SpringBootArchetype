package com.genestalker.archetype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Add your beans here.
 *
 */
@Configuration
public class MyApplicationConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyApplicationConfiguration.class);

    private final Environment env;


    public MyApplicationConfiguration(Environment env) {
        this.env = env;
    }


    @Bean
    public String helloWorld() {
        LOGGER.debug("Initializing the 'Hello world' bean");
        return "\nHello world!\n";
    }


    @Bean
    public String helloUniverse() {
        LOGGER.debug("Initializing the 'Hello universe' bean");
        return env.getProperty("hello.universe");
    }


    @Bean
    public String projectName() {
        return env.getProperty("project.name");
    }


    @Bean
    public String projectVersion() {
        return MyApplicationConfiguration.class.getPackage().getImplementationVersion();
    }
}
