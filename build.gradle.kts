plugins {
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25"
	id("org.springframework.boot") version "3.4.4"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    implementation("software.amazon.awssdk:s3:2.31.22")
    implementation("software.amazon.awssdk:sqs:2.31.22")

    implementation(platform("io.opentelemetry:opentelemetry-bom:1.49.0"))
    implementation("io.opentelemetry:opentelemetry-api:1.49.0")
    implementation("io.opentelemetry.instrumentation:opentelemetry-instrumentation-annotations:2.15.0")
//    implementation("io.opentelemetry.instrumentation:opentelemetry-aws-sdk-2.2-autoconfigure:2.15.0-alpha")
//    implementation("io.opentelemetry.instrumentation:opentelemetry-aws-sdk-2.2:2.15.0-alpha")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
