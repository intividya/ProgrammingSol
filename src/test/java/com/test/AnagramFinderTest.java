package com.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnagramFinderTest {

	@DisplayName("AnagramFinder test")
	@Test
	public void findAnagramsTest() {
		AnagramFinder anagramFinder = new AnagramFinder();
		String input1 = "mary";
		String input2 = "army";
		Assertions.assertTrue(anagramFinder.checkIfTwoStringsAreAnagramsUsingSorting(input1, input2));
		Assertions.assertTrue(anagramFinder.areAnagram(input1.toCharArray(), input2.toCharArray()));
		Assertions.assertTrue(anagramFinder.areAnagram(input1, input2));

		String input3 = "silent";
		String input4 = "listen";
		Assertions.assertTrue(anagramFinder.checkIfTwoStringsAreAnagramsUsingSorting(input3, input4));
		Assertions.assertTrue(anagramFinder.areAnagram(input3.toCharArray(), input4.toCharArray()));
		Assertions.assertTrue(anagramFinder.areAnagram(input3, input4));
	}

	@Test
	public void findAnagramsTest2() {
		AnagramFinder anagramFinder = new AnagramFinder();
		String input1 = "ABCDADEBS";
		String input2 = "ABACDEBSD";
		Assertions.assertTrue(anagramFinder.checkIfTwoStringsAreAnagramsUsingSorting(input1, input2));
		Assertions.assertTrue(anagramFinder.areAnagram(input1.toCharArray(), input2.toCharArray()));
		Assertions.assertTrue(anagramFinder.areAnagram(input1, input2));

		input1 = "pit";
		input2 = "pro";
		Assertions.assertFalse(anagramFinder.checkIfTwoStringsAreAnagramsUsingSorting(input1, input2));
		Assertions.assertFalse(anagramFinder.areAnagram(input1.toCharArray(), input2.toCharArray()));
		Assertions.assertFalse(anagramFinder.areAnagram(input1, input2));
	}

}
