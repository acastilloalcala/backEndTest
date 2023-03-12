package com.acastillo.dev.backEndTest;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.acastillo.dev.backEndTest.controllers.CalculatorController;
import com.acastillo.dev.backEndTest.dto.OperationDetailDto;

@SpringBootTest
class BackEndTestApplicationTests {
	
	@Autowired
	private CalculatorController calculator;

	@Test
	void sumTest() {
		OperationDetailDto expectedSum = new OperationDetailDto();
		expectedSum.setOperator1(BigDecimal.valueOf(2));
		expectedSum.setOperator2(BigDecimal.valueOf(3));
		expectedSum.setOperation("Sum");
		expectedSum.setResult(BigDecimal.valueOf(5));
		
		OperationDetailDto sumResult = calculator.sum(BigDecimal.valueOf(2), BigDecimal.valueOf(3)).getBody();
		
		assert expectedSum.equals(sumResult);
	}
	
	@Test
	void subtractTest() {
		OperationDetailDto expectedSubtract = new OperationDetailDto();
		expectedSubtract.setOperator1(BigDecimal.valueOf(3));
		expectedSubtract.setOperator2(BigDecimal.valueOf(2));
		expectedSubtract.setOperation("Subtraction");
		expectedSubtract.setResult(BigDecimal.valueOf(1));
		OperationDetailDto subtractResult = calculator.subtract(BigDecimal.valueOf(3), BigDecimal.valueOf(2)).getBody();
		
		assert expectedSubtract.equals(subtractResult);
	}

}
