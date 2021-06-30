package com.zomeli.villanueva.desafiobcp.service.impl;

import com.zomeli.villanueva.desafiobcp.builder.CurrencyRateBuilder;
import com.zomeli.villanueva.desafiobcp.model.entity.CurrencyRate;
import com.zomeli.villanueva.desafiobcp.model.response.CurrencyRateResponse;
import com.zomeli.villanueva.desafiobcp.repository.CurrencyRateRepository;
import com.zomeli.villanueva.desafiobcp.service.CurrencyRateService;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyRateServiceimpl implements CurrencyRateService {

    @Autowired
    CurrencyRateRepository currencyRateRepository;

    @Override
    public Flowable<CurrencyRate> findAll() {
	return currencyRateRepository.findAll();
    }

    @Override
    public Maybe<CurrencyRateResponse> convertCurrencyRate(String origin, String destination, double amount) {

	return currencyRateRepository.findByOriginCurrencyAndDestinationCurrency(origin, destination)
		.map(currencyRate -> CurrencyRateBuilder.builderCurrencyRateResponse(currencyRate, amount));
    }

    @Override
    public Maybe<CurrencyRate> finByCurrencyRate(String origin, String destination) {
	return currencyRateRepository.findByOriginCurrencyAndDestinationCurrency(origin, destination);
    }

    @Override
    public Maybe<CurrencyRate> updateCurrencyRate(String origin, String destination, double rate) {
	return currencyRateRepository.findByOriginCurrencyAndDestinationCurrency(origin, destination).flatMap(currencyRate -> {
	    currencyRate.setRate(rate);
	    return currencyRateRepository.save(currencyRate).toMaybe();
	});
    }

}












