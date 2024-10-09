public enum Weight {
    MILLIGRAM(0.001),
    GRAM(1),
    OUNCE(28.3495231),
    POUND(453.59237),
    KILOGRAM(1000);

    private final double value;

    Weight(double value) {
        this.value = value;
    }

    public static double convertUnit(String unit, String outputUnit) {
        return getValue(unit) / getValue(outputUnit);
    }

    static double getValue(String unit) {
        return switch (unit) {
            case "mg" -> MILLIGRAM.value;
            case "g" -> GRAM.value;
            case "oz" -> OUNCE.value;
            case "lb" -> POUND.value;
            case "kg" -> KILOGRAM.value;
            default -> 0;
        };
    };
}
