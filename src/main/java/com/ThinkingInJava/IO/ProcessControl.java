/**
 * Copyright  2016 Clean-Read's Studio
 * 
 * All right reserved.
 * 
 * Created by fanwei on 2016年1月13日 上午12:20:48.
 */

package com.ThinkingInJava.IO;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author fanwei
 *
 */
public class ProcessControl {
	public static void command(String command){
		boolean err = false;
		try {
			Process process = new ProcessBuilder(command.split(" ")).start();
			BufferedReader results = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String s;
			while((s = results.readLine()) != null) {
				System.out.println(s);
			}
			
			BufferedReader errors = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			while((s = errors.readLine()) != null){
				System.out.println(s);
				err = true;
			}
		} catch (Exception e) {
			if(!command.startsWith("CMD /C")) {
				command("CMD /C" + command);
			} else {
				throw new RuntimeException();
			}
			e.printStackTrace();
		}
		
		if(err){
			throw new OSExcuteException("Errors executing " + command);
		}
	}
}
