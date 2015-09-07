/**
 * 
 */
package com.fanwei.MutiThread;

/**
 * @author fanwei
 *
 */
public class SimpleThread extends Thread {

	private int countDown = 20;
	private static int threadNum = 0;
	public SimpleThread() {
		this.setName("Thread" + (++threadNum));
		System.out.println("Making " + this.getName());
	}
	public void run() {
		while(true) {
			System.out.println(this.getName() + "(" + countDown + ")");
			if(--countDown == 0)
				return;
			if(countDown%5 == 0)
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0; i < 5; i++) {
			new SimpleThread().start();
		}
		System.out.println("All Thread started.");
	}

}
