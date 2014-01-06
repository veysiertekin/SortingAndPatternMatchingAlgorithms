package com.hw02;

public abstract class AAlgorithm {
	public static final char[] ALPHABET = "abcçdefgðhýijklmnoöprsþtuüvyz".toCharArray();

	/**
	 * @param text
	 * @param pattern
	 * @return index of location find
	 */
	public abstract int sort(char[] text, char[] pattern);
}
