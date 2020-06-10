package com.unavee.stringtools;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	StringCalculator calculator = new StringCalculator();
	
	@Test
	public void testForEmptyString() {
		assertEquals(0, calculator.add(""));
	}
	
	@Test
	public void testForSingleInteger() {
		assertEquals(1, calculator.add("1"));
	}
	
	@Test
	public void testForTwoIntegers() {
		assertEquals(3, calculator.add("1,2"));
	}
	
	@Test
	public void testForUnkownNumberOfIntegers() {
		assertEquals(6, calculator.add("1,2,3"));
		assertEquals(20, calculator.add("1,2,3,10,4"));
	}
	
	@Test
	public void testForNewlineDelimiter() {
		assertEquals(6, calculator.add("1\n2,3"));
		assertEquals(6, calculator.add("1\n2\n3"));
		assertEquals(14, calculator.add("1\n2,3\n8"));
	}
	
	@Test
	public void testForAnyDelimiter() {
		assertEquals(3, calculator.add("//;\n1;2"));
		assertEquals(6, calculator.add("//*\n1*2*3"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testStringWithNegativeInput() {
		calculator.add("-1,2");
		calculator.add("-1,-2,-4");
	}
	
	@Test
	public void testStringWithIntegersGreaterThanLimit() {
		assertEquals(3, calculator.add("1001,3"));
		calculator.add("10,1004\n4");
	}

	@Test
	public void testForAnyDelimiterPattern() {
		assertEquals(6, calculator.add("//[***]\n1***2***3"));
		assertEquals(6, calculator.add("//[????]\n1????2????3"));
	}
}
