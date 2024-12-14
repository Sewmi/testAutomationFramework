package progresity.com.utitlity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import progresity.com.pages.HomePage;

public class Application {

    private WebDriver driver;
    private static Application myDriverManager;
    PropertyFileHandler propertyFileHandler = new PropertyFileHandler();

    public static Application getInstance(){
        if (myDriverManager == null){
            myDriverManager = new Application();
            return myDriverManager;
        }else{
            return myDriverManager;
        }
    }

    public void openBrowser(String browserName){
        switch (browserName) {
            case "Chrome":
                driver = new ChromeDriver();
                break;
            case "Firefox":
                driver = new FirefoxDriver();
                break;
            case "Edge":
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Requested Driver not available. Chrome is selected as the default browser");
                driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
    }

    public HomePage navigateToHomePage(){
        driver.get(propertyFileHandler.getProperty("config","url"));
        return PageFactory.initElements(Application.getInstance().getDriver(), HomePage.class);
    }

    public WebDriver getDriver(){
        return driver;
    }



}
