package com.example.demo

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.s3.S3Client
import software.amazon.awssdk.services.sqs.SqsAsyncClient

@Component
class TestClient : CommandLineRunner {

    lateinit var s3Client: S3Client
    lateinit var sqsClient: SqsAsyncClient

    override fun run(vararg args: String?) {
        s3Client = S3Client.builder()
            .region(Region.US_EAST_1)
            .build()

        sqsClient = SqsAsyncClient.builder().build()
        sqsClient.listQueues()

        println("AWS Clients initialized successfully!")
    }
}