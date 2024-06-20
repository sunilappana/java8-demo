package Java_Stream;
import java.util.*; 
import java.util.stream.*; 


public class JKL {

		public static <K, V> Stream<Map.Entry<K, V> > 
		convertMapToStream(Map<K, V> map) 
		{ 

			 
			return map 

			
				.entrySet() 

				
				.stream(); 
		} 

		public static void main(String args[]) 
		{ 

	
			Map<Integer, String> map = new HashMap<>(); 

			
			map.put(1, "Geeks"); 
			map.put(2, "forGeeks"); 
			map.put(3, "A computer Portal"); 

			
			System.out.println("Map: " + map); 

			
			Stream<Map.Entry<Integer, String> > stream = 
									convertMapToStream(map); 
			System.out.println("Stream: "
						+ Arrays.toString(stream.toArray())); 
		} 
	} 


