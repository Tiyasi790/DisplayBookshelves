package Read;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UrlRead {

	public static Properties getPropertyObj() throws IOException {
		String filelocation = System.getProperty("user.dir") + "\\Applicationproperty\\File.properties";
		File file = new File(filelocation);
		FileInputStream fi= new FileInputStream(file);
		Properties prop= new Properties();
		prop.load(fi);
		return prop;
	}
	public static String getUrl() throws IOException {
		return getPropertyObj().getProperty("url");
		
	}
}
