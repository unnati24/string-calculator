package com.unavee.stringtools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

	public int add(String numbers) {
		if(numbers.length() == 0)
			return 0;
		
		else if (numbers.length() == 1)
			return toInteger(numbers);
		
		else {
			String[] array = checkInputString(numbers);
			return sumOfIntegers(array);
		}
	}



	private String[] checkInputString(String numbers) {
		String[] array;
		if(numbers.startsWith("//")) {
			array = matchDelimiterRegex(numbers);
		} else 
			array = splitInputWithDelimiter(numbers);
		return array;
	}

	
	
	private String[] matchDelimiterRegex(String numbers) {
		String delimiter;
		Matcher match = Pattern.compile("//(\\[(.*?)\\]|(.*))\\n(.*)").matcher(numbers);
		match.matches();
		
		if(match.group(2) == null) {
			delimiter = match.group(3);
		} 
		else {
			delimiter = match.group(2);
			if(delimiter.contains("][")) 
					return splitInputWithMultipleDelimiter(match);
		}
		return match.group(4).split(Pattern.quote(delimiter));
	}



	private String[] splitInputWithMultipleDelimiter(Matcher match) {
		
		String[] delimiterArr;
			
		delimiterArr =match.group(2).split("\\]\\[");
		String delimiterStr = "";
		
		for(int i = 0; i < delimiterArr.length; i++) {
			
			delimiterStr += delimiterArr[i] + "|";
		}
		delimiterStr = delimiterStr.replaceAll("[\\<\\(\\[\\{\\\\\\^\\-\\=\\$\\!\\]\\}\\)\\?\\*\\+\\.\\>]", "\\\\$0");
		return match.group(4).split(delimiterStr.substring(0, delimiterStr.length() - 1));
	}

	
	
	private String[] splitInputWithDelimiter(String numbers) {
		return numbers.split(",|\n");
	}

	private int sumOfIntegers(String[] array) {
		int sum = 0;
		ArrayList<Integer> negativeInt = new ArrayList<Integer>();
		
		for(int i = 0; i < array.length; i++) {
			int value = toInteger(array[i]);
			
			if(value < 0) {
				negativeInt.add(value);
				value = 0;
			} else if(isNumberGreaterThanLimit(value))
				value = 0;
				
			sum += value;
		}
		
		filterNegativeInteger(negativeInt);
		
		return sum;
	}

	private boolean isNumberGreaterThanLimit(int num) {
		if(num > 1000)
			return true;
		
		return false;
	}
	
	private void filterNegativeInteger(ArrayList<Integer> negativeInt) {
		if(negativeInt.size() > 0)
			throw new IllegalArgumentException("Negatives are not allowed " + negativeInt);
	}
	
	private static int toInteger(String number) {
		if(number.isEmpty())
			return 0;
		
		return Integer.parseInt(number);
	}

}
