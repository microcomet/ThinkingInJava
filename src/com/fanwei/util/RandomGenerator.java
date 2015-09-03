/**
 * 
 */
package com.fanwei.util;

import java.util.Random;

/**
 * @author fanwei
 * @param <T>
 *
 */
public class RandomGenerator {

	private Random rand= new Random();

	public Generator<String> String(int len) {
		// TODO Auto-generated method stub
		return new Generator<String>() {

			@Override
			public java.lang.String next() {
				// TODO Auto-generated method stub
				StringBuffer strBuf = new StringBuffer(len + 1);
				int i = 0;
				while(i < len)
				{
					int tmp = rand.nextInt('z');
					if(('a'<= tmp && tmp <= 'z') || ('A' <= tmp && tmp <= 'Z')){
						strBuf.append((char)tmp);
						i++;
					}
				}
					
				return strBuf.toString();
			}
			
		};
	}
	
	public Generator<Integer> Integer() {
		return new Generator<Integer>() {

			@Override
			public java.lang.Integer next() {
				// TODO Auto-generated method stub
				return rand.nextInt(10000);
			}
			
		};
	}

}
