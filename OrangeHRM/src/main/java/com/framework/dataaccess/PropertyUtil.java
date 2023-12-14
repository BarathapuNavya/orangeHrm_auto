package com.framework.dataaccess;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyUtil {
	static Properties prop;
	public static void initializeProperty() {

		try {
			String path = System.getProperty("user.dir") + "\\src\\test\\resources\\config\\OrangeHRM.properties";
			File file = new File(path);
			FileInputStream fis;

			fis = new FileInputStream(file);

			prop = new Properties();

			prop.load(fis);

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static String readProperty(String key) {

		String value = prop.getProperty(key);

		return value;
	}

}
