/**
 * 
 */
package com.fanwei.MutiThread;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author fanwei
 *
 */

class SeperatorSubTask extends Thread {
	
	private int count = 0;
	private Counter2 c2;
	private boolean runFlag = true;
	public SeperatorSubTask(Counter2 c2) {
		this.c2 = c2;
		start();
		return;
	}
	
	public void invertFlag() {
		runFlag = !runFlag;
		return;
	}
	
	public void run(){
		while(true) {
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(runFlag)
				c2.t.setText(String.valueOf(++count));
		}
	}
}

public class Counter2 extends Applet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3719336668586412664L;
	TextField t = new TextField(10);
	private Button start = new Button("Start");
	private Button onOff = new Button("Toggle");
	private SeperatorSubTask sp = null;
	
	public void init() {
		add(t);
		add(start);
		add(onOff);
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(sp == null)
					sp = new SeperatorSubTask(Counter2.this);
				else 
					System.out.println("all ready started.");
			}
			
		});
		onOff.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(sp != null)
					sp.invertFlag();
			}
			
		});
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Counter2 applet = new Counter2();
		
		Frame frame = new Frame("Counter2");
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.out.println("end.");
				System.exit(0);
			}
		});
		
		frame.add(applet, BorderLayout.CENTER);
		frame.setSize(300, 200);
		applet.init();
		applet.start();
		frame.setVisible(true);
	}

}
