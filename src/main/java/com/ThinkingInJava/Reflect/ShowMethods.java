package com.ThinkingInJava.Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

public class ShowMethods {

	private static String usage = 
			"usage : \n" +
			"ShowMethods qualified.class.name\n" +
			"To show all methods in class or: \n" +
			"ShowMethods qualified.class.name word\n" +
			"To Search for methos involving 'word'";
	private static Pattern p = Pattern.compile("\\w+\\.");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length < 1) {
			System.out.println(usage);
			System.exit(0);
		}
		
		int lines = 0;
		
		try {
			Class<?> c = Class.forName(args[0]);
			Method[] methods = c.getMethods();
			@SuppressWarnings("rawtypes")
			Constructor[] ctors = c.getConstructors();
			
			if(args.length == 1) {
				for (Method method : methods) {
					System.out.println(p.matcher(method.toString()).replaceAll(""));
				}
				
				for (@SuppressWarnings("rawtypes") Constructor ctor : ctors) {
					System.out.println(p.matcher(ctor.toString()).replaceAll(""));
				}
			} else {
				for (Method method : methods) {
					if (method.toString().indexOf(args[1]) != -1) {
					    System.out.println(p.matcher(method.toString()).replaceAll(""));
					    lines++;
					}
				}
				
				for (@SuppressWarnings("rawtypes") Constructor ctor : ctors) {
					if (ctor.toString().indexOf(args[1]) != -1) {
						System.out.println(p.matcher(ctor.toString()).replaceAll(""));
						lines++;
					}
				}
			}
			System.out.println("Total Line is :" + lines);
		} catch (ClassNotFoundException e) {
			System.out.println("No such class:" + e);
		}
		
	}

}
