plugins {
    kotlin("jvm")
    id("fabric-loom")
    id("maven-publish")
}

repositories {
    maven("https://maven.nucleoid.xyz/")
}

val minecraftVersion: String by project
val yarnVersion: String by project
val fabricLoaderVersion: String by project
val polymerVersion: String by project

dependencies {
    minecraft("com.mojang:minecraft:$minecraftVersion")
    mappings("net.fabricmc:yarn:$yarnVersion:v2")
    modImplementation("net.fabricmc:fabric-loader:$fabricLoaderVersion")
    modImplementation("eu.pb4:polymer-virtual-entity:$polymerVersion")
}

tasks.processResources {
    filesMatching("fabric.mod.json") {
        expand(project.properties)
    }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

kotlin {
    explicitApi()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}