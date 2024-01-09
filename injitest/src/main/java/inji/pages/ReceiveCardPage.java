package inji.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ReceiveCardPage extends BasePage {
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Allow\")")
    private WebElement allowButton;
    
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\")")
    private WebElement allowPermissionPopupButton;

    @AndroidFindBy(accessibility = "showQrCode")
    private WebElement receiveCardHeader;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Ipakita ang QR code na ito para humiling ng resident card\")")
    private WebElement receiveCardHeaderInFilipinoLanguage;

    @AndroidFindBy(accessibility = "qrCode")
    private WebElement qrCode;

    @AndroidFindBy(accessibility = "receiveCardStatusMessage")
    private WebElement waitingForConnection;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.oplus.wirelesssettings:id/alertTitle\")")
    private WebElement bluetoothPopUp;

    public ReceiveCardPage(AppiumDriver driver) {
        super(driver);
    }

    public void clickOnAllowButton() {
        if (isElementDisplayed(bluetoothPopUp)) {
            clickOnElement(allowButton);
        }
    }
    
    public ReceiveCardPage acceptPermissionPopupForLocationAndroid() {
        if (isElementDisplayed(allowPermissionPopupButton)) {
            clickOnElement(allowButton);
        }
        return this;
    }

    public boolean isReceiveCardHeaderDisplayed() {
        return this.isElementDisplayed(receiveCardHeader);
    }

    public boolean isReceiveCardHeaderInFilipinoLanguageDisplayed() {
        return this.isElementDisplayed(receiveCardHeaderInFilipinoLanguage);
    }

    public boolean isWaitingForConnectionDisplayed() {
        return this.isElementDisplayed(waitingForConnection);
    }

    public boolean isQrCodeEnabled() {
        return this.isElementEnabled(qrCode);
    }

}
