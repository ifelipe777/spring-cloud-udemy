package com.test.springcloud.microservices.currencyexchangeservice.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class ExchangeValue {

    @Id
    private Long id;
    @Column(name = "CURRENCY_FROM")
    private String from;
    @Column(name = "CURRENCY_TO")
    private String to;
    @Column(name = "CONVERSION_MULTIPLE")
    private BigDecimal conversionMultiple;
    private int port;

    public ExchangeValue(final Long id, final String from, final String to, final BigDecimal conversionMultiple) {
        super();
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
    }
}
