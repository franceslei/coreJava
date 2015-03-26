package coreJavaDemo;

//this is to learn the keyword "static" and its application   


public class StaticApplicationDemo {

	public static void main(String[] args) {
		int[] arr={6,8,9,50,80};
		int max= getMax(arr);
		System.out.println("Maximum number in this array is: "+ max);
		
		//create an instance of class ArrayTool, then invoke the methods in this class
		ArrayTool tool= new ArrayTool();
		int min=tool.getMin(arr);
		System.out.println("The Min value is: "+min);
		
		tool.printArray(arr);
		tool.selectSort(arr);
		tool.printArray(arr);
		
	}
   
	
	// create a method to get the maximum value in a int[]
	public static int getMax(int[] arr){ // define this method as static, so it can be invoked by main(), because main() is static
		int max=0;
		for(int x=1; x<arr.length; x++){
			if (arr[x]>arr[max]){
				max=x;
			}
		}
		
		return arr[max];
	}
}

//Though we can create an object of class ArrayTool to invoke the methods in this class, ArrayTool doesn't have any special data to be encapsulated 
//None of the methods used any special data of in class ArrayTool, so the object creation is not necessary. 
//So, all the methods in ArrayTool can be defined as static, then they can be invoked by the class name without the creation of object instances
class StaticApplicationOfArrayTool{
	public static void main(String[] args){
		int[] arr = {8,79,9,80,24};
		int max = ArrayToolStatic.getMax(arr);
		System.out.println(max);
		
		ArrayToolStatic.printArray(arr);
		ArrayToolStatic.bubbleSort(arr);
		ArrayToolStatic.printArray(arr);
	}
}



//extract the common methods used in some programs, create a class composed of the common methods, define them as static, so all program can invoke them
class ArrayToolStatic{
	
	//to private the constructor of this class, so other program can't create an instance of this object, because the creation of 
	//the instance is unnecessary since this class only contains static members, 
	//which can be invoked by class name without an object
	private ArrayToolStatic(){}
	
	// define a method to get the Max of an int array
	public static int getMax(int[] arr){
		int max=0;
		for(int x=1; x<arr.length; x++){
			if (arr[x]>arr[max]){
				max=x;
			}
		}
		
		return arr[max];
	}
	
	//define a method to get the Min of an int array
	public static int getMin(int[] arr){
		int min=0;
		for(int x=1; x<arr.length; x++){
			if (arr[x]<arr[min]){
				min=x;
			}
		}
		
		return arr[min];
	}
	
	// define a method to select sort an int array
	public static void selectSort(int[] arr){
		for(int x=0; x<arr.length;x++){
			for(int y=0; y<arr.length;y++){
				if(arr[x]>arr[y]){
					swap(arr,x,y);
				}
			}
		}
	}
	
	//define a method for bubble sort
	public static void bubbleSort(int[] arr){
		for(int x=0;x<arr.length-1;x++){
			for(int y=0; y<arr.length-x-1;y++){
				if(arr[y]>arr[y+1]){
					swap(arr, y, y+1);
				}
			}
			
		}
	}
	
	//define a method to swap two values
	//private this method because this method is only used within this class, it is not necessary to be public
	private static void swap(int[] arr, int a, int b){
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
	
	//define a method to print array
	public static void printArray(int[] arr){
		System.out.print("[");
		for(int x=0; x<arr.length; x++){
			if(x!=arr.length-1)
				System.out.print(arr[x]+", ");
			else
				System.out.println(arr[x]+"]");
		}
	}
}


//create a class to encapsulate methods used in common in many programs
class ArrayTool{
	
	// define a method to get the Max of an int array
	public int getMax(int[] arr){
		int max=0;
		for(int x=1; x<arr.length; x++){
			if (arr[x]>arr[max]){
				max=x;
			}
		}
		
		return arr[max];
	}
	
	//define a method to get the Min of an int array
	public int getMin(int[] arr){
		int min=0;
		for(int x=1; x<arr.length; x++){
			if (arr[x]<arr[min]){
				min=x;
			}
		}
		
		return arr[min];
	}
	
	// define a method to select sort an int array
	public void selectSort(int[] arr){
		for(int x=0; x<arr.length;x++){
			for(int y=0; y<arr.length;y++){
				if(arr[x]>arr[y]){
					swap(arr,x,y);
				}
			}
		}
	}
	
	//define a method for bubble sort
	public void bubbleSort(int[] arr){
		for(int x=0;x<arr.length-1;x++){
			for(int y=0; y<arr.length-x-1;y++){
				if(arr[y]>arr[y+1]){
					swap(arr, y, y+1);
				}
			}
			
		}
	}
	
	//define a method to swap two values
	public void swap(int[] arr, int a, int b){
		int temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
	
	//define a method to print array
	public void printArray(int[] arr){
		System.out.print("[");
		for(int x=0; x<arr.length; x++){
			if(x!=arr.length-1)
				System.out.print(arr[x]+", ");
			else
				System.out.println(arr[x]+"]");
		}
	}
}