package com.example.demo.core.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

import com.example.demo.core.entity.Broadcast;

@Getter
@Setter
@Builder
public class BroadcastCreateDto {
    private String remoteId;
    private String provider;
    private Object extraData;
} 