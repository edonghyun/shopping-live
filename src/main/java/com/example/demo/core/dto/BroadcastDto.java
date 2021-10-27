package com.example.demo.core.dto;

import java.math.BigInteger;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

import com.example.demo.core.entity.Broadcast;

@Getter
@Setter
@Builder
public class BroadcastDto {
    private BigInteger id;
    private String remoteId;
    private String provider;
    private Object extraData;

    public static BroadcastDto fromEntity(Broadcast broadcast) {
        return BroadcastDto.builder()
            .id(broadcast.getId())
            .remoteId(broadcast.getRemoteId())
            .provider(broadcast.getProvider())
            .extraData(broadcast.getExtraData())
            .build();
    }
} 