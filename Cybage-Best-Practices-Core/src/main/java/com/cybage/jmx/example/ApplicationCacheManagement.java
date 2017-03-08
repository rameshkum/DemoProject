package com.cybage.jmx.example;
import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;
 
public class ApplicationCacheManagement {
	public static void main(String[] args) throws Exception {
		ApplicationCache cache = new ApplicationCache();
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		ObjectName name = new ObjectName("com.cybage.jmx.example:type=ApplicationCacheMBean");
		mbs.registerMBean(cache, name);
		Thread t1 = new Thread(){ public void run(){
			System.out.println("Deamon thread called");
			while(true) {
				try {
					Thread.sleep(1000);
				}
				catch(InterruptedException e) { }
			}
		}};
		Thread t2 = new Thread(){ public void run(){
			System.out.println("Deamon thread called");
			while(true) {
				try {
					Thread.sleep(1000);
				}
				catch(InterruptedException e) { }
			}
		}};
		Thread t3 = new Thread(){ public void run(){
			System.out.println("Deamon thread called");
			while(true) {
				try {
					Thread.sleep(1000);
				}
				catch(InterruptedException e) { }
			}
		}};
		Thread t4 = new Thread(){ public void run(){
			System.out.println("Deamon thread called");
			while(true) {
				try {
					Thread.sleep(1000);
				}
				catch(InterruptedException e) { }
			}
		}};
		t1.setDaemon(true);
		t2.setDaemon(true);
		t3.setDaemon(true);
		t4.setDaemon(true);
		t1.setName("Thread-1-Cybage");
		t2.setName("Thread-2-Software");
		t3.setName("Thread-3-Private");
		t4.setName("Thread-4-Limited");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		imitateActivity(cache);
		
	}
	private static void imitateActivity(ApplicationCache cache) {
		int i = 1;
		while(true) {
			try {
				cache.cacheObject(new Object());
				System.out.println("Cached the new objects: "+ (i++));
				Thread.sleep(1000);
			}
			catch(InterruptedException e) { }
		}
	}
}