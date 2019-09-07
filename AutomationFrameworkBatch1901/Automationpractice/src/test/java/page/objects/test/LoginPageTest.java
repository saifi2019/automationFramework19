package page.objects.test;

import base.BrowserDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.objects.HomePage;
import page.objects.LoginPage;
import xslx.datareader.MyDataReader;

public class LoginPageTest extends BrowserDriver {

    HomePage objHomePage ;
    LoginPage loginPage;

    @BeforeMethod
    public void initElements(){
        objHomePage = PageFactory.initElements(driver, HomePage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }
    @DataProvider
    public Object[][] dataProvider() throws Exception {

        MyDataReader myDataReader = new MyDataReader();
        String path = System.getProperty("user.dir") + "/data/data.xlsx";

        myDataReader.setExcelFile(path);
       String[][] data = myDataReader.getExcelSheetData("Sheet1");
       return data;

    }

    @Test(dataProvider = "dataProvider")
    public void loginTest(String emailFromFile, String passwordFromFile, String expectedTextFromFile){
        objHomePage.goToSigninPage();

        loginPage.login(emailFromFile, passwordFromFile);

        String actualtext = loginPage.getErroMessage();
        Assert.assertEquals(actualtext, expectedTextFromFile);
    }

}
