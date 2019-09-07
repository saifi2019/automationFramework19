package page.objects;

import application.base.page.ApplicationPageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import reporting.TestLogger;

public class LoginPage {

   @FindBy(id = "email")
    private WebElement emailBox;
   @FindBy(id = "passwd")
   private WebElement passwordBox;
   @FindBy(id = "SubmitLogin")
   private WebElement signinButton;
   @FindBy(css = "#center_column > div.alert.alert-danger > p")
   private WebElement errorMessage;

   public void login(String email, String  password){
       ApplicationPageBase.sendKeys("emailBox",email, emailBox);
       ApplicationPageBase.sendKeys("passwordBox", password, passwordBox);
       ApplicationPageBase.click("Sing in button", signinButton);
   }

    public String getErroMessage(){

       String actualtext = errorMessage.getText();
       TestLogger.log(actualtext);

       return actualtext;

   }
}
