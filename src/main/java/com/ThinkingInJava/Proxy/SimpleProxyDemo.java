/**
 * 
 */
package com.ThinkingInJava.Proxy;

/**
 * @author fanwei
 *
 */

interface Interface {
	void doSomething();
	void somethingElse(String arg);
}

class RealObject implements Interface {

	public void doSomething() {
		// TODO Auto-generated method stub
		System.out.println("do somthing.");
	}

	public void somethingElse(String arg) {
		// TODO Auto-generated method stub
		System.out.println("something Else " + arg);
	}
}

class SimpleProxy implements Interface {

	private Interface proxied ;
	public SimpleProxy(Interface proxied) {
		this.proxied = proxied;
	}
	
	public void doSomething() {
		// TODO Auto-generated method stub
		System.out.println("SimpleProxy do something.");
		proxied.doSomething();
	}

	public void somethingElse(String arg) {
		// TODO Auto-generated method stub
		System.out.println("SimpleProxy something Else.");
		proxied.somethingElse(arg);
	}
	
}

public class SimpleProxyDemo {

	public static void consumer(Interface iface) {
		iface.doSomething();
		iface.somethingElse("bonobo");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		consumer(new RealObject());
		consumer(new SimpleProxy(new RealObject()));
	}

}
