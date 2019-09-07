# Gradle guide

## reckon plugin visioning

_1) do some work_

```bash
./gradlew build
Reckoned version: 0.1.0-beta.0.1+20190907T115644Z
```

_2) commit work you have done_

```bash
# git add ... ; git commit -am ... 
./gradlew build
Reckoned version: 0.1.0-beta.0.2+20190907T115839Z
```

NOTE: as you can see, version: `0.1.0-beta.0.1+...` -> `0.1.0-beta.0.2+...`

_3) when you ready for staging_

```bash
git push ...
./gradlew build reckonTagPush -Preckon.scope=minor -Preckon.stage=beta \
  -Dorg.ajoberstar.grgit.auth.username=daggerok \
  -Dorg.ajoberstar.grgit.auth.password=secret
# same:   build reckonTagPush -Preckon.stage=beta
Reckoned version: 0.1.0-beta.1
```

## check dependencies updates

```shell script
./gradlew dependencyUpdates -Drevision=release
```
