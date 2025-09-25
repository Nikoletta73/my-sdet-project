package config;
import org.aeonbits.owner.Config;

/**
 * Интерфейс с конфигурацией проекта для тестов браузер Chrome
 * Параметры загружаются из form_config.properties
 */
@Config.Sources({"classpath:form_config.properties"})
public interface FormTestsConfig extends Config {
    /**
     * Метод возвращает параметр inputName из form_config.properties
     * @return имя
     */
    String inputName();

    /**
     * Метод возвращает параметр inputPassword из form_config.properties
     * @return пароль
     */
    String inputPassword();

    /**
     * Метод возвращает параметр inputEmail из form_config.properties
     * @return email
     */
    String inputEmail();
}