package managers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataManager {
	private static Properties properties = new Properties();
	private static final String PROPERTIES_FILE = "src\\main\\resources\\envConfigs\\config.properties";

	static {
		try {
			FileInputStream ip = new FileInputStream(PROPERTIES_FILE);
			properties.load(ip);
		} catch (IOException e) {
			throw new RuntimeException("Property file is not found" + e);
		}
	}

	public static String getBrowser() {
		return properties.getProperty("browser");
	}
	
	public static String getPhpTravelsUrl() {
		return properties.getProperty("phpTravels.url");
	}

	public static String getPhpTravelsUsername() {
		return properties.getProperty("phpTravels.username");
	}

	public static String getPhpTravelsPassword() {
			return properties.getProperty("phpTravels.password");
	}

	public static String getChromeDriver() {
		return properties.getProperty("chrome.driver");
	}

	public static String getChromeDriverPath() {
		return properties.getProperty("chrome.driverPath");
	}

	public static String getFirefoxDriver() {
		return properties.getProperty("firefox.driver");
	}

	public static String getFirefoxDriverPath() {
		return properties.getProperty("firefox.driverPath");
	}
	
}
