package progresity.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import progresity.com.utitlity.Application;

import java.time.Duration;

public class Page {

    public final int TIMEOUT_10SECONDS = 10;

    public WebElement waitUntilNextElementAppears(By locator, int timeOut ){
        WebElement element = new WebDriverWait(Application.getInstance().getDriver(),
                    Duration.ofSeconds(timeOut)).until(ExpectedConditions.presenceOfElementLocated(locator));
        return element;
    }

   // public boolean assertTrue()
}
