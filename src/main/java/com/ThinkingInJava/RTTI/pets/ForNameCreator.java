/**
 * 
 */
package com.ThinkingInJava.RTTI.pets;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fanwei
 *
 */
public class ForNameCreator extends PetCreator {

	private static List<Class<? extends Pet>> types = new ArrayList<Class<? extends Pet>>();
	
	private static String[] typeNames = {
		"com.fanwei.RTTI.pets.Mutt",
		"com.fanwei.RTTI.pets.Pug",
		"com.fanwei.RTTI.pets.EgyptianMau",
		"com.fanwei.RTTI.pets.Manx",
		"com.fanwei.RTTI.pets.Cymric",
		"com.fanwei.RTTI.pets.Rat",
		"com.fanwei.RTTI.pets.Mouse",
		"com.fanwei.RTTI.pets.Hamster"
	};
	
	@SuppressWarnings("unchecked")
	private static void loader() {
		try {
			for(String name : typeNames) {
				types.add((Class<? extends Pet>)Class.forName(name));
			}
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	static { loader(); }
	
	/* (non-Javadoc)
	 * @see com.fanwei.RTTI.pets.PetCreator#types()
	 */
	@Override
	public List<Class<? extends Pet>> types() {
		// TODO Auto-generated method stub
		return types;
	}

}
