package com.cybage.core;

public class CybThread extends Thread{
	
	public void run(){
		for(int i=0; i<10 ; i++){
			System.out.println("In CybThread : "+i);
			/*System.exit(0);*/
		}
	}

	/**
	 * Command line arguments
	 * @param args arguments pass through the command prompt
	 */
	
	public static void main(String[] args) {
		System.out.println("JVM call starts");
		
		CybThread cybThread = new CybThread();
	//	cybThread.setDaemon(true); //before thread starts we need to set the Daemon nature to a thread otherwise we will run into the exceptions
		cybThread.start();
/*		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		*/
		for(int i=0; i<10 ; i++){
			System.out.println("In main thread:"+i);
		}
		
		
		
		if(cybThread.isDaemon()){
			System.out.println("CybThread is a Deamon Thread");
		}
		
/*		cybThread.run();*/
/*		cybThread.start();*/
	}

}
