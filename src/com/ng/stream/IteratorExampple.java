package com.ng.stream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class IteratorExampple {
	
	
	public static void main(String[] args) {
		
		
		List<String> nameList = Arrays.asList("Nirmal Gurjar", "Charan", "Rahul Gurjar", "Viram", "Pappu");
		
		Stream<String> nameStream = nameList.stream();
		
		Iterator<String> itr = nameStream.iterator();
		
		while(itr.hasNext()) {
			
			System.out.println(itr.next());
		}
		

		
		
		
		
		
		
	}
}
