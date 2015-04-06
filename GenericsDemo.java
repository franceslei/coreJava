package coreJavaDemo;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class GenericsDemo {
	public static void print(Object obj){
		System.out.println(obj);
	}
	// generic  <? extends E> means operate all sub-class of E
	public static void printCollection(TreeSet<?> ts){   //Iterator for any type of data
		for(Iterator<?> it = ts.iterator();it.hasNext();){
			System.out.println(it.next());
		}
	}
	public static void main(String[] args) {
		TreeSet<String> ts = new TreeSet<String>(new lenComparator());
		ts.add("aaaaa");
		ts.add("ggggg");
		ts.add("ccccc");
		ts.add("fff");
		ts.add("eeeeee");
		
		TreeSet<Integer> ts2=new TreeSet<Integer>();
		ts2.add(5);
		ts2.add(8);
		ts2.add(9);
		
		for(Iterator<String> it = ts.iterator(); it.hasNext();){
			print(it.next());
		}
		printCollection(ts);
		printCollection(ts2);
		
		DDemo d=new DDemo();
		d.show("aaa");
		d.show(4);
		DDemo.print("bb");
		DDemo.print(5);
	}

}
class lenComparator implements Comparator<String>{
	public int compare(String s1, String s2){
		int num=new Integer(s1.length()).compareTo(new Integer(s2.length()));
		if (num==0)
			return s1.compareTo(s2);
		return num;
	}
}

//declare a class with Generics, which is valid within this class, when declare a type, all methods will be fixed
class Utils<T>{
	private T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	
}

// declare generics in methods, is more flexible 
class DDemo{
	public<T> void show(T t){
		System.out.println("show: "+t);
	}
	public static <Q> void print(Q q){
		System.out.println("print: "+q);
	}
}

/*
class DDemo<T>{
	public void show(T t){
		System.out.println("show: "+t);
	}
	public <Q> void print(Q q){
		System.out.println("print: "+q);
	}
}
*/

/*     //interface with Generics
interface Inter<T>{
void print(T t);
}

class InterImpl<T> implements Inter<T>{
public void print(T t){
System.out.println(t);

*/