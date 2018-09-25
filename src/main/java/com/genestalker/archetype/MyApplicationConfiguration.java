package com.genestalker.archetype;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @author <a href="mailto:daniel.danis@jax.org">Daniel Danis</a>
 * @version 0.0.1
 * @since 0.0
 */
@Configuration
public class MyApplicationConfiguration {

    private final Environment env;


    public MyApplicationConfiguration(Environment env) {
        this.env = env;
    }

    @Bean
    public String helloWorld() {
        return "\nHello world!\n";
    }

    @Bean
    public String helloUniverse() {
        return env.getProperty("hello.universe");
    }
}
