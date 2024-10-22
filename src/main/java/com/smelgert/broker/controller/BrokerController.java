package com.smelgert.broker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class BrokerController {

    private final WebClient.Builder webClientBuilder;

    @Autowired
    public BrokerController(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    // Calling Service A from Service B using WebClient
    @GetMapping("/callServiceA")
    public Mono<String> callServiceA() {
        String url = "http://localhost:8080/test"; // URL of Service A's /test endpoint
        return webClientBuilder.build()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class);  // Perform GET request and return the response as Mono
    }
}
