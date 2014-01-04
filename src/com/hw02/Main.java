package com.hw02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;

import org.junit.runner.JUnitCore;

//  -Xms512m -Xmx1512m -XX:PermSize=512m -XX:MaxPermSize=128m
public class Main {
	private static SecureRandom random = new SecureRandom();

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		int textSize = 10000000;
		int patternSize = 3;

		final int MAX_PATTERN_SIZE = 15;

		StringBuilder builder = new StringBuilder();
		for (; patternSize <= MAX_PATTERN_SIZE; patternSize++) {
			TestCase.text = generateArray(textSize);
			TestCase.pattern = generateArray(patternSize);

			JUnitCore.runClasses(TestCase.class);

			builder.append(textSize);
			builder.append('\t');
			builder.append(patternSize);
			builder.append('\t');
			builder.append(TestCase.map.get("BruteForce_INDEX").intValue());
			builder.append('\t');
			builder.append(TestCase.map.get("BruteForce"));
			builder.append('\t');
			builder.append(TestCase.map.get("Horspool_INDEX").intValue());
			builder.append('\t');
			builder.append(TestCase.map.get("Horspool"));
			builder.append("\n");
			
			TestCase.map.clear();
			System.gc();
		}

		PrintWriter print = new PrintWriter(System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "x.txt", "UTF-8");
		print.print(builder);
		print.close();
	}

	public static char[] generateArray(int size) {
		char[] array = new char[size];
		for (int i = size - 1, j = 0; i >= 0; i--, j++) {
			array[j] = AAlgorithm.ALPHABET[random.nextInt(AAlgorithm.ALPHABET.length)];
		}
		return array;
	}
}
