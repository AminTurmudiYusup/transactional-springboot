package com.example.transactional.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String jobName;
}
