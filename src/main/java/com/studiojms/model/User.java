package com.studiojms.model;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;
import lombok.Getter;
import lombok.Setter;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

@Getter
@Setter
@UserDefinition
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

    @Username
    private String username;

    @Password
    private String password;

    @Roles
    private String role;

    @JsonbTransient
    public String getPassword() {
        return password;
    }

    public static void add(User user) {
        user.setPassword(BcryptUtil.bcryptHash(user.getPassword()));

        String role = "USER";

        if (user.getUsername().startsWith("ADMIN_".toLowerCase())) {
            role = "ADMIN";
        }

        user.setRole(role);

        User.persist(user);
    }
}
