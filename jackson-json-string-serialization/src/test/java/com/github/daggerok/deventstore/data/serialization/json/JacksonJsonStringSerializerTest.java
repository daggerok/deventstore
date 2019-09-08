package com.github.daggerok.deventstore.data.serialization.json;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static java.util.Collections.singletonMap;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class JacksonJsonStringSerializerTest {

    private JacksonJsonStringSerializer serializer = new JacksonJsonStringSerializer();

    @Test
    void should_serialize() {
        // given:
        Map<String, String> map = singletonMap("message", "Hello, World!");
        // when:
        String jsonString = serializer.serialize(map);
        // then:
        assertThat(jsonString).contains("message")
                              // and:
                              .contains("Hello, World!")
                              // and:
                              .isEqualTo("{\"message\":\"Hello, World!\"}");
    }

    @Test
    void should_deserialize() {
        // given:
        String jsonString = "{\"message\":\"Hello, World!\"}";
        // when:
        Map map = serializer.deserialize(jsonString, Map.class);
        // and
        @SuppressWarnings("unchecked")
        Map<String, String> stringStringMap = (Map<String, String>) map;
        // then:
        assertThat(stringStringMap).hasSize(1)
                                   // and:
                                   .containsKeys("message")
                                   // and:
                                   .containsValues("Hello, World!");
    }
}
