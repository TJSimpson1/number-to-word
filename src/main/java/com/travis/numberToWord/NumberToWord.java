package com.travis.numberToWord;

public class NumberToWord {

	public static String getThreeDigitNumberAsWord(int number) {
		String[] ones = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
				"twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };

		String[] tens = { "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };
		String threeDigitWord = "";
		int hundreds = number / 100;
		if (hundreds > 0) {
			threeDigitWord += ones[hundreds] + " hundred ";
		}
		int tensUnit = number % 100;
		if (tensUnit > 0) {
			if (!threeDigitWord.isEmpty()) {
				threeDigitWord += "and ";
			}

			if (tensUnit < 20) {
				threeDigitWord += ones[tensUnit];
			} else {
				int tensDigit = tensUnit / 10;
				int onesDigit = tensUnit % 10;

				threeDigitWord += tens[tensDigit];

				if (onesDigit > 0) {
					threeDigitWord += "-";
					threeDigitWord += ones[onesDigit];
				}
			}
		}
		return threeDigitWord;
	}

	public static String getWordEquivalent(String number) {
		number = number.strip();
		if(number.charAt(0) == '-') {
			number = number.substring(1);
			return "minus " + getWordEquivalent(number);
		}
		if(Integer.parseInt(number) == 0) {
			return "zero";
		}
		String[] affixes = { "", " thousand", " million", " billion", " trillion", " quadrillion", " quintillion",
				" sextillion", " septillion", " octillion", " nonillion", " decillion", " undecillion", " duodecillion",
				" tredecillion", " quattuordecillion", " quindecillion", " sexdecillion", " septendecillion",
				" octodecillion" };

		String wordEquivalent = "";
		int n = number.length() - 1; // account for indexes (0,...,n-1)
		if (n > 59) {
			return "Number out of bounds";
		}
		int affixIndex = 0;
		while (n >= 0) {
			String threeDigitString = "";
			char ten = (n - 1 >= 0) ? number.charAt(n - 1) : ' ';
			char hundred = (n - 2 >= 0) ? number.charAt(n - 2) : ' ';
			threeDigitString += hundred;
			threeDigitString += ten;
			threeDigitString += number.charAt(n);
	        threeDigitString = threeDigitString.strip();
			int threeDigitNumber = Integer.parseInt(threeDigitString);
			if (threeDigitNumber > 0) {
				String threeDigitNumberAsWord = getThreeDigitNumberAsWord(threeDigitNumber);
				wordEquivalent = threeDigitNumberAsWord + affixes[affixIndex] + " " + wordEquivalent;
			}

			affixIndex++;
			n -= 3;
		}
		return wordEquivalent.strip();
	}

	public static void main(String[] args) {
		System.out.println(getWordEquivalent("-15665165"));
	}

}