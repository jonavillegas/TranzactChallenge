package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageobjects.Home;
import pageobjects.Login;
import pageobjects.MyAaccount;

public class SignInDefinitions {

    Home home;
    Login login;
    MyAaccount account;

    public SignInDefinitions() {
        home = new Home();
        login = new Login();
        account = new MyAaccount();
    }

    @Given("the url is available")
    public void theUrlIsAvailable() {
        home.accessUrl();
    }


    @And("the user clicks on login")
    public void theUserClicksOnLogin() {
        home.toAccessLogin();
    }

    @And("the user clicks on Create an account")
    public void theUserClicksOnCreateAnAccount() {
        login.toAccessCreateAccount();
    }

    @When("the user enters the {string}, {string}, {string}")
    public void theUserEntersThe(String fullName, String email, String password) {
        login.enterFullName(fullName);
        login.enterEmail(email);
        login.enterPassword(password);
    }

    @And("the user clicks on SIGN UP")
    public void theUserClicksOnSIGNUP() {
        login.toAccessSignUp();
    }

    @And("the user clicks on login option")
    public void theUserClicksOnLoginOption() {
        account.refrescar();
        home.toAccessLogin();
        home.toAccessLogin();
    }

    @Then("the user email {string} is displayed")
    public void theUserEmailIsDisplayed(String email)   {
        Assert.assertTrue(account.compareEmail(email));
    }

    @When("the user enters the {string}, {string}")
    public void theUserEntersThe(String email, String password) {
        login.enterEmail(email);
        login.enterPassword(password);
    }

    @And("the user clicks on SIGN IN")
    public void theUserClicksOnSIGNIN() {
        login.toAccessSignIn();
    }
}
