/**
 * ReadTestData class reads data from external data file (properties,csv or excel file)
 * 
 * @author Siddharth Jadhav
 * @version 1.0
 * @date 20th Nov 2022
 * 
 * */

package crm.utils;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;


public class ReadTestData {
	
	// Function to read test data from testdata.properties file
	public static String getConfigData(String keyName) {

		Properties pro = new Properties();
		
		try {

			String filePath = System.getProperty("user.dir") + "//resources//propertiesfile//testenv.properties";
			
			if (new File(filePath).exists()) {
				
				pro.load(new FileReader(filePath));


			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return pro.getProperty(keyName);

	}

}
