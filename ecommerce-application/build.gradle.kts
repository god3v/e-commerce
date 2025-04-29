plugins {
    kotlin("jvm")
}

group = "com.ecommerce"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":ecommerce-domain"))

    implementation("org.springframework.boot:spring-boot-starter")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}