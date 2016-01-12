package com.ThinkingInJava.RTTI.pets;

public class Individual {
	private String name;
	
	public Individual()
	{}
	public Individual(String name)
	{
		this.name  =  name;
	}
	public String toStirng()
	{
		return name;
	}
}