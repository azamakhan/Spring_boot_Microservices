package com.project2.microservices.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private ExchangeValueRepository exValRepository;
	
	@GetMapping("/currency-exchange/from/{fromCurrency}/to/{toCurrency}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String fromCurrency, @PathVariable String toCurrency) {
		ExchangeValue exVal = exValRepository.findByFromAndTo(fromCurrency, toCurrency);
		exVal.setPort(Integer.parseInt(env.getProperty("local.server.port")));
	return exVal;
	}
	
}
