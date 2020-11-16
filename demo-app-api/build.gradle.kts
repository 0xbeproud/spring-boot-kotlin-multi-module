import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("org.springframework.boot")
}

tasks {
    withType<BootJar> {
        archiveClassifier.set("boot")
    }

    withType<Jar> {
        enabled = true
    }
}

dependencies {
    implementation(project(":demo-core"))
    implementation(project(":demo-domain"))
    implementation(project(":demo-system"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    runtimeOnly("com.h2database:h2")
}

