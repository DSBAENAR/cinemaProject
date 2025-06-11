package com.cinemaproject.appcore.Model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

/**
 * Converts a comma-separated string of genre names into a list of Genre enums.
 * This is used for reading from the database.
 */
@ReadingConverter
public class GenreListReadConverter implements Converter<String, List<Genre>> {
    @Override
    public List<Genre> convert(String source) {
        return Arrays.stream(source.split(","))
                .map(String::trim)
                .map(s -> Genre.valueOf(s.toUpperCase()))
                .collect(Collectors.toList());
    }
}