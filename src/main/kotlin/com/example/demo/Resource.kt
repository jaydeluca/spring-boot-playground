package com.example.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class Resource {

    @GetMapping("/names")
    fun names(): List<String> {
        return listOf("John", "Jane", "Jack")
    }
}