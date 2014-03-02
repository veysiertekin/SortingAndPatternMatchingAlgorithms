package com.hw02;

public abstract class AAlgorithm {
	public static final char[] ALPHABET = "abc�defg�h�ijklmno�prs�tu�vyz".toCharArray();

	/**
	 * @param text
	 * @param pattern
	 * @return index of location find
	 */
	public abstract int find(char[] text, char[] pattern);
}
