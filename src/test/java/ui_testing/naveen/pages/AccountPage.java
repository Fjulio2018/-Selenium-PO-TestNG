package ui_testing.naveen.pages;

import org.openqa.selenium.WebDriver;

public class AccountPage {

    public static String newCustomerTitle = "//*[@id=\"content\"]/div/div[1]/div/h2";
    public static String continueButton = "//*[@id=\"content\"]/div/div[1]/div/a";


    public static String getNewCustomerTitle() {
        return newCustomerTitle;
    }

    public static void setNewCustomerTitle(String newCustomerTitle) {
        AccountPage.newCustomerTitle = newCustomerTitle;
    }

    public static String getContinueButton() {
        return continueButton;
    }

    public AccountPage(WebDriver driver) {
    }

    public static void setContinueButton(String continueButton) {
        AccountPage.continueButton = continueButton;
    }
}



