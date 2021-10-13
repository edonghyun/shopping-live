package com.example.demo.core.dto;

import java.math.BigInteger;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

import com.example.demo.core.entity.Broadcast;
import com.example.demo.core.entity.Provider;

@Getter
@Setter
@Builder
public class BroadcastDto {
    private BigInteger id;
    private Provider provider;

    public static BroadcastDto fromEntity(Broadcast broadcast) {
        return BroadcastDto.builder()
            .id(broadcast.getId())
            .provider(broadcast.getProvider())
            .build();
    }
} 