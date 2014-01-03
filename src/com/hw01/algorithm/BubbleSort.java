package com.hw01.algorithm;
import com.hw01.AAlgorithm;

public class BubbleSort extends AAlgorithm {
	@Override
	public Integer[] sort(Integer[] array) {
		int length = array.length;

		for (int i = 0; i < length; i++) {
			for (int j = length - 1; j > i; j--) {
				if (array[j] < array[j - 1]) {
					swap(j, j - 1, array);
				}
			}
		}

		return array;
	}
}
