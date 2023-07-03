package com.travis.numberToWord;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class NumberToWordTest {
	@Test
	public void test_getWordEquivalent_returnsFive_when5PassedIn() {
		assertEquals(NumberToWord.getWordEquivalent("5"), "five");
	}

	@Test
	public void test_getWordEquivalent_returnsOneHundredAndTwentyThree_when123PassedIn() {
		assertEquals(NumberToWord.getWordEquivalent("123"), "one hundred and twenty-three");
	}

	@Test
	public void test_getWordEquivalent_returnsCorrectString_when9876543210PassedIn() {
		assertEquals(NumberToWord.getWordEquivalent("9876543210"),
				"nine billion eight hundred and seventy-six million five hundred and forty-three thousand two hundred and ten");
	}
	
	
}
