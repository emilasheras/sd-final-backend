package com.uda.sdfinalbackend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/*
 * @Data generates getters, setters, equals, hashCode, toString
 * @NoArgsConstructor generates empty constructor (required by JPA)
 * @AllArgsConstructor generates constructor with all fields (used in seed data)
 */
@Entity
@Table(name = "items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
}