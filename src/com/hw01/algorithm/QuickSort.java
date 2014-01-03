package com.hw01.algorithm;
import com.hw01.AAlgorithm;

public class QuickSort extends AAlgorithm {
	private Integer[] numbers;
	private Integer number;

	@Override
	public Integer[] sort(Integer[] values) {
		if (values == null || values.length == 0) {
			return values;
		}
		this.numbers = values;
		number = values.length;
		quicksort(0, number - 1);

		return values;
	}

	private void quicksort(int low, int high) {
		int i = low, j = high;
		int pivot = numbers[low + (high - low) / 2];

		while (i <= j) {
			while (numbers[i] < pivot) {
				i++;
			}
			while (numbers[j] > pivot) {
				j--;
			}
			if (i <= j) {
				swap(i, j, numbers);
				i++;
				j--;
			}
		}
		if (low < j)
			quicksort(low, j);
		if (i < high)
			quicksort(i, high);
	}
}