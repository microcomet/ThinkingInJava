/**
 * 
 */
package com.ThinkingInJava.RTTI.pets;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author fanwei
 *
 */
public class PetCount3 {
	static class PetCounter extends LinkedHashMap<Class<? extends Pet>,Integer> {
		/**
		 * 
		 */
		private static final long serialVersionUID = -8897710044051608015L;

		public  PetCounter() {
			for (Class<? extends Pet> type : LiteralPetCreator.allTypes)
				put(type, 0);
		}
		
		public void count(Pet pet) {
			for(Map.Entry<Class<? extends Pet>, Integer> pair :entrySet())
				if( pair.getKey().isInstance(pet)) {
					put(pair.getKey(), pair.getValue() + 1);
				}
		}
		
		public String toString() {
			StringBuilder result  = new StringBuilder("{");
			for(Map.Entry<Class<? extends Pet>, Integer> pair : entrySet()) {
				result.append(pair.getKey().getSimpleName());
				result.append("=");
				result.append(pair.getValue());
				result.append(", ");
			}
			
			result.delete(result.length() - 2, result.length());
			result.append("}");
			return result.toString();
		}
	}
	
	public static void main(String[] args) {
		PetCounter petCount = new PetCounter();
		for(Pet pet : Pets.createArray(20)) {
			System.out.println(pet.getClass().getSimpleName() + " ");
			petCount.count(pet);
		}
		
		System.out.println(petCount);
	}
}
