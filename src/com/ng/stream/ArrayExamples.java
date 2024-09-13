package com.ng.stream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayExamples {

	public static void main(String[] args) {

		int[] rolls = new int[] { 3, 2, 4, 3 };
		// we can use direct collect(collectors.toSet()) on this, as
		// Arrays.stream(rolls) returns intStream and that method is not supprted by int
		// stream
		Set<Integer> set = Arrays.stream(rolls).collect(HashSet::new, HashSet::add, HashSet::addAll);

		set.forEach(System.out::println);

	}

	int xor = 0;
	int[] prefixArr = null;

	public int[] xorQueriesUsingStreamAPI(int[] arr, int[][] queries) {

		prefixArr = Arrays.stream(arr).map((a) -> xor ^= a).toArray();

		return Arrays.stream(queries).mapToInt((a) -> (a[0] == 0 ? 0 : prefixArr[a[0] - 1]) ^ prefixArr[a[1]]).toArray();
	}

	public int[] xorQueriesUsingNormalJava(int[] arr, int[][] queries) {

		int[] prefixXor = new int[arr.length + 1];

		for (int i = 0; i < arr.length; i++) {

			prefixXor[i + 1] = arr[i] ^ prefixXor[i];
		}

		int[] res = new int[queries.length];

		for (int i = 0; i < queries.length; i++) {

			res[i] = prefixXor[queries[i][1] + 1] ^ prefixXor[queries[i][0]];
		}

		return res;

	}

}
