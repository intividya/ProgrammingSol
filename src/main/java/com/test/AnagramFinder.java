package com.test;

import java.util.Arrays;
import java.util.HashMap;

public class AnagramFinder {

	public static void main(String[] args) {
		if (args == null || args.length < 2)
			throw new IllegalArgumentException("No or fewer arguments were provided. Expected 2 string inputs");
		AnagramFinder anagramFinder = new AnagramFinder();
		System.out.println("Sorting Approach: " + anagramFinder.checkIfTwoStringsAreAnagramsUsingSorting(args[0], args[1]));
		System.out.println("Counting Approach: " + anagramFinder.areAnagram(args[0].toCharArray(), args[1].toCharArray()));
		System.out.println("Hashing Approach: " + anagramFinder.areAnagram(args[0], args[1]));
	}

	public boolean checkIfTwoStringsAreAnagramsUsingSorting(String str1, String str2) {
		char[] charArray1 = str1.toCharArray();
		char[] charArray2 = str2.toCharArray();
		if (charArray1.length != charArray2.length)
			return false;
		QuickSort.quickSort(charArray1);
		QuickSort.quickSort(charArray2);
		return Arrays.equals(charArray1, charArray2);
	}

	public boolean areAnagram(char[] str1, char[] str2) {
		int NO_OF_CHARS = 256;
		int[] count1 = new int[NO_OF_CHARS];
		Arrays.fill(count1, 0);
		int[] count2 = new int[NO_OF_CHARS];
		Arrays.fill(count2, 0);
		int i;
		for (i = 0; i < str1.length && i < str2.length; i++) {
			count1[str1[i]]++;
			count2[str2[i]]++;
		}
		if (str1.length != str2.length)
			return false;
		return Arrays.equals(count1, count2);
	}

	public boolean areAnagram(String str1, String str2) {
		HashMap<Character, Integer> hmap1 = new HashMap<Character, Integer>();
		HashMap<Character, Integer> hmap2 = new HashMap<Character, Integer>();
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
		for (char c : arr1)
			hmap1.merge(c, 1, Integer::sum);
		for (char c : arr2)
			hmap2.merge(c, 1, Integer::sum);
		return hmap1.equals(hmap2);
	}

}
