package com.genestalker.archetype;

import com.genestalker.archetype.cmd.AbstractCommand;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 *
 */
@Component
public class MyCommandLineRunner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyCommandLineRunner.class);

    private final ArgumentParser argumentParser;

    private final ApplicationContext ctx;


    public MyCommandLineRunner(ArgumentParser argumentParser, ApplicationContext ctx) {
        this.argumentParser = argumentParser;
        this.ctx = ctx;
    }


    @Override
    public void run(String... args) throws Exception {
        if (args.length == 0) {
            LOGGER.error("Please supply some command line arguments - none found");
            argumentParser.printHelp();
            return;
        }

        Namespace namespace;
        try {
            namespace = argumentParser.parseArgs(args);
        } catch (ArgumentParserException ape) {
            argumentParser.handleError(ape);
            System.exit(1);
            return;
        }

        Function<Namespace, AbstractCommand> commandFactory = namespace.get("cmd");
        AbstractCommand cmd = commandFactory.apply(namespace);

        ctx.getAutowireCapableBeanFactory().autowireBean(cmd);

        try {
            cmd.execute();
        } catch (Exception e) {
            LOGGER.error("Error occured: ", e);
            System.exit(1);
            return;
        }

        LOGGER.info("Finished!" + System.lineSeparator());

    }
}
