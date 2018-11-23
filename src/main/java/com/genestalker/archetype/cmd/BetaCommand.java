package com.genestalker.archetype.cmd;

import net.sourceforge.argparse4j.inf.Namespace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 */
public class BetaCommand extends AbstractCommand {

    private static final Logger LOGGER = LoggerFactory.getLogger(BetaCommand.class);

    @Autowired
    private String helloUniverse;


    public BetaCommand(Namespace namespace) {
        LOGGER.info("{}", namespace);
    }


    @Override
    public void execute() throws Exception {
        LOGGER.info("Running {}", getClass().getSimpleName());
        LOGGER.info("This is hello: {}", helloUniverse);
    }
}
