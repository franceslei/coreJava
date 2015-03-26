package coreJavaDemo;

import java.util.Arrays;

public class ArrayDemo {

	public static void main(String[] args) {
		trans(6,2);
				
		int[] x = new int[3];
		//  also write as int x[] = new int[3];
		System.out.println(x[1]);  // arr[] has default initialized value
		
		//arr[1]=59;
		//System.out.println(arr[1]);
		
		//arr=null;
		//System.out.println(arr[1]); //NullPointerException
		
		int[] y = x;
		y[1] = 89;
		x[1] =77;
		x=null;
		System.out.println(y[1]);
		//System.out.println(x[1]);
		
		int[] arr = new int[]{3,5,8,9,60};  // define and initialize arr
		int[] arr1={8,4,3,9,76,57,46};
		
		//manipulate array
		//get elements from an array
		int[] array = new int[]{67,5,9};
		for(int i=0; i<array.length; i++){    
			System.out.println(array[i]);
		}
		
		printArray(array);
		System.out.println(getMax(array));
		System.out.println(getMin(array));
		Arrays.sort(arr);  //class Arrays has a method sort()
	}
	
	//define function to swap the position of two elements in an int[]
	public static void swap(int[] arr, int a, int b){
		int temp= arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}
	
	//define a function to print all the elements in an array, seperated with comma
	public static void printArray(int[] arr){
		for(int i=0; i<arr.length; i++){
			if (i!=arr.length-1)
			System.out.print(arr[i]+", ");
			else
				System.out.println(arr[i]);
		}
	}
	
	//define function to get the maximum value in an int[]
	public static int getMax(int[] arr){
		int max=arr[0];
		for(int i=0; i<arr.length; i++){
			if(arr[i]>max)
				max=arr[i];
		}
		return max;
	}
	//another way of getMax, initialize index max=0
	public static int getMax_2(int[] arr){
		int max=0;
		for(int i=0; i<arr.length; i++){
			if(arr[i]>arr[max])
				max=i;
		}
		return arr[max];
	}
	
	
	//define function to get the min value of an int[]
	public static int getMin(int[] arr){
		int min=arr[0];
		for(int i=0; i<arr.length; i++){
			if(arr[i]<min)
				min=arr[i];
		}
		return min;
	}
	
	//sort array, selectSort compares arr.length! times, use nested for loops
	//the nested for loop finishes the first time, the max or min is stored at index[0]
	public static void selectSort(int[] arr){
		for(int x=0; x<arr.length-1; x++){
			for(int y=x+1; y<arr.length; y++){
				if(arr[x]>arr[y]){
				/*	int temp=arr[x];
					arr[x]=arr[y];
					arr[y]=temp;   */
					swap(arr,x,y);
				}
			}
		}
	}
	
	//bubbleSort
	public static void bubbleSort(int[] arr){
		for(int x=0; x<arr.length-1; x++){
			for(int y=0; y<arr.length-x-1; y++){  //-x, the elements for comparison less; -1 avoid IndexOutOfBounds
				if(arr[y]>arr[y+1]){
				/*	int temp=arr[y];
					arr[y]=arr[y+1];
					arr[y+1]=temp;   */
					swap(arr,y,y+1);
				}
			}
		}
		
	}
	
	//search, find an element the index first occurrance in an array; return -1, means the element doesn't exist in the array
	public static int getIndex(int[] arr, int key){
		for(int x=0; x<arr.length; x++){
			if(arr[x]==key)
				return x;
		}
		return -1;
	}
	
	//binarySearch, the array has to be sorted first, this way is more efficient 
	public static int binarySearch(int[] arr, int key){
		int min=0, max=arr.length-1, mid=(min+max)/2;
		while(arr[mid]!=key){
		if (key>arr[mid])
			min=mid+1;
		else if(key<arr[mid])
			max=mid-1;
		if (min>max)
			return -1;
		mid=(min+max)/2;
		}	
		return mid;
	}
	
