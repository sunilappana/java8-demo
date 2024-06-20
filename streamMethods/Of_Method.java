package streamMethods;
import java.util.stream.Stream;

public class Of_Method { 

		public static void main(String[] args) 
		{ 
			// Creating an Stream 
			Stream<String> stream = Stream.of("Sunil", "Krishna","Ram"); 

			// Displaying the sequential ordered stream 
			stream.forEach(System.out::println); 
		} 
} 
