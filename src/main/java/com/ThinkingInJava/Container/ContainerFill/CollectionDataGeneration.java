/**
 * 
 */
package com.ThinkingInJava.Container.ContainerFill;

import java.util.ArrayList;

import com.ThinkingInJava.util.RandomGenerator;

/**
 * @author fanwei
 *
 */
public class CollectionDataGeneration {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ArrayList<String>(new CollectionData<String>(new RandomGenerator().String(9),10)));
		System.out.println(new ArrayList<Integer>(new CollectionData<Integer>(new RandomGenerator().Integer(),10)));
	}

}
