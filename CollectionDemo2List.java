package coreJavaDemo;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

public class CollectionDemo2List {
	public static void print(Object obj){
		System.out.println(obj);
	}

	public static void main(String[] args) {
		
		// List has index
		ArrayList al= new ArrayList();
		al.add("aaa");
		al.add("bbbb");
		al.add("ccc");
		al.add("ddd");
		
		print(al);
		al.add(2,"ggggg");  //add element to according to index
		print(al);
		
		al.remove(3); //remove an element 
		print(al);
		
		al.set(2,"fffff");
		print(al);
		
		print(al.get(1));  // get the element on index 1
		
		//get all elements one by one
		for(int x=0; x<al.size(); x++){
			print(al.get(x));    //!!!use get(index), cann't use al[index], because this is used for array only. 
		}
		
		//another way to get all elements, use iterator
		for(Iterator it=al.iterator(); it.hasNext();){
			print(it.next());
		}
		
		//indexOf()
		print(al.indexOf("fffff"));
		
		//subLsit()
		List sub=al.subList(1,3);
		print(sub);
		
		//ListIterator, the following code will throw ConcurrentModificationException
	/*	for(Iterator it=al.iterator(); it.hasNext();){
			Object obj=it.next();
			if(obj.equals("bbbb")){
				al.add("jjjj");
				print(obj);
			}
		} */
		for(Iterator it=al.iterator(); it.hasNext();){
			Object obj=it.next();
			if(obj.equals("bbbb")){
				it.remove();   //iterator can remove elements but can't add, so use ListIterator
				print(obj);
				print(al);
			}
		}
		for(ListIterator li=al.listIterator(); li.hasNext();){
			Object obj=li.next();
			if(obj.equals("ddd")){
				li.set("jjjjjj");   //iterator can remove elements but can't add, so use ListIterator
			}
			print(al);
		}
		
		//vector special method: Enumeration 
		Vector v= new Vector();
		v.add("001");
		v.add("002");
		v.add("003");
		v.add("004");
		
		Enumeration en =v.elements();
		while(en.hasMoreElements()){
			print(en.nextElement());
		}
		
		//The following is to demonstrate class LinkedList
		LinkedList link= new LinkedList();
		link.addFirst("11111");
		link.addFirst("22222");
		link.addFirst("33333");
		link.addFirst("44444");
		print(link);
		print(link.getFirst());
		print(link.getLast());
		print(link.removeFirst());
		print(link);
		
		//get all the elements without iterator, nor for loops
		while(!link.isEmpty()){
			print(link.removeFirst());
		}
		
	}

}
