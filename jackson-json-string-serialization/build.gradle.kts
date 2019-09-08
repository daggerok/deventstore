plugins {
    `java-library`
}

dependencies {
    api(project(":api"))
    implementation("io.vavr:vavr")
    implementation("com.fasterxml.jackson.core:jackson-databind")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")
}
