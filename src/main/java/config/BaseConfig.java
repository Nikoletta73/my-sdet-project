package config;
import org.aeonbits.owner.Config;

/**
 * Интерфейс с основной конфигурацией проекта
 * Используется для загрузки параметров из файла config.properties.
 */

@Config.Sources({"classpath:config.properties"})
public interface BaseConfig extends Config {
    /**
     * Метод возвращает URL из конфигурации.
     * @return базовый URL проекта
     */
    String url();
}
