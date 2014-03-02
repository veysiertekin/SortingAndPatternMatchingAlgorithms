package com.hw02.algorithm;

import com.hw02.AAlgorithm;

public class BruteForce extends AAlgorithm {

	@Override
	public int find(char[] text, char[] pattern) {
		int i, j;
		for (i = 0, j = 0; i < text.length && j < pattern.length; i++) {
			if (text[i] == pattern[j])
				j++;
			else {
				i -= j;
				j = 0;
			}
		}
		if (j == pattern.length)
			return i - pattern.length;
		else
			return -1;
	}

}
