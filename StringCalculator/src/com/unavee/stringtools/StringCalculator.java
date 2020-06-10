package com.unavee.stringtools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

	public int add(String numbers) {
		if(numbers.length() == 0)
			return 0;
		else if (numbers.length() == 1)
			return toInteger(numbers);
		else {
			
			String[] array;
			
			if(numbers.startsWith("//")) {
				array = matchDelimiterRegex(numbers);
			} else 
				array = splitInputWithDelimiter(numbers);
			return sumOfIntegers(array);
		}
			
	}

	private String[] matchDelimiterRegex(String numbers) {
		String delimiter;
		Matcher match = Pattern.compile("//(.*)\n(.*)").matcher(numbers);
		match.matches();
		delimiter = match.group(1);
		return match.group(2).split(Pattern.quote(delimiter));
	}

	private String[] splitInputWithDelimiter(String numbers) {
		return numbers.split(",|\n");
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
