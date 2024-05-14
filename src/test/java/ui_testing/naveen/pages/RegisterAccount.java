package ui_testing.naveen.pages;

public class RegisterAccount {

    public static String h1Locator = "//*[@id='content']/h1";
    public static String registerLegendLocator = "//*[@id='account']/legend";

    public static String getH1Locator() {
        return h1Locator;
    }

    public static void setH1Locator(String h1Locator) {
        RegisterAccount.h1Locator = h1Locator;
    }

    public static String getRegisterLegendLocator() {
        return registerLegendLocator;
    }

    public static void setRegisterLegendLocator(String registerLegendLocator) {
        RegisterAccount.registerLegendLocator = registerLegendLocator;
    }
}
