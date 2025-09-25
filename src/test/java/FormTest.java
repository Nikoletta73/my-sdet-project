import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import pages.HomePage;

/**
 * Основной класс с тестами HomePage
 */
@Epic("Form")
public class FormTest extends BaseTest{

    @Test(description = "Заполнение формы и проверка алерта")
    @Feature("Работа с формой")
    public void testFormChrome() throws InterruptedException {
        new HomePage(driver)
                .inputNameField()
                .inputPasswordField()
                .selectCheckboxMilk()
                .selectCheckboxCoffee()
                .selectRadioButtonYellow()
                .selectAutomationYes()
                .inputEmailField()
                .fillMessageWithAutomationToolsInfo()
                .submitForm();
    }
}
