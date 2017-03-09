package com.cybage.jmx;

import java.lang.management.ManagementFactory;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

public class SystemConfigManagement {
    private static  int DEFAULT_NO_THREADS=10;
    private static  String DEFAULT_SCHEMA="default";

    public static void main(String[] args) throws MalformedObjectNameException, InterruptedException, InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException {
        //Get the MBean server
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        //register the MBean
        SystemConfig mBean = new SystemConfig(DEFAULT_NO_THREADS, DEFAULT_SCHEMA);
        ObjectName name = new ObjectName("com.cybage.jmx:type=SystemConfig");
        mbs.registerMBean(mBean, name);
        do{
        	
/*        	DEFAULT_NO_THREADS++;*/        	
            Thread.sleep(3000);
/*            System.out.println("Thread Count="+mBean.getThreadCount()+":::Schema Name="+mBean.getSchemaName());*/
            System.out.println("Thread Count="+	(DEFAULT_NO_THREADS++) +":::Schema Name="+mBean.getSchemaName());
        }while(mBean.getThreadCount() !=0);
        
    }

}