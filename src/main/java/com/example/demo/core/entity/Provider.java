package com.example.demo.core.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Provider {
    @Id
    private Long id;
    private String name;
}