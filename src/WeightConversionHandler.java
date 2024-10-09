public class WeightConversionHandler extends ConversionHandler {

    @Override
    PageCreator getPage() {
        return new WeightPage();
    }

    @Override
    double convertUnit(double value, String from, String to) {
        double convertedValue = Weight.convertUnit(from, to);
        return value * convertedValue;
    }
}
