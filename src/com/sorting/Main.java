package com.sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.junit.runner.JUnitCore;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		PrintWriter print = new PrintWriter(System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "x.csv");
		TestCase.SIZE = 1;
		String line = "";

		int repeat = 7;

		for (int i = 0; i < repeat; i++) {
			JUnitCore.runClasses(TestCase.class);

			print.print(line + TestCase.SIZE + "\t" + TestCase.map.get("BubbleSort") + "\t" + TestCase.map.get("HeapSort") + "\t" + TestCase.map.get("InsertionSort") + "\t"
					+ TestCase.map.get("MergeSort") + "\t" + TestCase.map.get("QuickSort") + "\t" + TestCase.map.get("SelectionSort"));
			line = "\n";

			TestCase.map.clear();
			TestCase.SIZE *= 10;
		}
		print.close();

		System.out.println();
	}
}
