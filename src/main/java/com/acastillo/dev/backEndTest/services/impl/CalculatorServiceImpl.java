package com.acastillo.dev.backEndTest.services.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acastillo.dev.backEndTest.dto.OperationDetailDto;
import com.acastillo.dev.backEndTest.exceptions.OperationException;
import com.acastillo.dev.backEndTest.services.ICalculatorService;

import io.corp.calculator.TracerImpl;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CalculatorServiceImpl implements ICalculatorService{
	
	@Autowired
	private TracerImpl tracer;

	@Override
	public OperationDetailDto subtract(BigDecimal operator1, BigDecimal operator2) {
		tracer.trace("Start Calculator Service Operation(Subtraction): (" + operator1 + " - " + operator2 + ")");
		OperationDetailDto result = new OperationDetailDto();
		result.setOperator1(operator1);
		result.setOperator2(operator2);
		result.setOperation("Subtraction");
		try {
			log.debug("Before subtract:" + operator1 + " - " + operator2);
			result.setResult(operator1.subtract(operator2));
			log.debug("After subtract:" + operator1 + " - " + operator2);
		} catch (OperationException e) {
			log.error("Error subtract:" + operator1 + " - " + operator2);
			throw new OperationException("Error in Subtraction: (" + operator1 + " - " + operator2 + ")");
		}
		
		tracer.trace("Finish Calculator Service Operation(Subtraction): (" + operator1 + " - " + operator2 + ")");
		return result;
	}

	@Override
	public OperationDetailDto sum(BigDecimal operator1, BigDecimal operator2) {
		tracer.trace("Start Calculator Service Operation(Sum): (" + operator1 + " + " + operator2 + ")");
		OperationDetailDto result = new OperationDetailDto();
		result.setOperator1(operator1);
		result.setOperator2(operator2);
		result.setOperation("Sum");
		try {
			log.debug("Before sum:" + operator1 + " + " + operator2);
			result.setResult(operator1.add(operator2));
			log.debug("After sum:" + operator1 + " + " + operator2);
		} catch (OperationException e) {
			log.error("Error sum:" + operator1 + " + " + operator2);
			throw new OperationException("Error in Sum: (" + operator1 + " + " + operator2 + ")");
		}
		tracer.trace("Finish Calculator Service Operation(Sum): (" + operator1 + " + " + operator2 + ")");
		return result;
	}

}
