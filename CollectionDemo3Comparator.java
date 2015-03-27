package coreJavaDemo;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

class Client implements Comparable{
	private String name;
	private int age;
	Client(String name, int age){
		this.name=name;
		this.age=age;
	}
	public int compareTo(Object obj){  //implement Comparable to let the Worker compare age and name to be sorted
		if(obj instanceof Client){
			Client e=(Client)obj;
			if (this.age>e.age)
				return 1;
			else if(this.age==e.age)
				return this.name.compareTo(e.name);
			return -1;
		}
		throw new RuntimeException("This is not a Human being");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}


// define a comparator comparing the length of String.
class CompareString implements Comparator {
	public int compare(Object obj1, Object obj2){
		String s1=(String)obj1;
		String s2=(String)obj2;
		int num= s1.length()-s2.length();
		if (num==0)
			return s1.compareTo(s2);   //if length the same, then compare alphabetically, otherwise the second element with same length won't be added into the TreeSet
		return num;
	}
}


public class CollectionDemo3Comparator {
	public static void print(Object obj){
		System.out.println(obj);
	}

	public static void main(String[] args) {
		//Use class CompareString, sort the elements according to its length
		TreeSet t=new TreeSet(new CompareString());
		t.add("aa");
		t.add("d");
		t.add("bbbb");
		t.add("ee");
		t.add("fff");
		for(Iterator it=t.iterator();it.hasNext();){
			print(it.next());
		}
		
		//define anonymous nested class as comparator to compare class of Client
		TreeSet ts=new TreeSet(new Comparator(){
			public int compare(Object obj1, Object obj2){
				Client c1=(Client)obj1;
				Client c2=(Client)obj2;
				int n= c1.getName().compareTo(c2.getName());
				if (n==0)
					return c1.getAge()-c2.getAge();
				return n;
			}
		});
		
		ts.add(new Client("aab",44));
		ts.add(new Client("aa",34));
		ts.add(new Client("aab",33));
		ts.add(new Client("bbb",22));
		ts.add(new Client("aab",44));
		for (Iterator it=ts.iterator();it.hasNext();){
			Client c=(Client)it.next();
			print(c.getName()+"...."+c.getAge());
		}
		
	}

}
