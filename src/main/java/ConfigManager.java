import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
    private Properties properties = new Properties();
    public ConfigManager() {
        loadProperties();
    }

    private void loadProperties() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }
            // Load a properties file from class path
            properties.load(input);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
