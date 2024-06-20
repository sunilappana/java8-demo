package streamMethods;
import java.util.ArrayList;
import java.util.List;

//import Java.util.*;

public class Null_value {

		static String second(List<String> list)
		{
			list.stream().forEach(s -> { });
			return "null";
		}

		public static void main(String[] args)
			throws Exception
		{

			List<String> arr1 = new ArrayList<String>();
			arr1.add("Geeks");
			arr1.add("For");
			arr1.add("Geeks");
			String f = second(arr1);
			System.out.println(f);
		}
}

