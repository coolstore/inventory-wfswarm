package com.redhat.coolstore.util;

import org.flywaydb.core.Flyway;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * Created by tqvarnst on 2017-04-04.
 */
@Singleton
@Startup
public class DataBaseMigrationStartup {

    @PostConstruct
    private void startup() {
        System.out.println("-------- STARTING DATABASE MIGRATION");

        // Create the Flyway instance
        Flyway flyway = new Flyway();

        String dbConnUrl = System.getProperty("swarm.datasources.data-sources.InventoryDS.connection-url");
        String dbUser = "swarm";
        String dbPassword = "password";

        // Point it to the database
        flyway.setDataSource(dbConnUrl, dbUser, dbPassword);

        // Start the migration
        flyway.migrate();

        System.out.println("--------- DATABASE MIGRATION DONE");
    }



}
