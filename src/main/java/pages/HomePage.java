package pages;
import config.FormTestsConfig;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.util.List;
import static utils.ScreenHelper.makeScreenShot;
import static utils.Waiters.waitUntilAlertIsPresent;

/**
 * Класс в котором происходит взаимодействие со страницей браузера Chrome
 * Реализует паттерн Page Object.
 */
public class HomePage {
    /**
     * Экземпляр драйвера для управления браузером
     */
    private final WebDriver driver; // Драйвер для управления браузером

    /**
     * Экземпляр конфигурации с параметрами для Chrome
     */
    private final FormTestsConfig config = ConfigFactory.create(FormTestsConfig.class, System.getenv()); // Создание экземпляра конфигурации с параметрами для Chrome

    /**
     * Элемент в поле ввода "Name"
     */
    @SuppressWarnings("unused")
    @FindBy(id = "name-input")
    private WebElement nameField; // Поле ввода "Name"
    /**
     * Элемент в поле ввода "Password"
     */
    @SuppressWarnings("unused")
    @FindBy(css = "form#feedbackForm input[type='password']")
    private WebElement passwordField; // Поле ввода "Password"
    /**
     * Элемент с чекбоксом "Milk"
     */
    @SuppressWarnings("unused")
    @FindBy(id = "drink2")
    private WebElement checkboxMilk; // Элемент с чекбоксом "Milk"
    /**
     * Элемент с чекбоксом "Coffee"
     */
    @SuppressWarnings("unused")
    @FindBy(id = "drink3")
    private WebElement checkboxCoffee; // Элемент с чекбоксом "Coffee"
    /**
     * Элемент с радиокнопкой "Yellow"
     */
    @SuppressWarnings("unused")
    @FindBy(css = "label[for='color3']")
    private WebElement radioButtonYellow; // Элемент с радиокнопкой "Yellow"
    /**
     * Элемент с выпадающим списком на вопрос "Do you like automation?"
     */
    @SuppressWarnings("unused")
    @FindBy(css = "select[data-cy='automation']")
    private WebElement automationList; // Выпадающий список на вопрос "Do you like automation?"
    /**
     * Элемент в поле ввода "Email"
     */
    @SuppressWarnings("unused")
    @FindBy(xpath = "//input[@data-cy='email']")
    private WebElement emailField; // Поле ввода email
    /**
     * Элемент в поле Automation Tools
     */
    @SuppressWarnings("unused")
    @FindBy(xpath = "//label[text()='Automation tools']/following-sibling::ul") // Поле Automation Tools
    private WebElement automationToolsList;
    /**
     * Элемент в поле ввода "Message"
     */
    @SuppressWarnings("unused")
    @FindBy(id = "message") // Поле ввода сообщения
    private WebElement messageField;
    /**
     * Элемент кнопки Submit
     */
    @SuppressWarnings("unused")
    @FindBy(id = "submit-btn") // Элемент кнопки "Submit"
    private WebElement submitButton;

    /**
     * Конструктор создания HomePage
     * Инициализирует элементы страницы через PageFactory
     * @param driver драйвер для управления браузером
     */
    public HomePage(final WebDriver driver) {
        this.driver = driver; // Сохранение драйвера в поле класса
        PageFactory.initElements(driver, this); // Инициализация элемента страницы
    }

    /**
     * Метод ввода в поле "Name" имени
     * Выполняет заполнение поля "Name" данными из конфигурации
     * @return текущий объект страницы для цепочки вызовов (Fluent Interface)
     */
    @Step("Ввод имени в поле Name")
    public HomePage inputNameField() {
        nameField.sendKeys(config.inputName()); // Ввод значения из конфигурации
        return this; // Возврат текущего объекта страницы
    }

    /**
     * Метод ввода в поле "Password" пароля
     * Выполняет заполнение поля "Password" данными из конфигурации
     * @return текущий объект страницы для цепочки вызовов (Fluent Interface)
     */
    @Step("Ввод пароля в поле Password")
    public HomePage inputPasswordField() {
        passwordField.sendKeys(config.inputPassword()); // Ввод значения из конфигурации
        return this; // Возврат текущего объекта страницы
    }

    /**
     * Метод активации чекбокса "Milk"
     * Выполняет выбор чекбокса "Milk" в разделе "What is your favorite drink?"
     * @return текущий объект страницы для цепочки вызовов (Fluent Interface)
     */
    @Step("Активация чекбокса - Milk")
    public HomePage selectCheckboxMilk() {
        checkboxMilk.click(); // Клик по чекбоксу "Milk"
        return this; // Возврат текущего объекта страницы
    }

