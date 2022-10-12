package ya.praktikum.sprint3;

public class SpeedLights {

    private final int speedLimit;

    public SpeedLights(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    /**
     * есть нет превывшения - green
     * есть превывшение <= 20 - yellow
     * есть превывшение > 20 - red
     */
    public String showLight(int currentSpeed) {
        if (currentSpeed <= speedLimit)
            return "green";
        else if (currentSpeed <= speedLimit + 20)
            return "yellow";
        else
            return "red";
    }

    public String computeFine(int currentSpeed) {
        return "500 rubles";
    }
}
