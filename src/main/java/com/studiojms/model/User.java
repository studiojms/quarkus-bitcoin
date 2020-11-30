package com.studiojms.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "USERS")
public class User extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SEQ_ID")
    private Long id;

    private String name;

    @Column(name = "document_number")
    private String documentNumber;

    private String username;

    private String password;
}
