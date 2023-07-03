package com.travis.numberToWord;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class NumberToWordTest {
	NumberToWord ntw = new NumberToWord();

	@Test
	public void test_getWordEquivalent_returnsFive_when5PassedIn() {
		assertEquals(ntw.getWordEquivalent("5"), "five");
	}

	@Test
	public void test_getWordEquivalent_returnsOneHundredAndTwentyThree_when123PassedIn() {
		assertEquals(ntw.getWordEquivalent("123"), "one hundred and twenty-three");
	}

	@Test
	public void test_getWordEquivalent_returnsCorrectString_when9876543210PassedIn() {
		assertEquals(ntw.getWordEquivalent("9876543210"),
				"nine billion eight hundred and seventy-six million five hundred and forty-three thousand two hundred and ten");
	}

	@Test
	public void test_getWordEquivalent_returnsNegativeSeventyFourThousand_whenMinus74000PassedIn() {
		assertEquals(ntw.getWordEquivalent("-74000"), "negative seventy-four thousand");
	}

	@Test
	public void test_getWordEquivalent_returnsSeventyFourThousand_whenMinusMinus74000PassedIn() {
		assertEquals(ntw.getWordEquivalent("--74000"), "seventy-four thousand");
	}

	@Test
	public void test_getWordEquivalent_returnsZero_when0PassedIn() {
		assertEquals(ntw.getWordEquivalent("0"), "zero");
	}

	@Test
	public void test_getWordEquivalent_returnsZero_whenMinus0PassedIn() {
		assertEquals(ntw.getWordEquivalent("-0"), "zero");
	}

	@Test
	public void test_getWordEquivalent_returnsTwoHundredAndNineteen_when219PassedInWithSpacing() {
		assertEquals(ntw.getWordEquivalent("     219   "), "two hundred and nineteen");
	}

	@Test
	public void test_getWordEquivalent_returnsTwoHundredAndNineteen_when219PassedInWithLeading0s() {
		assertEquals(ntw.getWordEquivalent("0000219"), "two hundred and nineteen");
	}

	@Test
	public void test_getWordEquivalent_returnsTwoHundredAndNineteen_when219PassedInWithLeading0sAndSpacing() {
		assertEquals(ntw.getWordEquivalent("     0000219   "), "two hundred and nineteen");
	}

	@Test
	public void test_getWordEquivalent_returnsNegativeTwoHundredAndNineteen_whenNegative219PassedInWithLeading0sAndSpacing() {
		assertEquals(ntw.getWordEquivalent("     -0000219   "), "negative two hundred and nineteen");
	}

	@Test
	public void test_getWordEquivalent_returnsNumberOutOfBounds_whenOver60DigitsPassedIn() {
		assertEquals(ntw.getWordEquivalent("1000000000200000000030000000004000000000500000000060000000007"),
				"Number out of bounds");
	}

	@Test
	public void test_getWordEquivalent_returnsNumberOutOfBounds_whenOver60DigitsPassedInWithProceedingMinusSign() {
		assertEquals(ntw.getWordEquivalent("-1000000000200000000030000000004000000000500000000060000000007"),
				"Number out of bounds");
	}

	@Test
	public void test_getWordEquivalent_returnsSeventy_when60MinusSignsComeBefore70() {
		assertEquals(ntw.getWordEquivalent("------------------------------------------------------------70"),
				"seventy"); //checks negative signs do not cause number to exceed size limit
	}

	@Test
	public void test_getWordEquivalent_returnsInvalidNumber_whenaPassedIn() {
		assertEquals(ntw.getWordEquivalent("a"), "Invalid number");
	}

	@Test
	public void test_getWordEquivalent_returnsInvalidNumber_whena123PassedIn() {
		assertEquals(ntw.getWordEquivalent("a123"), "Invalid number");
	}

	@Test
	public void test_getWordEquivalent_returnsInvalidNumber_when123aPassedIn() {
		assertEquals(ntw.getWordEquivalent("123a"), "Invalid number");
	}

	@Test
	public void test_getWordEquivalent_returnsInvalidNumber_when12a3PassedIn() {
		assertEquals(ntw.getWordEquivalent("12a3"), "Invalid number");
	}

	@Test
	public void test_getWordEquivalent_returnsInvalidNumber_whenMinusaPassedIn() {
		assertEquals(ntw.getWordEquivalent("-a"), "Invalid number");
	}

	@Test
	public void test_getWordEquivalent_returnsInvalidNumber_when14_1PassedIn() {
		assertEquals(ntw.getWordEquivalent("14 1"), "Invalid number");
	}
	
	@Test
	public void test_getWordEquivalent_returnsNoNumberEntered_whenEmptyStringPassedIn() {
		assertEquals(ntw.getWordEquivalent(""), "No number entered");
	}
	
	@Test
	public void test_getWordEquivalent_returnsNoNumberEntered_whenOnlySpacesPassedIn() {
		assertEquals(ntw.getWordEquivalent("     "), "No number entered");
	}


}
