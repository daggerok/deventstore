# DEventStore [![Build Status](https://travis-ci.org/daggerok/deventstore.svg?branch=master)](https://travis-ci.org/daggerok/deventstore)
development ready event store

<!--

# java-persistence
Aka akka-persistence (:

```java
class PersistentCounter<C extends Command, E extends Event> {
    public void handle(C cmd) {
        Mono<E> evt = handle(cmd);
        persist(evt, this::onEvent);
    }

    public E handle(C cmd) {
        failAlwaysAsNotSupportedCommand();
        return Mono.error("unknown command");
    }

    public Mono<E> handle(MyFirstCommand cmd) {
        validateTo(cmd);
        return new MyFirstEvent(cmd.getId(), cmd.getValue());
    }

    public CompletableFuture<Void> onEvent(MyFirstEvent evt) {
        
    }
}
```

-->

<!-- main contend -->

Checkout [gradle] tasks usage guides

_resources_

* [Easy releases with reckon gradle plugin]
* [Grgit related GitHub issue (question)]
* [Grgit auth]
* [Travis CI deployment example]
* [Travis CI script deployment]
* [Travis CI deployment]

<!-- refs -->

[gradle]: gradle
[Easy releases with reckon gradle plugin]: https://github.com/ajoberstar/reckon/blob/master/docs/index.md
[Grgit related GitHub issue (question)]: https://github.com/ajoberstar/reckon/issues/123
[Grgit auth]: http://ajoberstar.org/grgit/grgit-authentication.html
[Travis CI deployment example]: https://github.com/daggerok/streaming-file-server/blob/master/.travis.yml#L240
[Travis CI script deployment]: https://docs.travis-ci.com/user/deployment/script/
[Travis CI deployment]: https://docs.travis-ci.com/user/deployment
