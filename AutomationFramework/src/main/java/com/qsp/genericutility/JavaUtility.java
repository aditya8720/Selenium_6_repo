package com.qsp.genericutility;

import java.time.LocalDateTime;
/**
 * this method will capture the real time or system time
 */
public class JavaUtility {
	public String getSystemTime() {
		return LocalDateTime.now().toString().replace(":", "-");
	}
}
