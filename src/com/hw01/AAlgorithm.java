package com.hw01;
public abstract class AAlgorithm {
	public abstract Integer[] sort(Integer[] array);

	public Integer[] swap(int i, int j, Integer[] array) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		return array;
	}
}
