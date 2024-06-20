package Java_Stream;

	import java.util.*; 
	import java.util.stream.*; 
	public class LKG {

		public static <T> Stream<T> 
					convertArrayToStream(T array[]) 
		{ 

			
			return Arrays.stream(array); 
		} 

		public static void main(String args[]) 
		{ 
			String array[] = { "Geeks", "forGeeks", 
										"A Computer Portal" }; 

			System.out.println("Array: "
									+ Arrays.toString(array)); 

			Stream<String> 
				stream = convertArrayToStream(array); 

			System.out.println("Stream: "
						+ Arrays.toString(stream.toArray())); 
		} 
} 

