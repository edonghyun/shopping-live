package com.example.demo.core.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

import com.example.demo.core.entity.Broadcast;
import com.example.demo.core.entity.Provider;

@Getter
@Setter
@Builder
public class BroadcastCreateDto {
    private String remoteId;
    private Provider provider;
    private Object extraData;
} 