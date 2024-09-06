package com.ng.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.*;

public class SimpleExample {

	public static void main(String[] args) {

		List<Integer> myList = Arrays.asList(7, 18, 10, 24, 17, 5);
		
		System.out.println("List: " + myList);
		
		System.out.println("Stream on Arrays");
		
		int[] rolls = new int[] {3,2,4,3};
		
		int sum_m =  Arrays.stream(rolls).reduce(0, (a, b) -> a + b);
		
		System.out.println("Sum of Stream on Arrays: " + sum_m);
		
		Stream<Integer> myStream = myList.stream();
		
		System.out.println("Min Value using Stream");
		// min accepts a fucntional interface comparator
		Optional<Integer> minVal = myStream.min(Integer::compare);

		if (minVal.isPresent()) {

			System.out.println(minVal.get());
		}
	
		
		
		System.out.println("Max Value using Stream after first stream is consumed");

		// min was terminal operation so mystream is connsumed
		Optional<Integer> maxVal = myList.stream().max(Integer::compare);

		if (maxVal.isPresent()) {

			System.out.println(maxVal.get());
		}
		
		System.out.println("Filter only odds");

		Stream<Integer> oddStream = myList.stream().filter((a) -> (a & 1) == 1);

		oddStream.forEach(System.out::println); // here also this stream is consumed
		
		System.out.println("Filter only odds and greater than 5");
		
		Stream<Integer> oddGreaterThan5Stream = myList.stream().filter((a) -> (a & 1) == 1).filter((a)-> a > 5);

		oddGreaterThan5Stream.forEach(System.out::println); // here also this stream is consumed

	}

}
