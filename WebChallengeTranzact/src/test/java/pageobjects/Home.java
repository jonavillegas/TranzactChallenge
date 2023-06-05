package pageobjects;

import definitions.Hooks;
import org.openqa.selenium.By;

public class Home extends Hooks {

    By iconLogin = By.xpath("(//*//div[@class='self-center'])[1]");


    public Home(){
        super(driver);
    }

    public void toAccessLogin(){
        click(iconLogin);
    }

}
