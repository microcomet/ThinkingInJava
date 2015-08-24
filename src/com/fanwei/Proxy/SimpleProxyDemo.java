/**
 * 
 */
package com.fanwei.Proxy;

/**
 * @author fanwei
 *
 */

interface Interface {
	void doSomething();
	void somethingElse(String arg);
}

class RealObject implements Interface {

	@Override
	public void doSomething() {
		// TODO Auto-generated method stub
		System.out.println("do somthing.");
	}

	@Override
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
	
	@Override
	public void doSomething() {
		// TODO Auto-generated method stub
		System.out.println("SimpleProxy do something.");
		proxied.doSomething();
	}

	@Override
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
