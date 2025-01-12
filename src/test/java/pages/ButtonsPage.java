import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class ButtonsPage {
    private final SelenideElement
            buttonsMenu = $("div[class='element-group']:nth-child(1) #item-4"),
            clickMeButton = $("button#dynamicClickMessage"),
            clickMessage = $("#dynamicClickMessage");

    public void clickButtonsMenu() {
        buttonsMenu.scrollTo().click();
    }

    public void clickDynamicButton() {
        clickMeButton.click();
    }

    public String getClickMessage() {
        return clickMessage.getText();
    }
}