import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.cucumber.datatable.DataTable;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.Map;
import io.qameta.allure.*;

@Epic("DemoQA Tests")
@Feature("Web Elements Tests")

 public class DemoQASteps {
    private ButtonsPage buttonsPage = new ButtonsPage();
    private WebTablesPage webTablesPage = new WebTablesPage();
    private Map<String, String> recordData;

    @Given("kullanici {string} sayfasina gider")
    public void navigateToUrl(String url) {
        open(url);
    }

    @When("Buttons seçeneğini tıklar")
    public void clickButtonsOption() {
        buttonsPage.clickButtonsMenu();
    }

    @And("Click Me butonuna tıklar")
    public void clickDynamicButton() {
        buttonsPage.clickDynamicButton();
    }

    @Then("mesajın {string} olduğunu doğrular")
    public void verifyClickMessage(String expectedMessage) {
        assertEquals(expectedMessage, buttonsPage.getClickMessage());
    }

    @When("Add butonuna tıklar")
    public void clickAddButton() {
        webTablesPage.clickAddButton();
    }

    @And("yeni kayıt bilgilerini girer")
    public void fillNewRecord(DataTable dataTable) {
        recordData = dataTable.asMaps().get(0);
        webTablesPage.fillForm(recordData);
    }

    @And("Submit butonuna tıklar")
    public void clickSubmitButton() {
        webTablesPage.clickSubmit();
    }

    @Then("kaydın eklendiğini doğrular")
    public void verifyRecordAdded() {
        assertTrue(webTablesPage.verifyRecord(recordData));
    }

    @When("kayıt düzenleme butonuna tıklar")
    public void clickEditRecord() {
        webTablesPage.editRecord(recordData.get("FirstName"));
    }

    @And("kayıt bilgilerini günceller")
    public void updateRecord(DataTable dataTable) {
        recordData = dataTable.asMaps().get(0);
        webTablesPage.fillForm(recordData);
    }

    @Then("kaydın güncellendiğini doğrular")
    public void verifyRecordUpdated() {
        assertTrue(webTablesPage.verifyRecord(recordData));
    }
}