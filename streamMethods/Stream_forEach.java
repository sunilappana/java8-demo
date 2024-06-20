package streamMethods;
import java.util.*;

public class Stream_forEach {

		public static void main(String[] args) 
		{ 
			List<Integer> list = Arrays.asList(2, 4, 6, 8, 10); 

			// Using forEach(Consumer action) to 
			// print the elements of stream 
			// in reverse order 
			list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println); 
			System.out.println();
			list.stream().forEachOrdered(System.out::println); 
		      
		} 
} 

