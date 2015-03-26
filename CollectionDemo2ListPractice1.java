package coreJavaDemo;

import java.util.LinkedList;


//practice: use LinkedList to emulate a stack or queue 
//stack: first in last out;  queue: First in first out

class Queue{
	private LinkedList link;
	Queue(){
		link= new LinkedList();
	}
	public void myAdd(Object obj){
		link.addFirst(obj);
	}
	public Object myGet(){
		return link.removeLast();   //replace with removeFirst() here to get stack 
		
	}
	public boolean isNull(){
		return link.isEmpty();
	}
}

public class CollectionDemo2ListPractice1 {
	public static void print(Object obj){
		System.out.println(obj);
	}

	public static void main(String[] args) {
		Queue q=new Queue();
		q.myAdd("aa");
		q.myAdd("bb");
		q.myAdd("cc");
		q.myAdd("dd");
		
		while(!q.isNull()){
		print(q.myGet());
		}
	}

}
