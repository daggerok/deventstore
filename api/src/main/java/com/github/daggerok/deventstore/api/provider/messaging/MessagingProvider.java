package com.github.daggerok.deventstore.api.provider.messaging;

import java.util.function.Consumer;

public interface MessagingProvider {
    void publish(Object event);
    Subscription subscribePublished(Consumer<Object> subscriber);
}
