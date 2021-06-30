package com.zomeli.villanueva.desafiobcp;

import com.zomeli.villanueva.desafiobcp.model.entity.CurrencyRate;
import com.zomeli.villanueva.desafiobcp.enums.CurrencyTypeEnum;
import com.zomeli.villanueva.desafiobcp.repository.CurrencyRateRepository;
import io.reactivex.Flowable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class DesafioBcpApplication implements CommandLineRunner {

    @Autowired
    CurrencyRateRepository currencyRateRepository;

    public static void main(String[] args) {
	SpringApplication.run(DesafioBcpApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

	currencyRateRepository.deleteAll().subscribe();

	Flowable<CurrencyRate> currencyRateFlowable = Flowable.fromArray(
		CurrencyRate.builder()
			.id("5f0eab4dcdf1ff799b3cfdd0")
			.originCurrency(CurrencyTypeEnum.DOLARES.toAnotherValueString())
			.destinationCurrency(CurrencyTypeEnum.SOLES.toAnotherValueString())
			.rate(3.89).build(),

		CurrencyRate.builder()
			.id("5f0eab4dcdf1ff799b3cfdd1")
			.originCurrency(CurrencyTypeEnum.SOLES.toAnotherValueString())
			.destinationCurrency(CurrencyTypeEnum.DOLARES.toAnotherValueString())
			.rate(0.26).build(),

		CurrencyRate.builder()
			.id("5f0eab4dcdf1ff799b3cfdd2")
			.originCurrency(CurrencyTypeEnum.EURO.toAnotherValueString())
			.destinationCurrency(CurrencyTypeEnum.SOLES.toAnotherValueString())
			.rate(4.63).build(),

		CurrencyRate.builder()
			.id("5f0eab4dcdf1ff799b3cfdd3")
			.originCurrency(CurrencyTypeEnum.SOLES.toAnotherValueString())
			.destinationCurrency(CurrencyTypeEnum.EURO.toAnotherValueString())
			.rate(0.22).build(),

		CurrencyRate.builder()
			.id("5f0eab4dcdf1ff799b3cfdd4")
			.originCurrency(CurrencyTypeEnum.SOLES.toAnotherValueString())
			.destinationCurrency(CurrencyTypeEnum.YENES_JAPONESES.toAnotherValueString())
			.rate(28.42).build(),

		CurrencyRate.builder()
			.id("5f0eab4dcdf1ff799b3cfdd5")
			.originCurrency(CurrencyTypeEnum.YENES_JAPONESES.toAnotherValueString())
			.destinationCurrency(CurrencyTypeEnum.SOLES.toAnotherValueString())
			.rate(0.035).build()
	);
	currencyRateRepository.saveAll(currencyRateFlowable).subscribe();

    }

}
