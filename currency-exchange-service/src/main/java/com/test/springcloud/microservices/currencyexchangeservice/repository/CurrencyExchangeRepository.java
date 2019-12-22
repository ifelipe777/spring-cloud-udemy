package com.test.springcloud.microservices.currencyexchangeservice.repository;

import com.test.springcloud.microservices.currencyexchangeservice.bean.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<ExchangeValue, Long> {

    public ExchangeValue findByFromAndTo(final String from, final String to);
}
