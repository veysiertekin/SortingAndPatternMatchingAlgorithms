package com.hw02;

public abstract class AAlgorithm {
	public static final char[] ALPHABET = "abcdefghijklmnoprstuvyz".toCharArray();

	/**
	 * @param text
	 * @param pattern
	 * @return index of location find
	 */
	public abstract int find(char[] text, char[] pattern);
}
