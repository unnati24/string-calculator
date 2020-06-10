package com.unavee.stringtools;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void testForEmptyString() {
		StringCalculator calculator = new StringCalculator();
		int res = calculator.add("");
		assertEquals(0, res);
	}

}
