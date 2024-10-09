import java.nio.charset.Charset;

public enum Temperature {
    FAHRENHEIT(9.0 / 5.0, 32),
    CELSIUS(1, 0),
    KELVIN(1, 273.15);

    private final double conversionFactor;
    private final double offset;

    Temperature(double conversionFactor, double offset) {
        this.conversionFactor = conversionFactor;
        this.offset = offset;
    }

    static double convert(double value, String fromUnit, String toUnit) {
        double celsiusValue = switch (fromUnit) {
            case "F" -> (value - FAHRENHEIT.offset) * (5.0 / 9.0);
            case "C" -> value;
            case "K" -> value - KELVIN.offset;
            default -> throw new IllegalArgumentException("Unknown unit: " + fromUnit);
        };

        return switch (toUnit) {
            case "F" -> (celsiusValue * FAHRENHEIT.conversionFactor) + FAHRENHEIT.offset;
            case "C" -> celsiusValue;
            case "K" -> celsiusValue + KELVIN.offset;
            default -> throw new IllegalArgumentException("Unknown unit: " + toUnit);
        };
    }
}
