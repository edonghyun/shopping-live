package com.example.demo.crawler.strategy;

import java.util.List;
import java.util.ArrayList;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;

import com.example.demo.crawler.strategy.CrawlerStrategyInterface;
import com.example.demo.helper.ModelMapper;
import com.example.demo.helper.JSONParser;
import com.example.demo.crawler.client.Client;

@Slf4j
@Component
@RequiredArgsConstructor
public class NaverShoppingLiveStrategy implements CrawlerStrategyInterface {
    private final String baseUrl = "https://apis.naver.com/selectiveweb/selectiveweb/v1/lives/timeline/daily?next=%d&size=10";
    private final String initialUrl = "https://apis.naver.com/selectiveweb/live_commerce_web/v2/broadcast/milestones";

    private final Client Client;
    private final JSONParser jsonParser;

    public List<Object> parse() {
        List<Object> result = new ArrayList();
        JSONObject parsedMilestone, objectList;
        String url, responseBody;
        Long timestamp;

        HttpResponse<String> response = Client.doGet(initialUrl);
        JSONArray milestones = (JSONArray)jsonParser.parse(response.body());        
        for(Object  milestone:milestones) {        	
        	parsedMilestone = (JSONObject)milestone;
        	parsedMilestone = (JSONObject)parsedMilestone.get("milestone");
            timestamp = (Long)parsedMilestone.get("timestamp");
            do {
                url = String.format(baseUrl, timestamp);
                responseBody = Client.doGet(url).body();
            	objectList = (JSONObject)jsonParser.parse(responseBody);
                timestamp = (Long)objectList.get("timestamp");
                result.addAll((JSONArray)objectList.get("list"));
            } while(timestamp != null);
        }

        return result;
    }
}