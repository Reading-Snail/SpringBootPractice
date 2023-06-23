plugins {
    java
    id("org.springframework.boot") version "3.1.1"
    id("io.spring.dependency-management") version "1.1.0"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.0.4")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf:3.0.4")
    implementation("org.springframework.boot:spring-boot-starter-validation:3.0.4")
    implementation("org.springframework.boot:spring-boot-starter-web:3.1.0")
    compileOnly("org.projectlombok:lombok:1.18.26")
    annotationProcessor("org.projectlombok:lombok:1.18.26")
    testImplementation("org.springframework.boot:spring-boot-starter-test:3.1.0")
    implementation("org.mariadb.jdbc:mariadb-java-client:3.1.2")
    implementation("org.mybatis:mybatis:3.5.13")
    implementation("org.mybatis:mybatis-spring:3.0.2")
    implementation("org.springframework:spring-jdbc:6.0.10")
    implementation("org.apache.logging.log4j:log4j-core:2.20.0")

}

tasks.withType<Test> {
    useJUnitPlatform()
}
