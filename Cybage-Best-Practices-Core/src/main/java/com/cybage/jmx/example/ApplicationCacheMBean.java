package com.cybage.jmx.example;
public interface ApplicationCacheMBean {
	
	int getMaxCacheSize();
	void setMaxCacheSize(int value);
	int getCachedObjects();
	void clearCache();
	
}