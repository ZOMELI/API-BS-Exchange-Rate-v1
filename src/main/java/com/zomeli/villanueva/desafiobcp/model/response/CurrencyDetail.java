package com.zomeli.villanueva.desafiobcp.model.response;

import lombok.*;

@Getter
@Setter
@Builder
public class CurrencyDetail {

    private String currencyRate;
    private double amount;

}
