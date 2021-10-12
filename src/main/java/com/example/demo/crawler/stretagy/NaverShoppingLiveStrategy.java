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
    private final Client Client;
    private final JSONParser jsonParser;

    public List<Object> run() {
        return sendGet();
    }

    private List<Object> sendGet() {
        List<Object> result = new ArrayList();
        
        HttpResponse<String> response = Client.doGet("https://apis.naver.com/selectiveweb/live_commerce_web/v2/broadcast/milestones");
        
        JSONArray milestones = (JSONArray)jsonParser.parse(response.body());        
        
        String baseUrl = "https://apis.naver.com/selectiveweb/selectiveweb/v1/lives/timeline/daily?next=%d&size=10";
        for(Object  milestone:milestones) {        	
        	JSONObject parsedMilestone = (JSONObject)milestone;
        	parsedMilestone = (JSONObject) parsedMilestone.get("milestone");

        	Long timestamp = (Long) parsedMilestone.get("timestamp");
        	response = Client.doGet(String.format(baseUrl, timestamp));

        	JSONObject objectList;
        	JSONArray list;
        	while(true) {
            	response = Client.doGet(String.format(baseUrl, timestamp));
            	objectList = (JSONObject)jsonParser.parse(response.body());
            	list = (JSONArray)objectList.get("list");
                result.addAll(list);
                log.info("{}", list);
                
            	timestamp = (Long)objectList.get("next");
                if(timestamp == null) {
            		break;
            	}
        	}
        }

        return result;
    }
}