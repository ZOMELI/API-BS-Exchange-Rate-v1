package com.zomeli.villanueva.desafiobcp.service;

import com.zomeli.villanueva.desafiobcp.model.entity.CurrencyRate;
import com.zomeli.villanueva.desafiobcp.model.response.CurrencyRateResponse;
import io.reactivex.Flowable;
import io.reactivex.Maybe;

public interface CurrencyRateService {

    Flowable<CurrencyRate> findAll();

    Maybe<CurrencyRateResponse> convertCurrencyRate(String origin, String destination, double amount);

    Maybe<CurrencyRate> finByCurrencyRate(String origin, String destination);

    Maybe<CurrencyRate> updateCurrencyRate(String origin, String destination,double rate);
}
