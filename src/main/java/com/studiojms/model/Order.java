package com.studiojms.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SEQ_ID")
    private Long id;

    private Double price;

    private String type;

    private LocalDate date;

    private String status;

    @Column(name = "user_id")
    private Long userId;
}
