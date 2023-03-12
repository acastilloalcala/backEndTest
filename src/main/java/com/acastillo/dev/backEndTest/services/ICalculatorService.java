package com.acastillo.dev.backEndTest.services;

import java.math.BigDecimal;

import com.acastillo.dev.backEndTest.dto.OperationDetailDto;

public interface ICalculatorService {
	
	OperationDetailDto subtract(BigDecimal operator1, BigDecimal operator2);
	
	OperationDetailDto sum(BigDecimal operator1, BigDecimal operator2);
}
