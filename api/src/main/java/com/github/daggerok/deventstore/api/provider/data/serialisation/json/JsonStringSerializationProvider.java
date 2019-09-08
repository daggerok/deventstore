package com.github.daggerok.deventstore.api.provider.data.serialisation.json;

import com.github.daggerok.deventstore.api.provider.data.serialisation.SerializationProvider;

public interface JsonStringSerializationProvider extends SerializationProvider {
    <T> String serialize(T domainEvent);
    <T> T deserialize(String jsonString, Class<T> type);
}
