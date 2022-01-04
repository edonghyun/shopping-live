package com.example.demo.helper;

import org.modelmapper.Converter;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.convention.NameTokenizers;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ModelMapper extends org.modelmapper.ModelMapper {
    public ModelMapper() {
        getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);

        Converter<String, LocalDateTime> localDateTimeStringConverter = new Converter<String, LocalDateTime>() {
            public LocalDateTime convert(MappingContext<String, LocalDateTime> context) {
                return context.getSource() == null ? null : LocalDateTime.parse(context.getSource());
            }
        };

        addConverter(localDateTimeStringConverter);
    }
}
