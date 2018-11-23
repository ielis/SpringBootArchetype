package com.genestalker.archetype.cmd;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

/**
 *
 */
@Configuration
public class CLIConfiguration {

    private final String projectName;

    private final String projectVersion;


    public CLIConfiguration(String projectName, String projectVersion) {
        this.projectName = projectName;
        this.projectVersion = projectVersion;
    }


    @Bean
    public ArgumentParser argumentParser() {
        ArgumentParser parser = ArgumentParsers.newFor(projectName)
                .addHelp(true)
                .defaultFormatWidth(120)
                .build()
                .description("Arguments for the program")
                .version(projectVersion);

        Subparsers subparsers = parser.addSubparsers().description("Actions available");

        //======================================= Alpha args ======================================================
        Function<Namespace, AlphaCommand> alphaHandler = AlphaCommand::new;
        Subparser alpha = subparsers.addParser("alpha")
                .help("tell me what will running alpha command do")
                .setDefault("cmd", alphaHandler);
        ArgumentGroup alphaArgs = alpha.addArgumentGroup("arguments for alpha command");
        alphaArgs.addArgument("-d", "--jannovar-db")
                .required(true)
                .metavar("path/to/jannovar.ser")
                .help("path to jannovar transcript database");
        alphaArgs.addArgument("-r", "--ref-genome")
                .required(true)
                .metavar("path/to/refgenome.fa")
                .help("path to ref genome fasta");

        //======================================= Beta args =======================================================
        Function<Namespace, BetaCommand> betaHandler = BetaCommand::new;
        Subparser beta = subparsers.addParser("beta")
                .help("tell me what will running beta command do")
                .setDefault("cmd", betaHandler);
        ArgumentGroup betaArgs = beta.addArgumentGroup("arguments for beta command");
        betaArgs.addArgument("-f", "--foo-db")
                .required(true)
                .metavar("path/to/foo.ser")
                .help("path to foo resource database");
        betaArgs.addArgument("-r", "--bar-fa")
                .required(true)
                .metavar("path/to/bar.fa")
                .help("path to bar fasta");

        return parser;
    }

}
