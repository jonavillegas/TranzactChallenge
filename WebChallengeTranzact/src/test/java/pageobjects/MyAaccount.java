package pageobjects;

import definitions.Hooks;
import org.openqa.selenium.By;

import javax.xml.xpath.XPath;

public class MyAaccount extends Hooks {

     By lblEmail = By.xpath("//div[@class='account-details-email flex gap-1']");


    public MyAaccount(){
        super(driver);
    }
    public Boolean compareEmail(String email){
        return getTextCompare(lblEmail,email);
    }

}
