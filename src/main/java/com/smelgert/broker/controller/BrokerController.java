package com.smelgert.broker.controller;

import com.smelgert.broker.model.Customer;
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
        String url = "http://localhost:8080/test";
        return webClientBuilder.build()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class);
    }

    @GetMapping("/callServiceA")
    public Mono<String> addCustomer(Customer customer) { // Customer moet nog carlease.Customer worden
        String url = "http://localhost:8080/addCustomer";
        return webClientBuilder.build()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class);
    }
}
