import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import java.util.Map;

public class WebTablesPage {
    private final SelenideElement
            addButton = $("#addNewRecordButton"),
            submitButton = $("#submit"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            ageInput = $("#age"),
            salaryInput = $("#salary"),
            departmentInput = $("#department");

    public void clickAddButton() {
        addButton.click();
    }

    public void fillForm(Map<String, String> data) {
        firstNameInput.setValue(data.get("FirstName"));
        lastNameInput.setValue(data.get("LastName"));
        emailInput.setValue(data.get("Email"));
        ageInput.setValue(data.get("Age"));
        salaryInput.setValue(data.get("Salary"));
        departmentInput.setValue(data.get("Department"));
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public void editRecord(String firstName) {
        $("//div[contains(text(),'" + firstName + "')]/..//span[@title='Edit']").click();
    }

    public boolean verifyRecord(Map<String, String> data) {
        return $("//div[contains(text(),'" + data.get("FirstName") + "')]").exists() &&
                $("//div[contains(text(),'" + data.get("Email") + "')]").exists();
    }
}

