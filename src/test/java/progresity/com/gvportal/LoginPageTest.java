package progresity.com.gvportal;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import progresity.com.pages.HomePage;
import progresity.com.utitlity.Application;

public class LoginPageTest {

    private HomePage homePage;

    @BeforeMethod
    public void setUp() {
        Application.getInstance().openBrowser("Chrome");
        homePage = Application.getInstance().navigateToHomePage();

    }

    @Test
    public void testChangeLanguage() {
        homePage.changeLanguage("English");
        Assert.assertTrue(homePage.isLanguageSetToEnglish(),"Language is NOT correctly set to English");
        homePage.changeLanguage("Nederlands");
        Assert.assertTrue(homePage.isLanguageSetToDutch(),"Language is NOT correctly set to Dutch");
    }
}
