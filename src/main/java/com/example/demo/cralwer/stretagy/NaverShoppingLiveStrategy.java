package com.example.demo.crawler.strategy;

import java.util.List;
import java.util.ArrayList;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

import com.example.demo.crawler.strategy.CrawlerStrategyInterface;


@Slf4j
@Component
public class NaverShoppingLiveStrategy implements CrawlerStrategyInterface {
    public void run() {
        try {
            sendGet();
        } catch (Exception exc) {
            log.error("Error Occured {}", exc.getMessage());
        }
    }

    private List<Object> sendGet() throws Exception {
        List<Object> result = new ArrayList();
        
        HttpResponse<String> response = doGet("https://apis.naver.com/selectiveweb/live_commerce_web/v2/broadcast/milestones");
        
        JSONParser parser = new JSONParser();
        JSONArray milestones = (JSONArray) parser.parse(response.body());        
        
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
                result.addAll(list);
            	
            	timestamp = (Long)objectList.get("next");
                if(timestamp == null) {
            		break;
            	}
        	}
        }

        return result;
    }
}