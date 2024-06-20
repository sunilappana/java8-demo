package streamMethods;
import java.util.*; 
public class Ordered_meth {

		public static void main(String[] args) 
		{ 
			List<Integer> list = Arrays.asList(-9, -18, 0, 25, 4); 

			System.out.println("The sorted stream is : "); 

			list.stream().sorted().forEach(System.out::println); 
			System.out.println("The Reversed sort Strem is ");
			list.stream().sorted(Comparator.reverseOrder()). 
            forEach(System.out::println); 
		} 
} 