	//another way of binarySearch
	public static int binarySearch_2(int[] arr, int key){
		int min=0, max=arr.length-1, mid=(min+max)/2;
		while(min<=max){
			mid=(max+min)>>1;
			if (key>arr[mid])
				min=mid+1;
			else if (key<arr[mid])
				max=mid-1;
			else
				return mid;
		}	
		return-1;
	}

	//insert a number into a sorted int[], make sure the new int[] is stilled sorted
	public static int insert(int[] arr, int key){
		int min=0, max=arr.length-1, mid=(min+max)/2;
		while (min<max){
			mid=(max+min)>>1;
			if (key>arr[mid])
				min=mid+1;
			else if (key<arr[mid])
				max=mid-1;
			else return mid;  //if key is contained in the array, mid is the index of the key and also the index key should be inserted
		}
		return min; // if key is not contained in the array, min should be the index where key should be inserted
	}
	
	//decimal to binary, valid for positive number
    public static void toBin(int num){
    	StringBuffer sb=new StringBuffer();
    	while(num>0){
    		sb.append(num%2);
    		num=num/2;
    	}
    	System.out.println(sb.reverse());	
    }
    
    //another way of decimal to binary, valid for both positive and negative number
    public static void toBin_2(int num){
    	char[] chs={'0','1'};
    	char[] arr=new char[32];
    	int pos = arr.length;
    	while(num!=0){
    		int temp =num & 1;
    		arr[--pos]=chs[temp];
    		num=num>>>1;
    	}
    	for(int x=pos; x<arr.length; x++){
    		System.out.println(arr[x]);
    	}
    	
    }
    
    //decimal to hex
    public static void toHex(int num){
    	StringBuffer sb = new StringBuffer();
    	for(int x=0; x<8; x++){
    	int temp=num & 15;
    	if (temp>9)
    		//System.out.println((char)(temp-10+'A'));
    		sb.append((char)(temp-10+'A'));
    	else
    		//System.out.println(temp);
    		sb.append(temp);
    	num=num>>>4;
    	}
    	System.out.println(sb.reverse());
    }
    
    //another way of decimal to hex
    public static  void toHex_2(int num){
    	char[] chs={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
    	char[] arr=new char[8];
    	int pos = arr.length-1;
    	while (num!=0){
    		int temp=num & 15;
    		arr[--pos]=chs[temp];
    		num=num>>>4;
    	}
    	for(int x=pos; x<arr.length; x++){
    		System.out.println(arr[x]);
    	}
    }
    
    //function to trans decimal to bin, oct or hex
    public static void trans(int num, int n){
    	if(num==0){
    		System.out.println(0);
    		return; // if num=0, print 0, return the function so, the coding following won't be executed.
    	}
    	char[] chs={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
    	char[] arr=new char[32];
    	int pos = arr.length-1;
    	int base=0, shift=0;
    	switch (n){
    	case 2:
    		base=1; shift=1;
    		break;
    	case 8:
    		base=7; shift=3;
    		break;
    	case 16:
    		base=15; shift=4;
    		break;
    	default:
    		System.out.println("not a valid n");  }
    	
    	while (num!=0){
    		int temp=num & base;
    		arr[--pos]=chs[temp];
    		num=num>>>shift;
    	}
    	for(int x=pos; x<arr.length; x++){
    		System.out.print(arr[x]);
    	}
    	System.out.println();
    }
    
}

// Two dimensional array
class TwoDimensionalArray{
	public static void main(String[] arg){
	int[][] arr= new int[3][2]; // a two-dimensional-array with 3 elements of array, each array has two elements of int data
	arr[2][1]=56;
	
	int[][] arr2= new int[3][];
	arr2[0]= new int[3];
	arr2[1]=new int[1];
	arr2[2]= new int[2];
	
	int[] a,b[]; // equivalent to int[] a; int[] y[]; (int[][] y; int y[][]; or int[] y[];) 
	
	int[][] arr3= {{4,6,8},{7,9,9},{9,80,70,60}};
	int sum=0;
	for(int x=0; x<arr3.length; x++){
		for(int y=0; y<arr3[x].length; y++){
			sum=sum+arr3[x][y];
		}
	}
	
	String[][] arr1= new String[4][4];

	
	}
	
}


