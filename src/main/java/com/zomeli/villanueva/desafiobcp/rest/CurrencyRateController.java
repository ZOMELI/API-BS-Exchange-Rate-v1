package com.zomeli.villanueva.desafiobcp.rest;

import com.zomeli.villanueva.desafiobcp.model.entity.CurrencyRate;
import com.zomeli.villanueva.desafiobcp.model.response.CurrencyRateResponse;
import com.zomeli.villanueva.desafiobcp.service.CurrencyRateService;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/currency-rate")
public class CurrencyRateController {

    @Autowired
    CurrencyRateService currencyRateService;

    @GetMapping("/all")
    public Flowable<CurrencyRate> findAll() {
	return currencyRateService.findAll();
    }

    @GetMapping("/convert")
    public Maybe<CurrencyRateResponse> convertCurrencyRate(@RequestParam() String originCurrency, @RequestParam() String destinationCurrency,
	    @RequestParam() double amount) {
	return currencyRateService.convertCurrencyRate( originCurrency, destinationCurrency,amount);
    }

    @GetMapping("/currency")
    public Maybe<CurrencyRate> findByCurrencyRate(@RequestParam() String originCurrency, @RequestParam() String destinationCurrency) {
	return currencyRateService.finByCurrencyRate( originCurrency, destinationCurrency);
    }

    @PostMapping("/currency")
    public Maybe<CurrencyRate> updateCurrencyRate(@RequestParam() String originCurrency, @RequestParam() String destinationCurrency,@RequestParam double rate) {
	return currencyRateService.updateCurrencyRate( originCurrency, destinationCurrency,rate);
    }

}
