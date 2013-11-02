package com.sorting;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class TestCase {
	AAlgorithm algorithm;
	@Rule
	public TestName name = new TestName();

	Integer[] numbers;
	public static int SIZE = 0;
	public static Map<String, Double> map = new HashMap<String, Double>();
	long start;

	@Before
	public void setUp() throws Exception {
		algorithm = createObject(Class.forName("com.sorting.algorithm." + name.getMethodName()));

		numbers = generateArray(SIZE);
		start = System.nanoTime();
	}

	@After
	public void tearDown() throws Exception {
		double duration = (System.nanoTime() - start) / 1000000D;
		map.put(name.getMethodName(), duration);
	}

	@Test
	public void BubbleSort() {
		algorithm.sort(numbers);
	}

	@Test
	public void HeapSort() {
		algorithm.sort(numbers);
	}

	@Test
	public void InsertionSort() {
		algorithm.sort(numbers);
	}

	@Test
	public void MergeSort() {
		algorithm.sort(numbers);
	}

	@Test
	public void QuickSort() {
		algorithm.sort(numbers);
	}

	@Test
	public void SelectionSort() {
		algorithm.sort(numbers);
	}

	@SuppressWarnings("rawtypes")
	public static AAlgorithm createObject(Class klass) {
		try {
			return (AAlgorithm) klass.newInstance();
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Integer[] generateArray(Integer size) {
		Integer[] array = new Integer[size];
		for (int i = size - 1, j = 0; i >= 0; i--, j++) {
			array[j] = i;
		}
		return array;
	}
}
