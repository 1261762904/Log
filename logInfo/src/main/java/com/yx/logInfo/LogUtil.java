package com.yx.logInfo;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class LogUtil{
	private static final Map<String, Logger> logMap = new HashMap<String, Logger>();

	public final static String DEFAULT_FILE = "defaultLog";

	public static Logger getLogger() {
		return getLogger(DEFAULT_FILE);
	}

	public static Logger getLogger(String name) {
		Logger cacheLog = logMap.get(name);
		if (cacheLog != null)
			return cacheLog;
		cacheLog = get(name);
		logMap.put(name, cacheLog);
		return cacheLog;
	}

	private static Logger get(String name) {
		return new OutLogInfo(name);
	}

}
