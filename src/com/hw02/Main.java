package com.hw02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;

import org.junit.runner.JUnitCore;

public class Main {
	private static SecureRandom random = new SecureRandom();
	public static final char[] ALPHABET = "abcçdefgðhýijklmnoöpqrsþtuüvwyz".toCharArray();

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter print = new PrintWriter(System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "x.txt", "UTF-8");

		int textSize = 1000000;
		int patternSize = 3;

		final int MAX_PATTERN_SIZE = 10;

		String line = "";

		for (; patternSize <= MAX_PATTERN_SIZE; patternSize++) {
			TestCase.text = generateArray(textSize);
			TestCase.pattern = generateArray(patternSize);

			JUnitCore.runClasses(TestCase.class);

			print.print(line + textSize + "\t" + patternSize + "\t" + String.copyValueOf(TestCase.pattern) + "\t" + TestCase.map.get("BruteForce_INDEX").intValue() + "\t"
					+ TestCase.map.get("BruteForce") + "\t" + TestCase.map.get("Horspool_INDEX").intValue() + "\t" + TestCase.map.get("Horspool"));
			line = "\n";

			TestCase.map.clear();
		}
		print.close();
	}

	public static char[] generateArray(int size) {
		char[] array = new char[size];
		for (int i = size - 1, j = 0; i >= 0; i--, j++) {
			array[j] = ALPHABET[random.nextInt(ALPHABET.length)];
		}
		return array;
	}
}
