package com.example.demo.core.entity;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigInteger;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;


@Entity
@Getter
@Setter
@Builder
public class Broadcast {
    @Id
    private BigInteger id;
    
    @Column(unique=true)
    private String remoteId;

    private String provider;
    private Object extraData;
}