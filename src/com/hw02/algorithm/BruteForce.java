package com.hw02.algorithm;

import com.hw02.AAlgorithm;

public class BruteForce extends AAlgorithm {

	@Override
	public int sort(char[] text, char[] pattern) {
		int M = pattern.length;
		int N = text.length;
		int i, j;
		for (i = 0, j = 0; i < N && j < M; i++) {
			if (text[i] == pattern[j])
				j++;
			else {
				i -= j;
				j = 0;
			}
		}
		if (j == M)
			return i - M;
		else
			return N;
	}

}
