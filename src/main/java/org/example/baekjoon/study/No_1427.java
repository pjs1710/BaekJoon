package org.example.baekjoon.study;

import java.io.*;
import java.util.*;

public class No_1427 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		String[] split = br.readLine().split("");
		Arrays.sort(split, Collections.reverseOrder());
		for (String s : split) {
			result.append(s);
		}
		
		int N = Integer.parseInt(result.toString());
		System.out.println(N);
	}
}
