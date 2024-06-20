package Java_Stream;
	import java.io.*; 
	import java.util.stream.*; 
	import java.util.Arrays; 
	import java.util.Map; 
	public class Convert_Map {
		public static Map toMap(String input) 
		{ 
			Map<String, Integer> lengthMap 
				= Arrays.stream(input.split(" ")) 
					.collect(Collectors.toMap( 
						value 
						-> value, 
						value -> value.length())); 

			return lengthMap; 
		} 
		public static void main(String[] args) 
		{ 
			String input = "Geeks for Geek"; 

			System.out.println(toMap(input)); 
		} 
} 

