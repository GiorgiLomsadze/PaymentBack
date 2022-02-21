package com.oppa.paymentBack.config;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class FlywayConfiguration {

    @Value("${spring.flyway.baseline-version}")
    private String springFlywayBaseLineVersion;

    @Bean
    public int flyway(DataSource dataSource) {
        return Flyway.configure()
                .baselineOnMigrate(true)
                .dataSource(dataSource)
                .baselineVersion(springFlywayBaseLineVersion)
                .load()
                .migrate();
    }
}
