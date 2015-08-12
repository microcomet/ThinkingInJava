/**
 * 
 */
package com.fanwei.RTTI.pets;

/**
 * @author fanwei
 *
 */
public class PetCount4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TypeCounter counter = new TypeCounter(Pet.class);
		for (Pet pet : Pets.createArray(20)) {
			System.out.println(pet.getClass().getSimpleName());
			counter.count(pet);
		}
		System.out.println(counter);
	}

}
