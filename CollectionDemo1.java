package coreJavaDemo;

import java.util.*;

public class CollectionDemo1 {
	public static void print(Object obj){
		System.out.println(obj);
	}

	public static void main(String[] args) {
		// use sub-class of Collection, to create an object of Collection
		ArrayList al = new ArrayList();
		
		//add elements
		al.add("java01");
		al.add("java02");
		al.add("java03");
		al.add("java05");
		
		//get the size of this collection
		print(al.size());
		print(al);
		
		//delete elements
		al.remove(0);
		print(al);
		al.remove("java03");
		print(al);
		
		//contains elements?
		print(al.contains("java05"));
		print(al.isEmpty());
		
		
		//retainAll()
		ArrayList al2=new ArrayList();
		al2.add("java05");
		al2.add("java07");
		al2.add("java08");
		al2.add("java09");
		
		print(al.retainAll(al2));
		print(al);
		print(al2);
		
		//how to get the elements in a collection, use iterator, Iterator is an Interface
		Iterator it=al2.iterator();
		while(it.hasNext()){
			print(it.next());
		}
		
		//anther way of use iterator
		for(Iterator it2=al2.iterator();it2.hasNext();){
			print(it2.next());
		}
		
		
	}

}
