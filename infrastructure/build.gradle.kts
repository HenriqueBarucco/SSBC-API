plugins {
    id("application")
    kotlin("jvm")
    kotlin("plugin.spring") version "2.2.20-RC2"
    id("org.springframework.boot") version "4.0.0-M1"
    id("io.spring.dependency-management") version "1.1.7"
    kotlin("plugin.serialization") version "2.2.20-RC2"
}

group = "com.henriquebarucco"
version = "0.0.1"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
    maven {
        url = uri("https://repo.spring.io/snapshot")
    }
}

extra["springCloudVersion"] = "2025.1.0-M1"

dependencies {
    implementation(project(":application"))
    implementation(project(":domain"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.8.0")
    implementation("com.fasterxml.jackson.module:jackson-module-blackbird")
    implementation("net.logstash.logback:logstash-logback-encoder:8.1")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:3.0.0-M1")
    implementation("org.springframework.boot:spring-boot-starter-validation")

    developmentOnly("org.springframework.boot:spring-boot-devtools")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}

kotlin {
    jvmToolchain(21)
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.bootJar {
    archiveFileName.set("application.jar")
    destinationDirectory.set(file("$rootDir/build"))
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.processResources {
    filesMatching("**/application.yml") {
        expand(project.properties)
    }
}
