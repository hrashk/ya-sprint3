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
                {60, 50, "green"}, // 0
                {60, 60, "green"}, // 1
                {60, 70, "yellow"}, // 2
                {60, 80, "yellow"}, // 3
                {60, 90, "red"}, // 4
        };
    }

    @Test
    public void showLightChecksd() {
        SpeedLights lights = new SpeedLights(speedLimit);
        String value = lights.showLight(currentSpeed);
        assertEquals(expectedLight, value);
    }
}
