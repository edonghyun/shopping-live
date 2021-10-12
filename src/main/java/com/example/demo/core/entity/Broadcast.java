package com.example.demo.core.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

import com.example.demo.core.entity.Provider;


@Entity
@Getter
@Setter
public class Broadcast {
    @Id
    private Long id;

    @ManyToOne(targetEntity=Provider.class, fetch=FetchType.LAZY)
    private Provider provider;
}