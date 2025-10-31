package org.example.baekjoon.study;

import java.io.*;
import java.util.*;

public class No_11659 {
	
	static int N;
	static int M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 배열의 크기
		M = Integer.parseInt(st.nextToken()); // 배열 인덱스 범위 합을 구하는 횟수 ex. 1,3 -> 첫번째부터 세번째까지 인덱스 범위의 합을 구해야함.
		
		int[] prefixSum = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			prefixSum[i] = prefixSum[i - 1] + Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int firstIndex = Integer.parseInt(st.nextToken());
			int lastIndex = Integer.parseInt(st.nextToken());
			
			int result = prefixSum[lastIndex] - prefixSum[firstIndex - 1];
			System.out.println(result);
		}
		
	}
}
