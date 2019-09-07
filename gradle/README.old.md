# Gradle guide

```kotlin
reckon {
    scopeFromProp()
    stageFromProp("beta", "rc", "final")
}
```

## reckon plugin visioning

_1.1) do some work_

```bash
./gradlew build
Reckoned version: 0.1.0-beta.0.1+20190907T115644Z
```

_1.2) commit work you have done_

```bash
# git add ... ; git commit -am ... 
./gradlew build
Reckoned version: 0.1.0-beta.0.2+20190907T115839Z
```

NOTE: as you can see, version: `0.1.0-beta.0.1+...` -> `0.1.0-beta.0.2+...`

_2) any time when you ready for staging_

```bash
git push ...
# same: gradle reckonTagPush -Preckon.stage=beta ... # ommit -Preckon.scope=minor
./gradlew reckonTagPush -Preckon.scope=minor -Preckon.stage=beta \
  -Dorg.ajoberstar.grgit.auth.username=daggerok \
  -Dorg.ajoberstar.grgit.auth.password=secret
Reckoned version: 0.1.0-beta.1
```

_3) release candidate or bug fix_

```bash
git push ...
./gradlew reckonTagPush -Preckon.stage=rc \
  -Dorg.ajoberstar.grgit.auth.username=daggerok \
  -Dorg.ajoberstar.grgit.auth.password=secret
Reckoned version: 0.1.0-rc.1
```

_4) final release_

```bash
git push ...
./gradlew reckonTagPush -Preckon.stage=final \
  -Dorg.ajoberstar.grgit.auth.username=daggerok \
  -Dorg.ajoberstar.grgit.auth.password=secret
Reckoned version: 0.1.0
```

_5) customer 1.0.0 delivery_

incrementing major: `major.minor.patch` -> `major+1.0.0`

```bash
git push ...
./gradlew reckonTagPush -Preckon.scope=major -Preckon.stage=final \
  -Dorg.ajoberstar.grgit.auth.username=daggerok \
  -Dorg.ajoberstar.grgit.auth.password=secret
Reckoned version: 1.0.0
```

_6) let's assume, customers found a bug_

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
Reckoned version: 1.1.0-beta.0.0+20190907T135727Z
```

* But we need 1.0.1, ie not minor, but patch scope! So we must tell reckon about that:

```shell script
./gradlew build -Preckon.scope=patch -Preckon.stage=rc
Reckoned version: 1.0.1-rc.1
```

* Now, everything looks great, so we can deliver that patch to our customers:

```shell script
./gradlew reckonTagPush -Preckon.scope=patch -Preckon.stage=rc \
  -Dorg.ajoberstar.grgit.auth.username=daggerok \
  -Dorg.ajoberstar.grgit.auth.password=secret
Reckoned version: 1.0.1-rc.1
```

* Finally, after success acceptance testing we can deliver fixed and stable (1.0.1) release:

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
