package coreJavaDemo;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@MyAnnotation(name="fang", age=35, names={"lisa","frances"})  //to use the annotation, has to specify values for all elements 
public class CreateAnnotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

@Inherited   //this annotation will be inherited by the subclass of the superclass which use this annotation. 
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation{    //this signals the java compiler that this is a Java annotation definition. 
	String name();
	String nickName() default ""; 
	int age();
	String[] names();
	//all primitive data type and arrays can be used to define elements here. objects can't be used as data type. 
}

