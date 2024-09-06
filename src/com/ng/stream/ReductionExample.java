package com.ng.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReductionExample {

	public static void main(String[] args) {

		List<Integer> myList = Arrays.asList(7, 18, 10, 24, 17, 5);

		// Type 1: which accepts one parameter Binary Operator Functional Interface
		// Optional<T> reduce (BinaryOperator<T> accumulator) , lambda passed is called accumulator
		Optional<Integer> prouductOpt = myList.stream().reduce((a, b) -> a * b);

		System.out.println(prouductOpt.get());

		// Type 2: which accepts 2 parameters,first Identity (initial value), second
		// Binary Operator Functional Interface
		// T reduce<T identityValue, BinaryOperator<T> accumulator)
		int prouduct = myList.stream().reduce(1, (a, b) -> a * b);

		System.out.println(prouduct);
   
		int evenProuduct = myList.stream().reduce(1, (currentResult, nextElement) -> { //> this is accumulator function
			
			//is odd
			if((nextElement & 1) == 1) {
				
				return currentResult * nextElement;
			}
			
			return currentResult;

		});

		System.out.println(evenProuduct);

	}
}
