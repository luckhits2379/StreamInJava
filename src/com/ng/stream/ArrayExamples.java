package com.ng.stream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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

		prefixArr = Arrays.stream(arr).map(a -> xor ^= a).toArray();

		return Arrays.stream(queries).mapToInt(a -> (a[0] == 0 ? 0 : prefixArr[a[0] - 1]) ^ prefixArr[a[1]]).toArray();
	}

	// Using Array to map to entryset and then to list
	public String[] uncommonFromSentences(String s1, String s2) {

		return Arrays.stream((s1 + " " + s2).split(" ")).collect(Collectors.groupingBy(s -> s, Collectors.counting())).entrySet().stream().filter(e -> e.getValue() == 1).map(e -> e.getKey()).toArray(String[]::new);

		// return list.toArray(new String[list.size()]);

	}

}
