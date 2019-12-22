package com.test.springcloud.microservices.currencyconversionservice.controller;

import com.test.springcloud.microservices.currencyconversionservice.CurrencyConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {

    @Autowired
    private Environment environment;

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion convertCurrency(@PathVariable final String from, @PathVariable final String to,
                                              @PathVariable Integer quantity) {

        final String url = "http://localhost:8000/currency-exchange/from/USD/to/COP";
        final Map<String, String> params = new HashMap<>();
        params.put("from", from);
        params.put("to", to);
        ResponseEntity<CurrencyConversion> responseEntity
                = new RestTemplate().getForEntity(url, CurrencyConversion.class, params);

        CurrencyConversion conversion = responseEntity.getBody();
        conversion.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        conversion.setQuantity(BigDecimal.valueOf(quantity));
        conversion.setTotalCalculated(conversion.getConversionMultiple().multiply(conversion.getQuantity()z));

        return conversion;

    }
}
