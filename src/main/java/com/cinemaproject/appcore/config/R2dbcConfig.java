package com.cinemaproject.appcore.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.convert.R2dbcCustomConversions;

import com.cinemaproject.appcore.Model.GenreListReadConverter;
import com.cinemaproject.appcore.Model.GenreListWriteConverter;


import io.r2dbc.spi.ConnectionFactory;

/**
 * Configuration class for R2DBC, setting up the connection factory and custom converters.
 * This class is responsible for configuring the R2DBC connection and defining custom conversions
 * for handling lists of genres in the database.
 */
@Configuration
public class R2dbcConfig extends AbstractR2dbcConfiguration {

    @Autowired
    private ConnectionFactory connectionFactory;

    @Override
    public ConnectionFactory connectionFactory() {
        return connectionFactory;
    }

    @Bean
    public R2dbcCustomConversions r2dbcCustomConversions() {
        return new R2dbcCustomConversions(
            R2dbcCustomConversions.StoreConversions.NONE,
            List.of(new GenreListReadConverter(), new GenreListWriteConverter())
        );
    }
}

