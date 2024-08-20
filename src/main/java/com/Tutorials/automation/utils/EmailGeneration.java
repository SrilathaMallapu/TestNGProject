package com.Tutorials.automation.utils;

import java.util.Date;

public class EmailGeneration {

	public static String Email()
	{
		Date datevalue=new Date();
		String timestamp=datevalue.toString();
		return "arunattori"+timestamp+"@gmail.com";
	}
	
}
