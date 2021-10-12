package com.example.demo.core.repository;

import com.example.demo.core.entity.Broadcast;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface BroadcastRepository extends MongoRepository<Broadcast, Long> {
  List<Broadcast> findAll();
}
