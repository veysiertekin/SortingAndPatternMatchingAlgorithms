package com.sorting.algorithm;
import com.sorting.AAlgorithm;

public class InsertionSort extends AAlgorithm {
	@Override
	public Integer[] sort(Integer[] array) {
		for (int i = 1; i < array.length; i++) {
			int temp = array[i];
			int j;

			for (j = i - 1; j >= 0 && temp < array[j]; j--) {
				array[j + 1] = array[j];
			}
			array[j + 1] = temp;
		}

		return array;
	}

}
