package com.example.demo.crawler.strategy;

import java.util.List;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public interface CrawlerStrategyInterface {
    void run();
    default HttpResponse<String> doGet(String url) throws Exception {
        HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
    	HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(url))
                .setHeader("User-Agent", "Java 11 HttpClient Bot").build();
        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }
}