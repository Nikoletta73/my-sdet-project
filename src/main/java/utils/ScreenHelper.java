package utils;
import io.qameta.allure.Attachment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Класс с методами работы со скриншотами
 * Используется для создания скриншотов всего экрана (включая alert) и прикрепления их к отчетам Allure
 */
public class ScreenHelper {
    private static final Logger logger = LoggerFactory.getLogger(ScreenHelper.class); // Логгер для записи ошибок и информации

    /**
     * Метод создания скриншота всего экрана с помощью класса Robot,
     * @return массив байт с изображением скриншота в формате PNG
     */
    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] makeScreenShot() {
        try {
            Robot robot = new Robot(); // Создание объекта Robot
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()); // Определение размера экрана (ширина и высота)
            BufferedImage screenCapture = robot.createScreenCapture(screenRect); // Создание скриншота с заданным размером
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); // Буфер для записи изображения в байтовый массив
            ImageIO.write(screenCapture, "PNG", outputStream); // Запись скриншота в формате PNG в буфер
            return outputStream.toByteArray(); // Возврат байтов полученного изображения
        } catch (AWTException | IOException e) {
            // При ошибке записываем сообщение в лог и возвращаем пустой массив
            logger.error("Ошибка при создании скриншота: {}", e.getMessage(), e);
            return new byte[0];
        }
    }
}