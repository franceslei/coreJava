package coreJavaDemo;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class IoDemo6 {
	public static void print(Object obj){
		System.out.println(obj);
	}

	public static void main(String[] args) throws IOException {
		
		File f1= new File("a.txt");
		print(f1.isDirectory());
		print(f1.isFile());
		print("path: "+f1.getPath());
		print("abspath: "+f1.getAbsolutePath());
		print("parent: "+f1.getParent()); //return the parent directory in the abspath, if it was relative path, return null.
		
		File f2= new File("c:\\aaaa","a.txt");
		
		File f= new File("c:\\abc");
		File f3= new File(f,"c.txt");
		
		print("f1: "+f1);
		print("f2: "+f2);
		print("f3: "+f3);
		
		boolean create= f1.createNewFile();
		f1.deleteOnExit();
		print(create);
		
		f1.delete();
		
		File file= new File("file.txt");
		//  print(file.canExecute());
		print(file.exists());
		
		File ff= new File("a\\b\\v\\bb");
		ff.mkdirs();
		
		//listRoots()
		File[] files=File.listRoots();
		for(File fi: files){
			print(fi);
		}
		
		File fff= new File("c:\\");
		String[] names=fff.list();
		for(String name: names){
			print(name);
		}
		String[] names1=fff.list(new FilenameFilter(){   //use anonymous nested class, because FilenameFilter is an interface and has only one method.
			public boolean accept(File dir, String name){
				return name.endsWith(".java");
			}
		});
		for(String name: names1){
			print(name);
		}
		
		
		//listFiles()
		File dir=new File("c:\\");
		File[] allfile=dir.listFiles();
		for(File eachfile: allfile){
			print(eachfile.getName()+"::"+eachfile.length());
		}
		//get all files under each directory
			File afile=new File("c:\\users\\NIBS");
			showDir(afile);
		
	}
	public static void showDir(File file){  //recursion
		print(file);
		File[] files=file.listFiles();
			for(int x=0; x<files.length;x++){
				if(files[x].isDirectory())
					showDir(files[x]);
				else
					print(files[x]);
			}
	}

}
