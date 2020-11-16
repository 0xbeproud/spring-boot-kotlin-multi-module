import org.springframework.boot.gradle.tasks.bundling.BootJar

tasks {
    withType<BootJar> {
        enabled = false
    }

    withType<Jar> {
        enabled = true
    }
}

dependencies {
    implementation(project(":demo-core"))
    implementation(project(":demo-domain"))
}


