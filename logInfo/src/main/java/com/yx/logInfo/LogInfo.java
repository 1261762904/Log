package com.yx.logInfo;

import java.io.IOException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;
import org.apache.log4j.varia.LevelRangeFilter;


public class LogInfo extends Logger{
	protected Logger logProxy ;

	protected String  logFilePath;
	
	protected String fileName;
	
	private static String DEFAULT_FILE = "defaultLog";
	
	private static final String COVERSION_PATTERN ="[%t %l %d{yyy MMM dd HH:mm:ss}]%m%n";

	private static final String MAX_FILESIZE ="10MB";
	
	private static final int MAX_BACKUPINDEX=3;
	
	private static final String SEPARATOR = "/";
	
	protected LogInfo(String name) {
		 super(name);
		 initPath();
		 init();
	}
	
	private void init(){
		logProxy = Logger.getLogger(name);
		logProxy.addAppender(getAppender());
	}

	private boolean isEmpty(String str){
		return str==null||str.trim().equals("");
	}

	private Level getMaxLevel(){
		return Level.ERROR;
	}	
	
	private Level getMinLevel(){
		return Level.INFO;
	}	
	
	private void  initPath(){
		String baseDir = "D:";
		if (isEmpty(baseDir)) {
			throw new IllegalArgumentException("cannot be empty");
		}
		String logDir= baseDir + SEPARATOR + "logs";
		if (isEmpty(name)) {
			this.fileName = DEFAULT_FILE;
		}else{
			this.fileName=name;
		}
		this.logFilePath = logDir + SEPARATOR + fileName + ".log";
	}
	
	private RollingFileAppender getAppender(){
		RollingFileAppender appender = null;
			try {
				appender = new RollingFileAppender(new PatternLayout(COVERSION_PATTERN), logFilePath);
				appender.setMaxFileSize(MAX_FILESIZE);
				appender.setMaxBackupIndex(MAX_BACKUPINDEX);
				appender.setAppend(true);
				appender.setThreshold(getMinLevel());
				LevelRangeFilter filterInfo = new LevelRangeFilter();
				filterInfo.setLevelMin(getMinLevel());
				filterInfo.setLevelMax(getMaxLevel());
				appender.addFilter(filterInfo);
			} catch (IOException e) {
				new Exception(e.getMessage());
			}
			return appender;
	}
	
	public void error(Object message) {
		logProxy.error(message);
	}

	public void error(Object message, Throwable t) {
		logProxy.error(message, t);
	}

	public void info(Object message) {
		logProxy.info(message);
	}

	public void info(Object message, Throwable t) {
		logProxy.info(message, t);
	}
}
