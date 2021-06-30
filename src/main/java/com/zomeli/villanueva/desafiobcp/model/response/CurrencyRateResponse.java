package com.zomeli.villanueva.desafiobcp.model.response;

import lombok.*;

@Getter
@Setter
@Builder
public class CurrencyRateResponse {

    private CurrencyDetail origin;
    private CurrencyDetail destination;


}
