package com.example.demo.core.service;

import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.MongoOperations;

import lombok.RequiredArgsConstructor;

import com.example.demo.core.entity.Broadcast;
import com.example.demo.core.dto.BroadcastDto;
import com.example.demo.core.dto.BroadcastCreateDto;
import com.example.demo.core.repository.BroadcastRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class BroadcastService {
    private final BroadcastRepository broadcastRepository;
    private final MongoOperations mongoOperation;

    public Page<BroadcastDto> getBroadcasts(Pageable pageable) {
        Page<Broadcast> broadcastPage = broadcastRepository.findAll(pageable);
        return new PageImpl<BroadcastDto>(
                broadcastPage.getContent().stream().map(
                        BroadcastDto::fromEntity
                ).collect(Collectors.toList()),
                pageable,
                broadcastPage.getTotalElements()
        );
    }

    public BroadcastDto createBroadcast(BroadcastCreateDto broadcastCreateDto) {
        String remoteId = broadcastCreateDto.getRemoteId();

        Query query = new Query();
		query.addCriteria(Criteria.where("remoteId").is(remoteId));

		Update update = new Update();
		update.set("remoteId", remoteId);
		update.set("provider", broadcastCreateDto.getProvider());
		update.set("extraData", broadcastCreateDto.getExtraData());

        mongoOperation.upsert(
            query, 
            update, 
            Broadcast.class
        );

        Broadcast broadcast = mongoOperation.findOne(query, Broadcast.class);
        return BroadcastDto.fromEntity(broadcast);
    }
}

