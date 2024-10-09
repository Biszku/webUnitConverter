public class TemperatureConHan extends ConversionHandler {

    @Override
    PageCreator getPage() {
        return new TemperaturePage();
    }

    @Override
    double convertUnit(double value, String from, String to) {
        return Temperature.convert(value, from, to);
    }
}
