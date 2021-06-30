package com.zomeli.villanueva.desafiobcp.repository;

import com.zomeli.villanueva.desafiobcp.model.entity.CurrencyRate;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import org.springframework.data.repository.reactive.RxJava2CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRateRepository extends RxJava2CrudRepository<CurrencyRate,String> {

    Maybe<CurrencyRate> findByOriginCurrencyAndDestinationCurrency(String origin, String destination);

}
