package com.example.demo.core.repository;

import java.util.List;
import java.math.BigInteger;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;


import com.example.demo.core.entity.Broadcast;

@Repository
public interface BroadcastRepository extends MongoRepository<Broadcast, BigInteger>{
  List<Broadcast> findAll();
}
