package com.hw02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.Arrays;

import org.junit.runner.JUnitCore;

//  -Xms512m -Xmx1512m -XX:PermSize=512m -XX:MaxPermSize=128m
public class Main {
	private static SecureRandom random = new SecureRandom();

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		int patternSize = 1;
		final int textSize = 10000000;
		final int MAX_PATTERN_SIZE = 100;

		int startIndex;
		char line = '\0';

		StringBuilder builder = new StringBuilder();

		TestCase.text = generateArray(textSize);

		for (; patternSize <= MAX_PATTERN_SIZE; patternSize++) {
			startIndex = (TestCase.text.length / 4) * 3 + random.nextInt((TestCase.text.length / 4) - patternSize);
			TestCase.pattern = Arrays.copyOfRange(TestCase.text, startIndex, startIndex + patternSize);

			JUnitCore.runClasses(TestCase.class);

			if (line == '\n')
				builder.append(line);
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
			line = '\n';

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
