package com.ng.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingExample {

	public static void main(String[] args) {

		List<String> nameList = Arrays.asList("Nirmal Gurjar", "Charan", "Rahul Gurjar", "Viram", "Pappu");

		Stream<String> nameListStream = nameList.stream();

		System.out.println("------Type 1 using List------");

		Stream<Integer> lengthStream = nameListStream.map((s) -> s.length());

		// Type1 Collector : <R, A> R collect(Collector<? super T, A, R> collector)
		List<Integer> lengthList = lengthStream.collect(Collectors.toList());

		lengthList.forEach(System.out::println);

		System.out.println("------Type 1 using set------");

		Set<Integer> lengthSet = nameList.stream().map((s) -> s.length()).collect(Collectors.toSet());

		lengthSet.forEach(System.out::println);

		System.out.println("------Type 2 using List------");

		// Type2 : <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T>
		// accumulator,BiConsumer<R, R> combiner);
		// arg1 defines type, arg2 define how to add one element, arg3 defines how to merge or 2 partial result
		List<Integer> lengthList1 = nameList.stream().map((s) -> s.length()).collect(() -> new ArrayList<Integer>(), (list, element) -> list.add(element), (listA, listB) -> listA.addAll(listB));

		lengthList1.forEach(System.out::println);

		System.out.println("------Type 2 using Set and Method ref------");

		// Type2 : <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T>
		// accumulator,BiConsumer<R, R> combiner);
		Set<Integer> lengthSet1 = nameList.stream().map((s) -> s.length()).collect(HashSet::new, HashSet::add, HashSet::addAll);

		lengthSet1.forEach(System.out::println);
		
		
		
		int[] rolls = new int[] {3,2,4,3};
		// we can use direct collect(collectors.toSet()) on this, as Arrays.stream(rolls) returns intStream and that method is not supprted by int stream 
		Set<Integer> set = Arrays.stream(rolls).collect(HashSet::new, HashSet::add, HashSet::addAll);
		
		set.forEach(System.out::println);

	}

}
