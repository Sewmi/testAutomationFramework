package progresity.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import progresity.com.utitlity.Application;

public class HomePage extends Page {

    @FindBy(id="pn_id_2")
    private WebElement languageDropdownWebElement;

    @FindBy(id = "pn_id_2_0")
    private WebElement languageDropdownElement_Netherlands;

    @FindBy(id="pn_id_2_1")
    private WebElement languageDropdownElement_English;

    @FindBy(name="button")
    private  WebElement loginButton;

    public HomePage changeLanguage(String language){
        waitUntilNextElementAppears(By.id("pn_id_2"),TIMEOUT_10SECONDS);
        languageDropdownWebElement.click();
        switch (language){
            case ("English"):
                waitUntilNextElementAppears(By.id("pn_id_2_1"),TIMEOUT_10SECONDS);
                languageDropdownElement_English.click();
                break;
            case ("Nederlands"):
                waitUntilNextElementAppears(By.id("pn_id_2_0"),TIMEOUT_10SECONDS);
                languageDropdownElement_Netherlands.click();
                break;
            default:
                System.out.println("Unsupported Language");
        }

        return this;
    }

    public boolean  isLanguageSetToEnglish(){
        boolean isLanguageSetToEnglish = false;
        waitUntilNextElementAppears(By.name("button"),TIMEOUT_10SECONDS);
        //TODO Read from language file
        if(loginButton.getText().equals("Sign In")){
                    isLanguageSetToEnglish = true;
        }
        return isLanguageSetToEnglish;
    }
    public boolean  isLanguageSetToDutch(){
        boolean isLanguageSetToDutch = false;
        waitUntilNextElementAppears(By.name("button"),TIMEOUT_10SECONDS);
        //TODO Read from language file
        if(loginButton.getText().equals("Aanmelden")){
                isLanguageSetToDutch = true;
        }
        return isLanguageSetToDutch;
    }
}
