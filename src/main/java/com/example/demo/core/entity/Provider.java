package com.example.demo.core.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Provider {
    @Id
    private BigInteger id;
    private String name;
}