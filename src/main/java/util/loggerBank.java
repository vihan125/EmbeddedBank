package util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class loggerBank {

    private static 	Logger logger;				

    private loggerBank() {

    }

    public static Logger getInstance(String className) throws ClassNotFoundException,IllegalAccessException{
    	Class<?> classTemp = Class.forName(className);
        if (logger == null)	
        	logger = LoggerFactory.getLogger( classTemp.getClass());
        return logger;
    }

  
}