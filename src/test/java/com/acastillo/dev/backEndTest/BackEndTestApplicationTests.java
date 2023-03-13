package com.acastillo.dev.backEndTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.math.BigDecimal;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

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

	@Test
	void subtractionNullOperatorTest() {
		assertThrows(NullPointerException.class, () -> {
			calculator.subtract(null, BigDecimal.valueOf(2));
		});
	}
	
	@Test
	void sumNullOperatorTest() {
		assertThrows(NullPointerException.class, () -> {
			calculator.sum(null, BigDecimal.valueOf(2));
		});
	}

}
