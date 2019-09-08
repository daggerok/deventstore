package com.github.daggerok.deventstore.api.provider.data;

import java.util.Collection;

public interface DataStoreProvider {
    void append(Object domainEvent);
    Collection<Object> load(Object aggregateId);
}
