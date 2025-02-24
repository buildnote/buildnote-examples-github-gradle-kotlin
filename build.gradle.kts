import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

plugins {
    kotlin("jvm") version "2.0.20"
    `java-library`
    `java-test-fixtures`
    `jvm-test-suite`
    id("io.buildnote.buildnote-gradle-plugin") version "0.0.3"
}

buildscript {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

allprojects {
    repositories {
        mavenCentral()
    }

    apply(plugin = "kotlin")
    apply(plugin = "java-test-fixtures")
    apply(plugin = "jvm-test-suite")

    kotlin {
        jvmToolchain {
            languageVersion.set(JavaLanguageVersion.of(21))
        }
    }

    tasks {
        withType<KotlinJvmCompile> {
            compilerOptions {
                jvmTarget = JvmTarget.JVM_21
                allWarningsAsErrors = true
            }
        }

        named<Test>("test").configure {
            useJUnitPlatform {
            }
        }
    }

    dependencies {
        testImplementation(platform("org.junit:junit-bom:5.12.0"))
        testImplementation("org.junit.jupiter:junit-jupiter-api")
        testImplementation("org.junit.jupiter:junit-jupiter-engine")
        testImplementation("org.junit.jupiter:junit-jupiter-params")
        testImplementation("io.strikt:strikt-core:0.35.1")
    }
}
