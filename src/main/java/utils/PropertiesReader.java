package utils;

import java.util.ResourceBundle;

public class PropertiesReader {
    private final ResourceBundle config = ResourceBundle.getBundle("config");

    public String getUrl() {
        return config.getString("url");
    }

    public String getLogin() {
        return config.getString("login");
    }

    public String getPassword() {
        return config.getString("password");
    }

    public String getChromeDriverPass() {
        return config.getString("chromedriver_pass");
    }

    public String getLoginPageURL() {
        return config.getString("login_page_url");
    }

}
