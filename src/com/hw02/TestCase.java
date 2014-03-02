package com.hw02;

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

	public static char[] text; // should be generated in outside
	public static char[] pattern; // should be generated in outside
	public static Map<String, Double> map = new HashMap<String, Double>();

	long start;

	@Before
	public void setUp() throws Exception {
		algorithm = createObject(Class.forName("com.hw02.algorithm." + name.getMethodName()));

		start = System.nanoTime();
	}

	@After
	public void tearDown() throws Exception {
		double duration = (System.nanoTime() - start) / 1000000D;
		map.put(name.getMethodName(), duration);
	}

	@Test
	public void BruteForce() {
		exec();
	}

	@Test
	public void Horspool() {
		exec();
	}

	private void exec() {
		try {
			map.put(name.getMethodName() + "_INDEX", Double.valueOf(algorithm.find(text, pattern)));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static AAlgorithm createObject(Class<?> klass) {
		try {
			return (AAlgorithm) klass.newInstance();
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
