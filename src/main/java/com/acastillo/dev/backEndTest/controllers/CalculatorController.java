package com.acastillo.dev.backEndTest.controllers;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acastillo.dev.backEndTest.dto.OperationDetailDto;
import com.acastillo.dev.backEndTest.services.ICalculatorService;
import com.acastillo.dev.backEndTest.spec.CalculatorApi;

import io.corp.calculator.TracerImpl;
import io.swagger.annotations.ApiParam;

@RestController
public class CalculatorController implements CalculatorApi {
	
	@Autowired
	private ICalculatorService calculatorService;
	
	@Autowired
	private TracerImpl tracer;

	public ResponseEntity<OperationDetailDto> subtract(@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "operator1", required = true) BigDecimal operator1,@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "operator2", required = true) BigDecimal operator2){
		tracer.trace("Start Calculator Controller Operation(Subtraction): (" + operator1 + " - " + operator2 + ")");
		OperationDetailDto result = calculatorService.subtract(operator1, operator2);
		tracer.trace("Finish Calculator Controller Operation(Subtraction): (" + operator1 + " - " + operator2 + ")");
		return new ResponseEntity<>((result), HttpStatus.OK);
	}
	
	public ResponseEntity<OperationDetailDto> sum(@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "operator1", required = true) BigDecimal operator1,@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "operator2", required = true) BigDecimal operator2){
		tracer.trace("Start Calculator Controller Operation(Sum): (" + operator1 + " + " + operator2 + ")");
		OperationDetailDto result = calculatorService.sum(operator1, operator2);
		tracer.trace("Finish Calculator Controller Operation(Sum): (" + operator1 + " + " + operator2 + ")");
		return new ResponseEntity<>((result), HttpStatus.OK);
	}
}
