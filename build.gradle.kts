import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

// https://doughman.tistory.com/19
plugins {
    id("org.springframework.boot") apply false
    id("io.spring.dependency-management")

    kotlin("jvm")
    kotlin("kapt")
    kotlin("plugin.spring") apply false

    kotlin("plugin.allopen") apply false
    kotlin("plugin.noarg") apply false
}

repositories {
    mavenCentral()
    jcenter()
}

subprojects {
    repositories {
        mavenCentral()
        jcenter()
    }

    group = "com.another"
    version = "1.0-SNAPSHOT"

    apply(plugin = "idea")
    apply(plugin = "kotlin")
    apply(plugin = "kotlin-spring")
    apply(plugin = "kotlin-kapt")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")

    tasks {
        withType<Test> {
            useJUnitPlatform()
            systemProperty("spring.profiles.active", "test")
        }

        withType<KotlinCompile> {
            kotlinOptions {
                freeCompilerArgs = listOf("-Xjsr305=strict")
                jvmTarget = "1.8"
            }
            dependsOn(processResources)
        }
    }

    the<io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension>().apply {
        imports {
            mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
        }
    }

    dependencies {
        implementation(kotlin("stdlib-jdk8"))
        implementation(kotlin("reflect"))
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
//        kapt("org.springframework.boot:spring-boot-configuration-processor")

        testImplementation("org.springframework.boot:spring-boot-starter-test") {
            exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
//            exclude(module = "hamcrest-core")
//            exclude(module = "hamcrest-library")
        }
        testImplementation("org.junit.jupiter:junit-jupiter-api")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    }
}

