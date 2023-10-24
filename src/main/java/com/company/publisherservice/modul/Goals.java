package com.company.publisherservice.modul;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "goals")
public class Goals {
    @Id
    @Column(name = "langue_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer langueId;

    private String language;
    private String name;


}
