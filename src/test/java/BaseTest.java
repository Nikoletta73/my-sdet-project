import config.BaseConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Общий класс с настройками для всех тестов
 * Инициализирует WebDriver и задаёт основные настройки
 */
public class BaseTest {
    /**
     * Переменная с экземпляром драйвера
     */
    protected WebDriver driver;  // Объявление драйвера, чтобы наследники могли его использовать

    /**
     * Экземпляр конфигурации с общими параметрами
     */
    private final BaseConfig config = ConfigFactory.create(BaseConfig.class, System.getenv()); // Создание экземпляра конфигурации с общими параметрами

    /**
     * Общие настройки для всех тестов перед выполнением каждого
     */
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver(); // Создание экземпляра драйвера для Chrome
        driver.get(config.url()); // Открытие страницы по url
        driver.manage().window().maximize(); // Разворот страницы на полное окно
    }

    /**
     * Общие настройки для всех тестов после выполнением каждого
     */
    @AfterMethod
    public void tearDown(){
        driver.close(); // Остановка работы драйвера
    }
}
