package inji.pages;

import inji.constants.Target;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SetPasscode extends BasePage {

    @iOSXCUITFindBy(accessibility = "setPasscodeHeader")
    @AndroidFindBy(xpath = "//*[contains(@text,'Set Passcode')]")
    private WebElement setPasscode;


    @iOSXCUITFindBy(accessibility = "Done")
    private WebElement DoneButton;


    public SetPasscode(AppiumDriver driver) {
        super(driver);
    }

    public boolean isSetPassCodePageLoaded() {
        return this.isElementDisplayed(setPasscode);
    }

    public ConfirmPasscode enterPasscode(String passcode, Target os) {
        char[] arr = passcode.toCharArray();
        switch (os) {
            case ANDROID:
                enterOtpAndroid(arr);
                break;
            case IOS:
                enterOtpIos(arr);
                break;
        }
        return new ConfirmPasscode(driver);
    }

    public void enterPasscodeForEsignet(String passcode, Target os) {
        char[] array = passcode.toCharArray();
        switch (os) {
            case ANDROID:
                enterOtpAndroidForEsignet(array);
                break;
            case IOS:
                enterOtpIosForEsignet(array);
                break;
        }
        new ConfirmPasscode(driver);
    }

    private void enterOtpAndroid(char[] arr) {
        for (int i = 1; i <= 6; i++) {
            String locator = "(//*[@class='android.widget.EditText'])[" + i + "]";
            driver.findElement(By.xpath(locator)).sendKeys(String.valueOf(arr[i - 1]));
        }
    }

    private void enterOtpIos(char[] arr) {
        for (int i = 1; i <= 6; i++) {
            String locator = "(//*[@type='XCUIElementTypeSecureTextField'])[" + i + "]";
            driver.findElement(By.xpath(locator)).sendKeys(String.valueOf(arr[i - 1]));
        }
    }


    private void enterOtpIosForEsignet(char[] arr) {
        for (int i = 1; i <= 6; i++) {
            clickOnDoneButton();
            String locator = "//XCUIElementTypeOther[@name=\"e-Signet\"]/XCUIElementTypeOther[6]/XCUIElementTypeTextField[" + i + "]";
            driver.findElement(By.xpath(locator)).sendKeys(String.valueOf(arr[i - 1]));

        }
    }

    private void clickOnDoneButton() {
        if(isElementDisplayed(DoneButton,3)) {
            clickOnElement(DoneButton);
        }
    }
    private void enterOtpAndroidForEsignet(char[] arr) {
        for (int i = 2; i <= 8; i++) {
            int index = i - 2;
            if (index < arr.length) {
                String locator = "(//*[@class='android.widget.EditText'])[" + i + "]";
                driver.findElement(By.xpath(locator)).sendKeys(String.valueOf(arr[index]));
            }
        }
    }

}
