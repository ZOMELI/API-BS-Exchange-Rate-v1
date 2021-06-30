package com.zomeli.villanueva.desafiobcp.builder;

import com.zomeli.villanueva.desafiobcp.enums.CurrencyTypeEnum;
import com.zomeli.villanueva.desafiobcp.model.entity.CurrencyRate;
import com.zomeli.villanueva.desafiobcp.model.response.CurrencyDetail;
import com.zomeli.villanueva.desafiobcp.model.response.CurrencyRateResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CurrencyRateBuilder {

    public static CurrencyRateResponse builderCurrencyRateResponse(CurrencyRate currencyRate, double amount){

        return CurrencyRateResponse.builder()
		.origin(CurrencyDetail.builder()
			.currencyRate(CurrencyTypeEnum.valueOfLabel(currencyRate.getOriginCurrency()))
			.amount(amount)
			.build()
		).destination(
			CurrencyDetail.builder()
			.currencyRate(CurrencyTypeEnum.valueOfLabel(currencyRate.getDestinationCurrency()))
			.amount(roundTwoDecimal((currencyRate.getRate() * amount),4))
			.build()
		).build();
    }

    private static Double roundTwoDecimal(Double amount, int numberDecimal) {
	return new BigDecimal(amount.toString()).setScale(numberDecimal, RoundingMode.HALF_UP).doubleValue();
    }

}
