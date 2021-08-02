package com.runner.jar

import java.lang.*;
import java.io.*;
import com.parasoft.api.*;

class JarDriver {
	public JarDriver() {
		
	}
	
	public static void runJar() {
		Process process;
		try {
			Runtime.getRuntime().exec("java -jar src/com/runner/jar/ScriptRunner.jar");
			
			StringBuilder buf = new StringBuilder();
			InputStream is = process.getInputStream();
			int i = 0;
			while ((i = is.read()) != -1) {
				buf.append((char) i);
			}
			process.waitFor();
			//Application.showMessage(buf.toString());
			println(buf.toString());
		} finally {
			closeStreams(process);
		}
		
	}
	
	public static void closeStreams(Process process) {
		if (process != null) {
			try {
				process.getInputStream().close();
			} catch (IOException e) {
			}
			try {
				process.getErrorStream().close();
			} catch (IOException e) {
			}
			try {
				process.getOutputStream().close();
			} catch (IOException e) {
			}
		}
	}
	
	public static void main(String[] args) {

	}
}
