package utils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * Класс с методами явного ожидания
 */
public class Waiters {
     /**
     * Ожидает появления alert окна в течение 5 секунд.
      * Ожидание продолжается до тех пор, пока не появится всплывающее окно alert,
      * либо пока не истечет время ожидания, после чего будет выброшено исключение TimeoutException, если alert не появился.
     * @param driver экземпляр драйвера браузера
     * @return Alert, если он появился в течение таймаута
     */
    public static Alert waitUntilAlertIsPresent(final WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());
    }
}
