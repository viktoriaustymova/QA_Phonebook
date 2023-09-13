package org.ait.phonebook;

import org.ait.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {
    //precondition: user should be logged out

    @BeforeMethod
    public void ensurePrecondition (){
        if(!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
        //click on Login link - a:nth-child(4) - css
        app.getUser().clickOnLoginLink();
    }

    @Test
    public void existedUserRegistrationNegativeTest(){
        app.getUser().fillLoginRegistrationForm(new User()
                .setEmail("leno@gmail.com")
                .setPassword("Bernd1234$"));
        //click on Registration button - //button[text()='Registration'] - xpath
        app.getUser().clickOnRegistrationButton();
        //assert alert is appeared
        Assert.assertTrue(app.getUser().isAlertPresent());
    }
}
