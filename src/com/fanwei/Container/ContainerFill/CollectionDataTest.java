/**
 * 
 */
package com.fanwei.Container.ContainerFill;

import java.util.LinkedHashSet;
import java.util.Set;

import com.fanwei.util.Generator;

/**
 * @author fanwei
 *
 */
class Government implements Generator<String>{

	String[] foundation = ("strange women lying in ponds" +
						  " distributing swords is no basis or a system of " +
			              "government").split(" ");
	private int index;
	
	@Override
	public String next() {
		// TODO Auto-generated method stub
		return foundation[index++];
	}
	
}
public class CollectionDataTest {
	public static void main(String[] args) {
		Set<String> set = new LinkedHashSet<String>(new CollectionData<String>(new Government(),15));
		System.out.println(set);
		set.addAll(CollectionData.list(new Government(), 15));
		System.out.println(set);
	}
}