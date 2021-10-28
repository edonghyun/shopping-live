package com.example.demo.core.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;


@Entity
@Getter
@Setter
@Builder
@Document(collection="broadcasts")
public class Broadcast {
    @Id
    private BigInteger id;
    
    @Indexed(unique=true)
    private String remoteId;

    private String provider;
    private Object extraData;
}