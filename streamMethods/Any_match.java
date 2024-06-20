package streamMethods;
import java.util.*; 

public class Any_match {

		
		public static void main(String[] args) { 
	
		List<Integer> list = Arrays.asList(3, 4, 6, 12, 20); 

	
		boolean answer1 = list.stream().anyMatch(n 
						-> (n * (n + 1)) / 4 == 5); 
		
		 boolean answer2 = list.stream().allMatch(n-> n % 3 ==0);
		
		
		System.out.println(answer1); 
		System.out.println(answer2); 
	} 
} 
// the statement either check true or false.
//any match
//all match
