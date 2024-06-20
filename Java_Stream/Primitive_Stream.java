package Java_Stream;

	import java.util.*; 
	import java.util.stream.*; 
	public class Primitive_Stream {

		public static IntStream 
				convertArrayToStream(int array[]) 
		{ 
			return IntStream.of(array); 
		} 

		public static void main(String args[]) 
		{ 
			int[] array = new int[] { 3, 2, 5, 4, 1 }; 
			System.out.println("Array: "
						+ Arrays.toString(array)); 
			IntStream stream = convertArrayToStream(array); 
			System.out.println("Stream: "
						+ Arrays.toString(stream.toArray())); 
		} 
} 
