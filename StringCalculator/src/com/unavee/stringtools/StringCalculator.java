package com.unavee.stringtools;

public class StringCalculator {

	public int add(String numbers) {
		if(numbers.length() == 0)
			return 0;
		else if (numbers.length() == 1)
			return Integer.parseInt(numbers);
		else {
			String[] array = numbers.split(",");
			return Integer.parseInt(array[0]) + Integer.parseInt(array[1]);
		}
			
	}

}
