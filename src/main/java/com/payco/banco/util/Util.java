package com.payco.banco.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Util {
	
	private static final Logger logger = LoggerFactory.getLogger(Util.class);
	  
	  public static void processarData(String data) {
	        if (data != null) {
	            data = data.replaceAll("[\n\r]", "_");
	            logger.info("Data: {} ", data);
	        }
	  }
}