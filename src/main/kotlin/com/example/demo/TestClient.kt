package com.example.demo

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.s3.S3Client

@Component
class TestClient : CommandLineRunner {

    lateinit var s3Client: S3Client

    override fun run(vararg args: String?) {
        s3Client = S3Client.builder()
            .region(Region.US_EAST_1)
            .build()

        println("AWS S3 Client initialized successfully!")
    }
}