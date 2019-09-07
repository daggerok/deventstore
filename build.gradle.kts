import org.gradle.api.tasks.testing.logging.TestLogEvent.*
import org.jetbrains.kotlin.gradle.plugin.KotlinPluginWrapper
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    idea
    kotlin("jvm") version "1.3.50"
    id("org.ajoberstar.reckon") version "0.11.0"
    id("com.github.ben-manes.versions") version "0.24.0"
}

allprojects {
    apply<BasePlugin>()
    group = "com.github.daggerok"
    version = "1.0.0-SNAPSHOT"

    apply<KotlinPluginWrapper>()
    repositories {
        mavenCentral()
    }
}

subprojects {
    apply<JavaPlugin>()
    configure<JavaPluginConvention> {
        sourceCompatibility = JavaVersion.VERSION_1_8
    }
    // apply<org.jetbrains.kotlin.gradle.plugin.KotlinPlatformJvmPlugin>()
    dependencies {
        implementation(kotlin("stdlib-jdk8"))

        implementation(platform("io.projectreactor:reactor-bom:Californium-SR11")) // Californium-RELEASE
        implementation("io.projectreactor:reactor-core")
        testImplementation("io.projectreactor:reactor-test")

        implementation(platform("org.springframework:spring-framework-bom:5.1.9.RELEASE"))
        implementation("org.springframework:spring-context-support")

        testImplementation("junit:junit:4.12")
    }
    tasks {
        withType<KotlinCompile> {
            kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
        }
        withType<Test> {
            useJUnitPlatform()
            testLogging {
                showExceptions = true
                showStandardStreams = true
                events(PASSED, SKIPPED, FAILED)
            }
        }
    }
}

defaultTasks("clean", "build")

tasks {
    named("reckonTagCreate") {
        dependsOn(check)
    }
    named<com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask>("dependencyUpdates") {
        resolutionStrategy {
            componentSelection {
                all {
                    val rejected = listOf("alpha", "beta", "rc", "cr", "sr", "sp", "m", "preview", "b", "a", "ea", "SNAPSHOT")
                        .map { qualifier -> Regex("(?i).*[.-]$qualifier[.\\d-+]*") }
                        .any { it.matches(candidate.version) }
                    if (rejected) reject("Release candidate")
                }
            }
        }
        outputFormatter = "plain" // "json"
    }
}
