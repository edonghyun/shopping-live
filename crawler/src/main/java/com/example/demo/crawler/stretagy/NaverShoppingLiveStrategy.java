package com.example.demo.crawler.strategy;

import java.util.List;
import java.util.ArrayList;

import java.net.http.HttpResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import lombok.Getter;

import com.example.demo.helper.JSONParser;
import com.example.demo.crawler.client.Client;
import com.example.demo.core.dto.BroadcastCreateDto;
import com.example.demo.helper.ModelMapper;
import com.example.demo.crawler.dto.NaverShoppingBroadcastDto;

@Slf4j
@Component
@Getter
@RequiredArgsConstructor
public class NaverShoppingLiveStrategy implements CrawlerStrategyInterface {
    private final String baseUrl = "https://apis.naver.com/selectiveweb/selectiveweb/v1/lives/timeline/daily?next=%d&size=10";
    private final String initialUrl = "https://apis.naver.com/selectiveweb/live_commerce_web/v2/broadcast/milestones";
    private final String provider = "NAVER";

    private final Client Client;
    private final JSONParser jsonParser;
    private final ModelMapper modelMapper;

    private BroadcastCreateDto convertObjectDataToBroadcastCreateDto(
        Object object
    ) {
        NaverShoppingBroadcastDto dto = modelMapper.map(
            object,
            NaverShoppingBroadcastDto.class
        );
        return BroadcastCreateDto.builder()
                .remoteId(String.valueOf(dto.getBroadcastId()))
                .provider(getProvider())
                .extraData(dto)
                .build();
    }

    public List<BroadcastCreateDto> parse() {
        List<BroadcastCreateDto> result = new ArrayList();
        JSONObject parsedMilestone, objectList;
        String url, responseBody;
        Long timestamp;

        HttpResponse<String> response = Client.doGet(getInitialUrl());
        JSONArray milestones = (JSONArray)jsonParser.parse(response.body());        
        for(Object  milestone:milestones) {        	
        	parsedMilestone = (JSONObject)milestone;
        	parsedMilestone = (JSONObject)parsedMilestone.get("milestone");
            timestamp = (Long)parsedMilestone.get("timestamp");
            do {
                url = String.format(getBaseUrl(), timestamp);
                responseBody = Client.doGet(url).body();
            	objectList = (JSONObject)jsonParser.parse(responseBody);
                timestamp = (Long)objectList.get("timestamp");
                for(Object object : (List)objectList.get("list")) {
                    result.add(
                        convertObjectDataToBroadcastCreateDto(object)
                    );
                }
            } while(timestamp != null);
        }
        return result;
    }
}