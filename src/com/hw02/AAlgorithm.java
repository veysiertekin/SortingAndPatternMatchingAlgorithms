package com.hw02;

public abstract class AAlgorithm {
	// En azýndan eþleþebilinmesi açýsýndan alfabenin boyutunu kuçük tuttuk defgh
	public static final char[] ALPHABET = "abcdefgh".toCharArray();
	/**
	 * @param text
	 * @param pattern
	 * @return index of location find
	 */
	public abstract int sort(char[] text, char[] pattern);
}
