package com.ng.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MappingExample {

	// Using map we can convert one type stream to another type, we can filter
	// before converting or after converting, all stream operations are applicable,
	// before or after
	public static void main(String[] args) {

		// Map stream of double to double
		List<Double> myList = Arrays.asList(7.0, 18.0, 10.0, 24.0, 17.0, 5.0);

		Stream<Double> sqrtStream = myList.stream().map((a) -> Math.sqrt(a));

		sqrtStream.forEach(System.out::println);

		// get Stream of length of below String, mapping of string stream to integer
		// steam
		List<String> nameList = Arrays.asList("Nirmal Gurjar", "Charan", "Rahul Gurjar", "Viram", "Pappu");

		Stream<String> nameListStream = nameList.stream();

		Stream<Integer> lengthStream = nameListStream.map((s) -> s.length());

		lengthStream.forEach(System.out::println);

		// filtering
		Stream<Integer> lengthStreamFilter = nameList.stream().filter(name -> name.contains("Gurjar")).map(name -> name.length());

		lengthStreamFilter.forEach(System.out::println);
	}
}
