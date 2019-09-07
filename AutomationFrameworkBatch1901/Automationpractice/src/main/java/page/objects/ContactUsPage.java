package page.objects;

import application.base.page.ApplicationPageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import reporting.TestLogger;

public class ContactUsPage {

    @FindBy(id = "email")
    private WebElement emailBox;

    public void attemptToContact(){

        ApplicationPageBase.sendKeys("emailBox","xyz@gmail.com", emailBox);

    }

}
