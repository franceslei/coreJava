package coreJavaDemo;

//import static member of a class
import static java.util.Arrays.*;
import static java.lang.System.*;

import java.util.Arrays;

public class StaticImportDemo {

	public static void main(String[] args) {
		int[] arr={8,9,4,3};
		sort(arr);       //sort is static method of class Arrays
		out.println(Arrays.toString(arr));   //class Arrays and Object both have toString(), here Arrays can't be omitted
		int index = binarySearch(arr,1);
		out.println("Index = "+index); //System can be omitted, because all static member of class System have been imported
		
	}

}
