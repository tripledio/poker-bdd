import org.jetbrains.kotlin.gradle.tasks.*

plugins {
    kotlin("jvm") version "1.7.0"
}

group = "io.tripled"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher:1.8.2")

    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")

    testImplementation("io.kotest:kotest-framework-datatest-jvm:5.3.1")
    testImplementation("io.kotest:kotest-framework-api-jvm:5.3.1")
    testImplementation("io.kotest:kotest-runner-junit5-jvm:5.3.1")
    testImplementation("io.kotest:kotest-assertions-core:5.3.1")
    testImplementation("io.kotest:kotest-property:5.3.1")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}


