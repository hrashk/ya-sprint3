package ya.praktikum.sprint3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SpeedLightsTest {

    @Test
    public void showLightWhen50ThenGreen() {
        SpeedLights lights = new SpeedLights(60);
        String value = lights.showLight(50);
        assertEquals("green", value);
    }

    @Test
    public void showLightWhen70ThenYellow() {
        SpeedLights lights = new SpeedLights(60);
        String value = lights.showLight(70);
        assertEquals("yellow", value);
    }

    @Test
    public void showLightWhen90ThenRed() {
        SpeedLights lights = new SpeedLights(60);
        String value = lights.showLight(90);
        assertEquals("red", value);
    }
}
