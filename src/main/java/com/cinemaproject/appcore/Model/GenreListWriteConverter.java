package com.cinemaproject.appcore.Model;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

/**
 * Converts a list of Genre enums into a comma-separated string.
 * This is used for writing to the database.
 */
@WritingConverter
public class GenreListWriteConverter implements Converter<List<Genre>, String> {
    @Override
    public String convert(List<Genre> source) {
        return source.stream().map(Enum::name).collect(Collectors.joining(","));
    }
}
