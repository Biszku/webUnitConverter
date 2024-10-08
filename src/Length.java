public enum Length {
    MILLIMETER(0.001),
    CENTIMETER(0.01),
    INCH(0.0254),
    FEET(0.3048),
    YARD(0.9144),
    METER(1),
    KILOMETER(1000),
    MILE(1609.344);
    private final double value;

    Length(double value) {
        this.value = value;
    }

    public static double convertUnit(String unit, String outputUnit) {
        return getValue(unit) / getValue(outputUnit);
    }

    static double getValue(String unit) {
        return switch (unit) {
            case "mm" -> MILLIMETER.value;
            case "cm" -> CENTIMETER.value;
            case "in" -> INCH.value;
            case "ft" -> FEET.value;
            case "yd" -> YARD.value;
            case "m" -> METER.value;
            case "km" -> KILOMETER.value;
            case "mi" -> MILE.value;
            default -> 0;
        };
    };
}
