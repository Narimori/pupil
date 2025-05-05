pluginManagement {
    repositories {
        mavenCentral()
        maven("https://maven.fabricmc.net/")
    }

    val kotlinVersion: String by settings
    val fabricLoomVersion: String by settings

    plugins {
        kotlin("jvm") version kotlinVersion
        id("fabric-loom") version fabricLoomVersion
    }
}