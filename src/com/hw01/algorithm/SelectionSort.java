package com.hw01.algorithm;
import com.hw01.AAlgorithm;

public class SelectionSort extends AAlgorithm {
	@Override
	public Integer[] sort(Integer[] array) {
		Integer i, j;
		Integer min;
		Integer n = array.length;

		for (j = 0; j < n - 1; j++) {
			min = j;
			for (i = j + 1; i < n; i++) {
				if (array[i] < array[min]) {
					min = i;
				}
			}

			if (min != j) {
				swap(j, min, array);
			}
		}

		return array;
	}
}
