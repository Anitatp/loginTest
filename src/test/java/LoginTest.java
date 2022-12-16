import org.testng.annotations.Test;
import pages.HomePage;

import static org.testng.Assert.assertTrue;
import static utils.Properties.*;


public class LoginTest extends BaseTest{

    @Test
    public void loginWithValidCredentials(){
        String actualMessage = new HomePage(driver).clickFormAuthentication()
                .login(USERNAME,PASSWORD)
                .getSuccessfulLoginMessage();
        assertTrue(actualMessage.contains("You logged into a secure area!")
                ,"Alert text is incorrect!");
    }

    @Test
    public void loginWithWrongUsername(){
        String actualMessage = new HomePage(driver).clickFormAuthentication()
                .login(WRONG_USERNAME,PASSWORD)
                .getErrorLoginMessage();
        assertTrue(actualMessage.contains("Your username is invalid!")
                ,"Alert text is incorrect!");
    }

    @Test
    public void loginWithWrongPassword(){
        String actualMessage = new HomePage(driver).clickFormAuthentication()
                .login(USERNAME,WRONG_PASSWORD)
                .getErrorLoginMessage();
        assertTrue(actualMessage.contains("Your password is invalid!")
                ,"Alert text is incorrect!");
    }
}
