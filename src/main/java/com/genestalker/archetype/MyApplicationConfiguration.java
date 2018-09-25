package com.genestalker.archetype;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Add your beans here.
 *
 * @author <a href="mailto:daniel.danis@jax.org">Daniel Danis</a>
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
