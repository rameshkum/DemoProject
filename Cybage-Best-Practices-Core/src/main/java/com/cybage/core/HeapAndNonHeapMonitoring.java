package com.cybage.core;
import java.io.IOException;
import java.util.Hashtable;

import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.openmbean.CompositeDataSupport;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
 
public class HeapAndNonHeapMonitoring
{
private static MBeanServerConnection connection;
private static JMXConnector connector;
	public static void Connection(String hostname, String port) throws IOException{
		Integer portInteger = Integer.valueOf(port);
		Hashtable h = new Hashtable();
		JMXServiceURL address = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://"+hostname+":"+port+"/jmxrmi");
		connector = JMXConnectorFactory.connect(address,null);
		connection = connector.getMBeanServerConnection();
		System.out.println("GOT THE MBeanServerConnection---SUCCESSFULLY");
	}
 
	private static void doGarbageCollection() throws Exception{
		ObjectName memoryMXBean=new ObjectName("java.lang:type=Memory");
		connection.invoke(memoryMXBean,"gc", null, null);
		System.out.println("nnt------Garbage Collection Done Successfully-----");
	}
 
	private static void doOperatingSystemDetails() throws Exception{
		ObjectName operatingSystemMXBean=new ObjectName("java.lang:type=OperatingSystem");
		Object systemLoadAverage = connection.getAttribute(operatingSystemMXBean, "SystemLoadAverage");
		Long freePhysicalMemory = (Long) connection.getAttribute(operatingSystemMXBean, "FreePhysicalMemorySize");
		Long processCpuTime = (Long) connection.getAttribute(operatingSystemMXBean, "ProcessCpuTime");
		 
		Long committedVirtualMemorySize = (Long) connection.getAttribute(operatingSystemMXBean, "CommittedVirtualMemorySize");
		Long freeSwapSpaceSize = (Long) connection.getAttribute(operatingSystemMXBean, "FreeSwapSpaceSize");
		Long totalPhysicalMemorySize = (Long) connection.getAttribute(operatingSystemMXBean, "TotalPhysicalMemorySize");
		Long totalSwapSpaceSize = (Long) connection.getAttribute(operatingSystemMXBean, "TotalSwapSpaceSize");
		System.out.println("Operating SystemLoadAverage: " + systemLoadAverage);
		System.out.println("Operating System FreePhysicalMemory: " + (freePhysicalMemory/(1024*1024))+"-MB");
		System.out.println("Operating System processCpuTime: " + processCpuTime);
		System.out.println("Operating System committedVirtualMemorySize: " + (committedVirtualMemorySize/(1024*1024))+"-MB");
		System.out.println("Operating System freeSwapSpaceSize: " + (freeSwapSpaceSize/(1024*1024))+"-MB");
		System.out.println("Operating System totalPhysicalMemorySize: " + (totalPhysicalMemorySize/(1024*1024))+"-MB");
		System.out.println("Operating System totalSwapSpaceSize: " + (totalSwapSpaceSize/(1024*1024))+"-MB");
	}
 
	private static void getHeapMemoryUsage() throws Exception{
		ObjectName memoryMXBean=new ObjectName("java.lang:type=Memory");
		CompositeDataSupport dataSenders = (CompositeDataSupport) connection.getAttribute(memoryMXBean,"HeapMemoryUsage");
			if (dataSenders != null){
				Long commited = (Long) dataSenders.get("committed");
				Long init = (Long) dataSenders.get("init");
				Long max = (Long) dataSenders.get("max");
				Long used = (Long) dataSenders.get("used");
				Long percentage = ((used * 100) / max);
				System.out.println("nnt commited   : "+commited/(1024*1024)+" MB");
				System.out.println("t init       : "+init/(1024*1024)+" MB");
				System.out.println("t max        : "+max/(1024*1024)+" MB");
				System.out.println("t used       : "+used/(1024*1024)+" MB");
				System.out.println("t percentage : "+percentage +" %");
			}
	}
 
	private static void getNonHeapMemoryUsage() throws Exception{
		ObjectName memoryMXBean=new ObjectName("java.lang:type=Memory");
		CompositeDataSupport dataSenders = (CompositeDataSupport) connection.getAttribute(memoryMXBean,"NonHeapMemoryUsage");
			if (dataSenders != null){
				Long commited = (Long) dataSenders.get("committed");
				Long init = (Long) dataSenders.get("init");
				Long max = (Long) dataSenders.get("max");
				Long used = (Long) dataSenders.get("used");
				Long percentage = ((used * 100) / max);
				System.out.println("\t commited   : "+commited/(1024*1024)+" MB");
				System.out.println("\t init       : "+init/(1024*1024)+" MB");
				System.out.println("\t max        : "+max/(1024*1024)+" MB");
				System.out.println("\t used       : "+used/(1024*1024)+" MB");
				System.out.println("\t percentage : "+percentage +" %");
			}
	}
 
	public static void main(String[] args) throws Exception{
		String hostname = args[0];
		String port = args[1];
		Connection(hostname, port);
		//doGarbageCollection();                // -->; use this method if you want to perform Garbage Collection
		System.out.println("nt----------HEAP Memory Usages---------");
		getHeapMemoryUsage();
		System.out.println("nt----------Non-HEAP Memory Usages---------");
		getNonHeapMemoryUsage();
		System.out.println("nt----------Operating System Usages---------");
		doOperatingSystemDetails();
		connector.close();
	}
}