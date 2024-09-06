package com.ng.stream;

import java.util.Arrays;
import java.util.List;

public class ParallelStream {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14);

		int product1 = list.parallelStream().reduce(1, (a, b) -> a * b); // passing same function as accumulator and combiner
		int product2 = list.parallelStream().reduce(1, (a, b) -> a * b, (a, b) -> a * b); //// passing diff functions as accumulator and combiner

		System.out.println("product1 :" + product1);
		System.out.println("product1 :" + product2);

		List<Double> myList = Arrays.asList(7.0, 18.0, 10.0, 24.0, 17.0, 5.0);

		// here reduce accepts 2 parameters 1: accumulator, 2: combiner
		// (1.0, (a,b)-> Math.sqrt(b)) is a accumulator which works on each chunk and
		// reduce and provide result
		// ((a, b) -> a * b) is a combiner which takes each chunk result and combines
		// and produce final result
		double productOfsqrt1 = myList.parallelStream().reduce(1.0, (a, b) -> a * Math.sqrt(b), (a, b) -> a * b);

		System.out.println("Correct :" + productOfsqrt1);

		// this wont work, as its is not same as example1 and needs separator combiner
		double productOfsqrt2 = myList.parallelStream().reduce(1.0, (a, b) -> a * Math.sqrt(b));

		System.out.println("Wrong :" + productOfsqrt2);
	}

}
