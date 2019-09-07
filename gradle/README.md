# Gradle guide

```kotlin
reckon {
    scopeFromProp()
    //stageFromProp()
    snapshotFromProp()
}
```

## reckon plugin visioning

_1) do some work, commit when you have done_

```bash
# git add ... ; git commit -am ... 
./gradlew build
Reckoned version: 0.0.1-SNAPSHOT
```

_2) then deliver in any time when you ready for staging_

```bash
git push ...
./gradlew reckonTagPush -Preckon.stage=final \
  -Dorg.ajoberstar.grgit.auth.username=daggerok \
  -Dorg.ajoberstar.grgit.auth.password=secret
Reckoned version: 0.0.1
```

_3) 0.0.1 -> 1.0.0_

```bash
git push ...
./gradlew reckonTagPush -Preckon.scope=major -Preckon.stage=final \
  -Dorg.ajoberstar.grgit.auth.username=daggerok \
  -Dorg.ajoberstar.grgit.auth.password=secret
Reckoned version: 1.0.0
```

_4) let's assume: customers found a bug_

So we must fix it ASAP. ...and we did.
Now we wanna quickly provide patched release candidate...

* Let's commit and push our changes:

```shell script
git commit -m "Important hotfix patch release."
git push ...
```

* Now let's check which next version is going to be produced by reckon plugin:

```shell script
./gradlew build
Reckoned version: 1.1.0-SNAPSHOT
```

* But we need 1.0.1-SNAPSHOT, ie not minor, but patch scope! So we must tell reckon about that:

```shell script
./gradlew build -Preckon.scope=patch
Reckoned version: 1.0.1-SNAPSHOT
```

* Now, everything looks great, so we can deliver that patch to our customers:

```shell script
./gradlew reckonTagPush -Preckon.scope=patch -Preckon.stage=final \
  -Dorg.ajoberstar.grgit.auth.username=daggerok \
  -Dorg.ajoberstar.grgit.auth.password=secret
Reckoned version: 1.0.1
```

## check dependencies updates

```shell script
./gradlew dependencyUpdates -Drevision=release
```
