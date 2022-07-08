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
val cucumberRuntime by configurations.creating {
    extendsFrom(configurations["testImplementation"])
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

    testImplementation("io.cucumber:cucumber-java:7.3.3")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.named("build") {
    dependsOn("cucumber")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}


task("cucumber") {
    dependsOn("test")
    mustRunAfter("test")
    doLast {
        javaexec {
            mainClass.set("io.cucumber.core.cli.Main")
            classpath = cucumberRuntime + sourceSets.main.get().output + sourceSets.test.get().output
            args = listOf("--plugin", "pretty", "--glue", "io.tripled.features", "src/test/resources")
        }
    }
}


