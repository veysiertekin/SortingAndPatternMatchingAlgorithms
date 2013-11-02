package com.sorting.algorithm;
import com.sorting.AAlgorithm;

public class HeapSort extends AAlgorithm {

	private Integer[] array;
	private int largest;

	private int left;
	private int n;
	private int right;

	public void buildheap() {
		n = array.length - 1;
		for (int i = n / 2; i >= 0; i--) {
			maxheap(i);
		}
	}

	public void exchange(int i, int j) {
		int t = array[i];
		array[i] = array[j];
		array[j] = t;
	}

	public void maxheap(int i) {
		left = 2 * i;
		right = 2 * i + 1;

		if (left <= n && array[left] > array[i]) {
			largest = left;
		}

		else {
			largest = i;
		}

		if (right <= n && array[right] > array[largest]) {
			largest = right;
		}
		if (largest != i) {
			exchange(i, largest);
			maxheap(largest);
		}
	}

	@Override
	public Integer[] sort(Integer[] array) {
		this.array = array;
		buildheap();

		for (int i = n; i > 0; i--) {
			exchange(0, i);
			n = n - 1;
			maxheap(0);
		}
		return array;
	}
}