    /**
     * Метод активации чекбокса "Coffee"
     * Выполняет выбор чекбокса "Coffee" в разделе "What is your favorite drink?"
     * @return текущий объект страницы для цепочки вызовов (Fluent Interface)
     */
    @Step("Активация чекбокса - Coffee")
    public HomePage selectCheckboxCoffee() {
        checkboxCoffee.click(); // Клик по чекбоксу "Coffee"
        return this; // Возврат текущего объекта страницы
    }

    /**
     * Метод выбора радиокнопки "Yellow"
     * Выполняет выбор радиокнопки "Yellow" в разделе "What is your favorite color?"
     * @return текущий объект страницы для цепочки вызовов (Fluent Interface)
     */
    @Step("Выбор радиокнопки Yellow")
    public HomePage selectRadioButtonYellow() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", radioButtonYellow); // Прокрутка страницы к радиокнопке "Yellow" для обеспечения ее видимости
        Thread.sleep(200); // Временная пауза для обеспечения завершения анимации прокрутки
        radioButtonYellow.click(); // Клик по радиокнопке "Yellow"
        return this; // Возврат текущего объекта страницы
    }

    /**
     * Метод выбора опции "Yes" в выпадающем списке
     * Выбирает из выпадающего списка "Yes"
     * @return текущий объект страницы для цепочки вызовов (Fluent Interface)
     */
    @Step("Выбор опции Yes в выпадающем списке Do you like automation?")
    public HomePage selectAutomationYes() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", automationList); // Прокрутка страницы к выпадающему списку для обеспечения его видимости
        Select dropdown = new Select(automationList); // Создание объекта Select для работы с выпадающим списком
        dropdown.selectByVisibleText("Yes"); // Выбор опции по видимому тексту "Yes"
        return this; // Возврат текущего объекта страницы
    }

    /**
     * Метод ввода email в поле "Email"
     * Выполняет заполнение поля "Email" адресом электронной почты из конфигурации
     * @return текущий объект страницы для цепочки вызовов (Fluent Interface)
     */
    @Step("Ввод email в поле Email")
    public HomePage inputEmailField() {
        emailField.sendKeys(config.inputEmail()); // Ввод значения из конфигурации
        return this; // Возврат текущего объекта страницы
    }

    /**
     * Заполняет поле "Message" информацией о инструментах автоматизации:
     *  - подсчитывает количество инструментов из списка
     *  - определяет самый длинный по длине инструмент
     *  - формирует сообщение и вводит его в поле "Message"
     * @return текущий объект страницы для цепочки вызовов (Fluent Interface)
     */
    @Step("Заполнение поля Message данными об Automation tools")
    public HomePage fillMessageWithAutomationToolsInfo() {
        List<WebElement> tools = automationToolsList.findElements(By.tagName("li")); // Получение списка элементов li внутри automationToolsList

        int toolsCount = tools.size(); // Количество инструментов
        String longestTool = ""; // Для хранения самого длинного имени инструмента

        // Цикл для поиска инструмента с максимальной длиной текста
        for (WebElement tool : tools) {
            String toolText = tool.getText().trim();
            if (toolText.length() > longestTool.length()) {
                longestTool = toolText;
            }
        }

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", messageField); // Прокрутка к полю ввода сообщения, чтобы сделать его видимым
        String message = "Количество инструментов: " + toolsCount + ". Самый длинный инструмент: " + longestTool; // Формирование сообщения с количеством и самым длинным инструментом
        messageField.sendKeys(message); // Ввод сформированного сообщения в поле
        return this; // Возврат текущего объекта страницы
    }

    /**
     * Метод нажатия кнопки Submit и проверки алерта
     * Выполняет отправку формы и проверяет появление ожидаемого алерта
     * Включает прокрутку, клик, проверку текста алерта и создание скриншота
     * @throws InterruptedException если поток был прерван во время ожидания
     */
    @Step("Нажатие кнопки Submit и проверка алерта")
    public void submitForm() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton); // Прокрутка страницы к кнопке Submit для обеспечения ее видимости
        Thread.sleep(2000); // Приостановка выполнения на 2 секунды для завершения анимации прокрутки
        submitButton.click(); // Клик по кнопке "Submit"
        Alert alert = waitUntilAlertIsPresent(driver); // Ожидание появления алерта и получение ссылки на него
        String alertText = alert.getText(); // Получение текста из появившегося алерта
        Assert.assertEquals(alertText, "Message received!", "Текст алерта не совпадает"); // Проверка соответствия текста алерта ожидаемому значению
        Thread.sleep(200); // Пауза для стабилизации отображения алерта
        makeScreenShot(); // Скриншот с ожидаемым результатом
        alert.accept(); // Закрытие алерта
    }
}