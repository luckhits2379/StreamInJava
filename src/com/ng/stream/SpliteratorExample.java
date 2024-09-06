package com.ng.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

public class SpliteratorExample {

	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

		Spliterator<Integer> spliterator = numbers.spliterator();
		
		// Process elements sequentially
		spliterator.forEachRemaining(System.out::println);
		
		// Split and process in parallel
		Spliterator<Integer> secondHalf = spliterator.trySplit();
		
		if (secondHalf != null) {
			secondHalf.forEachRemaining(System.out::println);
		}
		
	

	}
}