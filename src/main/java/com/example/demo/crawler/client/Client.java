package com.example.demo.crawler.client;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Client {
    public HttpResponse<String> doGet(String url) {
        try {
            HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
            HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(url))
                    .setHeader("User-Agent", "Java 11 HttpClient Bot").build();
            return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception exc) {
            log.error("{}", exc);
        }
        return null;
    }
}