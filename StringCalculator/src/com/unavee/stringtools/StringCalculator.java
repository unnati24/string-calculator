package com.unavee.stringtools;

public class StringCalculator {

	public int add(String numbers) {
		if(numbers.length() == 0)
			return 0;
		else if (numbers.length() == 1)
			return toInteger(numbers);
		else {
			String[] array = numbers.split(",");
			return sumOfIntegers(array);
		}
			
	}

	private int sumOfIntegers(String[] array) {
		int sum = 0;
		
		for(int i = 0; i < array.length; i++) {
			int value = toInteger(array[i]);
			sum += value;
		}
		return sum;
	}
	
	private static int toInteger(String number) {
		return Integer.parseInt(number);
	}

}
