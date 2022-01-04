package com.example.demo.api;

import java.util.List;

import com.example.demo.core.service.BroadcastService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

import com.example.demo.core.dto.BroadcastDto;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final BroadcastService broadcastService;

    @GetMapping("/api/broadcasts")
    public List<BroadcastDto> getBroadcasts() {
        return broadcastService.getBroadcasts();
    }
}
