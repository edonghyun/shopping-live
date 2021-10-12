package com.example.demo.core.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.data.util.Streamable;
import lombok.RequiredArgsConstructor;

import com.example.demo.core.entity.Broadcast;
import com.example.demo.core.dto.BroadcastDto;
import com.example.demo.core.dto.BroadcastCreateDto;
import com.example.demo.core.repository.BroadcastRepository;

@Service
@RequiredArgsConstructor
public class BroadcastService {
    private final BroadcastRepository broadcastRepository;

    public List<BroadcastDto> getBroadcasts() {
        return Streamable.of(broadcastRepository.findAll())
            .stream().map(BroadcastDto::fromEntity)
            .collect(Collectors.toList());
    }

    public BroadcastDto createBroadcast(BroadcastCreateDto broadcastCreateDto) {
        return null;
    }
}
