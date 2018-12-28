package com.yx.logInfo;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
			int a =1/0;
		} catch (Exception e) {
			LogUtil.getLogger("yixin").info("test",e);
		}
    }
}
