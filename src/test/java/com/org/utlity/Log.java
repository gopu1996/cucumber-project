package com.org.utlity;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

public class Log {

	public static void LogFunc(Logger log) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
		SimpleLayout layout = new SimpleLayout();
		try {

			FileAppender append = new FileAppender(layout, "log\\" + format.format(new Date()) + ".log", true);
			log.addAppender(append);
		} catch (IOException e) {
			log.error(log);

		}
	}

	public static void info(String message, Logger log) {
		log.info(message);
	}

	public static void warn(String message, Logger log) {
		log.warn(message);
	}

	public static void error(String message, Logger log) {
		log.error(message);
	}

	public static void fatal(String message, Logger log) {
		log.fatal(message);
	}

	public static void debug(String message, Logger log) {
		log.debug(message);
	}

	public static Logger logg(@SuppressWarnings("rawtypes") Class Classname) {
		Logger log = Logger.getLogger(Classname);
		return log;
	}
}
