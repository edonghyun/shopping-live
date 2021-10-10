package com.example.demo.crawler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@NoArgsConstructor
@Component
@Slf4j
public class Crawler {
    public void run() {
        try {
            sendGet();
        } catch (Exception exc) {
            log.error("Error Occured {}", exc.getMessage());
        }

    }

    private HttpResponse<String> doGet(String url) throws Exception {
        HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
    	HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(url))
                .setHeader("User-Agent", "Java 11 HttpClient Bot").build();
        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }
        
    private void sendGet() throws Exception {
        File file = new File("result.txt");
        FileOutputStream o = new FileOutputStream(file);
        PrintStream ps = new PrintStream(o);
        HttpResponse<String> response = doGet("https://apis.naver.com/selectiveweb/live_commerce_web/v2/broadcast/milestones");
        
        JSONParser parser = new JSONParser();
        JSONArray milestones = (JSONArray) parser.parse(response.body());        
        
        int total = 0;
        String baseUrl = "https://apis.naver.com/selectiveweb/selectiveweb/v1/lives/timeline/daily?next=%d&size=10";
        for(Object  milestone:milestones) {        	
        	JSONObject parsedMilestone = (JSONObject)milestone;
        	parsedMilestone = (JSONObject) parsedMilestone.get("milestone");

        	Long timestamp = (Long) parsedMilestone.get("timestamp");
        	response = doGet(String.format(baseUrl, timestamp));

        	JSONObject objectList;
        	JSONArray list;
        	while(true) {
            	response = doGet(String.format(baseUrl, timestamp));
            	objectList = (JSONObject)parser.parse(response.body());
            	
            	list = (JSONArray)objectList.get("list");
                total += list.size();
            	// for(Object broadcast:list) {
                //     log.info("{}", broadcast);
            	// }
            	
            	timestamp = (Long)objectList.get("next");
                if(timestamp == null) {
            		break;
            	}

        	}
        }
        
        log.info("total {} crawled !", total);
        
    }
}
