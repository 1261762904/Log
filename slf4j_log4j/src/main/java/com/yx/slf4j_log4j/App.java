package com.yx.slf4j_log4j;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Hello world!
 *
 */
public class App 
{
	public static void test(int i) {
		try {
			String name = "test";
	        PropertiesConfiguration config  = new PropertiesConfiguration("src/main/java/log4j.properties");
            config.setAutoSave(true);
            config.setProperty("log4j.appender.file.File", "log/"+name+".log");
	    	Logger log = LoggerFactory.getLogger("c");
			try {
				int z = 0;
				int y = i/z;
			} catch (Exception e) {
		    	log.info("log test",e);
			}
		} catch (ConfigurationException e1) {
			e1.printStackTrace();
		}
		
	}
    public static void main( String[] args )
    {
   		test(0);
    }
}
