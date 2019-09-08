package com.github.daggerok.deventstore.data.serialization.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.daggerok.deventstore.api.provider.data.serialisation.json.JsonStringSerializationProvider;
import com.github.daggerok.deventstore.data.serialization.json.config.JacksonConfig;
import io.vavr.control.Try;

import java.util.Objects;

/* DomainEvent <-> JSON String */
public class JacksonJsonStringSerializer implements JsonStringSerializationProvider {

    private final ObjectMapper objectMapper;

    public JacksonJsonStringSerializer() {
        this(JacksonConfig.objectMapper.get());
    }

    public JacksonJsonStringSerializer(ObjectMapper objectMapper) {
        this.objectMapper = Objects.requireNonNull(objectMapper);
    }

    @Override
    public <T> String serialize(T domainEvent) {
        return Try.of(() -> objectMapper.writeValueAsString(domainEvent))
                  // .onFailure(throwable -> System.err.printf("cannot serialize: %s%n", throwable.getLocalizedMessage()))
                  .getOrElseThrow(this::reThrow);
    }

    @Override
    public <T> T deserialize(String jsonString, Class<T> type) {
        return Try.of(() -> objectMapper.readValue(jsonString, type))
                  .getOrElseThrow(this::reThrow);
    }

    private RuntimeException reThrow(Throwable throwable) {
        // TODO: FIXME: Add logging...
        System.err.printf("serialization problem: %s%n", throwable.getLocalizedMessage());
        return new RuntimeException(throwable);
    }
}
