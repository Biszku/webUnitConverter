public class LengthConHan extends ConversionHandler {

    @Override
    PageCreator getPage() {
        return new TemperaturePage();
    }

    @Override
    double convertUnit(double value, String from, String to) {
        double convertedValue = Length.convertUnit(from, to);
        return value * convertedValue;
    }
}
