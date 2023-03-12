package com.acastillo.dev.backEndTest.services.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.acastillo.dev.backEndTest.dto.OperationDetailDto;
import com.acastillo.dev.backEndTest.services.ICalculatorService;

@Service
public class CalculatorServiceImpl implements ICalculatorService{

	@Override
	public OperationDetailDto subtract(BigDecimal operator1, BigDecimal operator2) {
		OperationDetailDto result = new OperationDetailDto();
		result.setOperator1(operator1);
		result.setOperator2(operator2);
		result.setOperation("Subtraction");
		result.setResult(operator1.subtract(operator2));
		return result;
	}

	@Override
	public OperationDetailDto sum(BigDecimal operator1, BigDecimal operator2) {
		OperationDetailDto result = new OperationDetailDto();
		result.setOperator1(operator1);
		result.setOperator2(operator2);
		result.setOperation("Sum");
		result.setResult(operator1.add(operator2));
		return result;
	}

}
