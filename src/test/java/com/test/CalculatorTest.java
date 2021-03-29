package com.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

	@Test
	public void test0() {
		Calculator calculator = new Calculator();
		Assertions.assertEquals(calculator.evaluate("10 + 2 * 6"), "22");
		Assertions.assertEquals(calculator.evaluate("100 * 2 + 12"), "212");
		Assertions.assertEquals(calculator.evaluate("100 * ( 2 + 12 )"), "1400");
		Assertions.assertEquals(calculator.evaluate("100 * ( 2 + 12 ) / 14"), "100");
	}

	@Test
	@DisplayName("Problem#3")
	public void test1() {
		Calculator calculator = new Calculator();
		Assertions.assertEquals(calculator.evaluate("2+30"), "32");
		Assertions.assertEquals(calculator.evaluate("2 * 3"), "6");
		Assertions.assertEquals(calculator.evaluate("2 -3"), "-1");
		Assertions.assertEquals(calculator.evaluate("2 / 3"), "0.6666666666666666");
	}

	@Test
	@DisplayName("Problem#4")
	public void test2() {
		Calculator calculator = new Calculator();
		Assertions.assertEquals(calculator.evaluate("2+30+4"), "36");
		Assertions.assertEquals(calculator.evaluate("2 - 3 + 4 + 15"), "18");
		Assertions.assertEquals(calculator.evaluate("2 * 3 * 4"), "24");
		Assertions.assertEquals(calculator.evaluate("2 * 3 / 4 * 20"), "30");
	}

	@Test
	@DisplayName("Problem#5")
	public void test3() {
		Calculator calculator = new Calculator();
		Assertions.assertEquals(calculator.evaluate("2+3*40"), "122");
		Assertions.assertEquals(calculator.evaluate("2 * 3 + 4"), "10");
		Assertions.assertEquals(calculator.evaluate("2 / 3 + 4 - 1"), "3.666666666666667");
		Assertions.assertEquals(calculator.evaluate("2 - 3 * 4"), "-10");
		Assertions.assertEquals(calculator.evaluate("5 * ( 6 + 2 ) - 12 / 4"), "37");
		Assertions.assertEquals(calculator.evaluate("2+3*(4*3)"), "38");

	}

}
