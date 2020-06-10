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

}
