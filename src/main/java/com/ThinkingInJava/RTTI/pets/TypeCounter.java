/**
 * 
 */
package com.ThinkingInJava.RTTI.pets;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fanwei
 *
 */
public class TypeCounter extends HashMap<Class<?>, Integer> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6068150391967442793L;
	private Class<?> baseType;
	
	public TypeCounter(Class<?> type) {
		this.baseType = type;
	}
	
	public void count(Object obj) {
		Class<?> type = obj.getClass();
		if(!baseType.isAssignableFrom(type)) {
			throw new RuntimeException(obj + " incorrect type: " + type + ", should be tye or subtype of " + baseType);
		}
		countClass(type);
	}
	
	private void countClass(Class<?> type) {
		Integer quantity = get(type);
		put(type, quantity == null ? 1 : quantity + 1);
		
		Class<?> superClass = type.getSuperclass();
		
		if(superClass != null && baseType.isAssignableFrom(superClass))
			countClass(superClass);
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder("{");
		for (Map.Entry<Class<?>, Integer> pair : entrySet()) {
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
