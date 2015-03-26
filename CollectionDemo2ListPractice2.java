package coreJavaDemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


//remove duplicate elements in ArrayList
public class CollectionDemo2ListPractice2 {
	public static void print(Object obj){
		System.out.println(obj);
	}
	
	public static List singleElement(ArrayList al){
		//define a temp arraylist
		ArrayList temp = new ArrayList();
		for(Iterator it=al.iterator(); it.hasNext();){
			Object obj=it.next();
			if(!temp.contains(obj)){
				temp.add(obj);
			}
		}
		return temp;
	}

	public static void main(String[] args) {
		ArrayList al=new ArrayList();
		al.add("01");
		al.add("02");
		al.add("01");
		al.add("02");
		al.add("03");
		al.add("01");
		
		print(al);
		List l=singleElement(al);
		print(l);
		

	}

}
