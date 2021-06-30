package com.zomeli.villanueva.desafiobcp.model.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "CurrencyRate")
public class CurrencyRate implements Serializable {

    @Id
    private String id;

    private String originCurrency;
    private String destinationCurrency;
    private double rate;

}
