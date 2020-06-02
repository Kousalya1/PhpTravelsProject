package utilities;

import java.io.IOException;
import java.util.Properties;

import managers.DriverType;

public class EnvPropertyManager {
	private static Properties envProperties = new Properties();
	private static final String PROPERTIES_FILE = "config.properties";

	static {
		try {
			envProperties.load(EnvPropertyManager.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE));
		} catch (IOException e) {
			throw new RuntimeException("Property file is not found" + e);
		}
	}

	public static DriverType getBrowser() {
		String browser = envProperties.getProperty("browser");
		DriverType driver;
		switch (browser.toLowerCase()) {
		case "firefox":
			driver = DriverType.FIREFOX;
			break;
		case "chrome":
			driver = DriverType.CHROME;
			break;
		case "ie":
			driver = DriverType.IE;
			break;
		case "edge":
			driver = DriverType.EDGE;
			break;
		default:
			driver = DriverType.CHROME;
			break;
		}
		return driver;
	}
}
