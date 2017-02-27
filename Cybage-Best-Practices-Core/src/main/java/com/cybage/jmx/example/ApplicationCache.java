package com.cybage.jmx.example;

import java.util.ArrayList;
import java.util.List;

public class ApplicationCache implements ApplicationCacheMBean{
 
	private int maxCacheSize = 100;
	private List cache = new ArrayList();
	
	public synchronized void clearCache() {
		cache.clear();		
	}
	
	public synchronized int getCachedObjects() {
		return cache.size();
	}
	public synchronized int getMaxCacheSize() {
		return maxCacheSize;
	}
	public synchronized void setMaxCacheSize(int value) {
		if(value < 1) {
			throw new IllegalArgumentException("Value must be >= 1");
		}
		maxCacheSize = value;
	}
	
	public synchronized void cacheObject(Object o) {
		
/*		if(cache.size() == 10){
			for(int i=1 ; i<5; i++){
				cache.remove(i);
				System.out.println("removed");
			}
		}*/
		if(cache.size() != 0){
			System.out.println("Cache Size:"+cache.size());			
		}

		while(cache.size() >= maxCacheSize) {
			cache.remove(0);
			System.out.println("removed in while");
		}
		cache.add(o);
	}
}