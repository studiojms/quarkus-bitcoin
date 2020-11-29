package com.studiojms.model;

import lombok.Getter;
import lombok.Setter;

import javax.json.bind.annotation.JsonbProperty;
import java.time.LocalDate;

@Getter
@Setter
public class Bitcoin {
    @JsonbProperty("id")
    private Long id;

    @JsonbProperty("preco")
    private Double price;

    @JsonbProperty("tipo")
    private String type;

    @JsonbProperty("data")
    private LocalDate date;
}
