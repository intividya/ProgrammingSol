package com.test;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuickSortTest {

	@Test
	public void testQuickSort() {
		String test = "PROGRAMMING";
		char[] sortedArray = test.toCharArray();
		QuickSort.quickSort(sortedArray);
		char[] expectedArray = {'A', 'G', 'G', 'I', 'M', 'M', 'N', 'O', 'P', 'R', 'R'};
		Assertions.assertTrue(Arrays.equals(sortedArray, expectedArray));
	}

}
