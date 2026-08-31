package driver;

public class DriverManagerFactory {
    public static DriverManager getDriverManager(String browser) {
        return switch (browser) {
            case "chrome" -> new ChromeDriverManager();
            case "edge" -> new EdgeDriverManager();
            case "firefox" -> new FirefoxDriverManager();
            default -> null;
        };
    }
}
