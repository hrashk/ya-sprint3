package ya.praktikum.sprint3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SpeedLightsParamsTest {
    private int speedLimit;
    private int currentSpeed;
    private String expectedLight;

    public SpeedLightsParamsTest(int speedLimit, int currentSpeed, String expectedLight) {
        this.speedLimit = speedLimit;
        this.currentSpeed = currentSpeed;
        this.expectedLight = expectedLight;
    }

    @Parameterized.Parameters(name = "limit = {0}, speed = {1}, expectedLight = {2}")
    public static Object[] dataGen() {
        return new Object[][] {

                //позитивные тесты
                //Граничные значения
                {60, 59, "green"}, // приграничное число
                {60, 60, "green"}, // граница 1 диапазона
                {60, 61, "yellow"}, // приграничное число
                {60, 80, "yellow"}, // граница 2 диапазона
                {60, 81, "red"}, // приграничное число

                {60, 0, "green"}, // проверка 0
                {60, -1, "green"}, // отрицательное число

                //негативные
                {60, 60.5, "yellow"}, // дробное число
                {60, null, "green"}, // нет числа
                {60, "50", "green"}, // число в виде строки

                //!большое число, выходящее из диапазона Int. Дает интересный результат
                {60, 1_999_999_999+1_999_999_999, "red"},
        };
    }

    @Test
    public void showLightChecksd() {
        SpeedLights lights = new SpeedLights(speedLimit);
        String value = lights.showLight(currentSpeed);
        assertEquals(expectedLight, value);
    }
}
