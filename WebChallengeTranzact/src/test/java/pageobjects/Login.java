package pageobjects;

import definitions.Hooks;
import org.openqa.selenium.By;



public class Login extends Hooks {

    By linkCreateAccount = By.xpath("//a[contains(text(),'Create an account')]");
    By txtFullName = By.name("full_name");
    By txtEmail = By.name("email");
    By txtPassword = By.name("password");
    By btnSignUp = By.xpath("//span[contains(.,'SIGN UP')]");
    By btnSignIn = By.xpath("//span[contains(.,'SIGN IN')]");
    By linkMen = By.xpath("//span[contains(text(),'Shop men')]");
    public Login(){
        super(driver);
    }

    public void toAccessCreateAccount(){
        click(linkCreateAccount);
    }

    public void enterFullName(String name){
        enterText(txtFullName,name);
    }
    public void enterEmail(String email){
        enterText(txtEmail,email);
    }
    public void enterPassword(String password){
        enterText(txtPassword,password);
    }

    public void toAccessSignUp(){
        click(btnSignUp);
    }

    public void toAccessSignIn(){
        click(btnSignIn);
    }

    public void toAccessMen(){
        click(linkMen);
    }


}
