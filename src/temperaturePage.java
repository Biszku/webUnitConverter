public class temperaturePage extends pageCreator{

    @Override
    String createMenuContent() {
        return "<nav>" +
                "<a href=\"/length\">Length</a>" +
                "<a href=\"/weight\">Weight</a>" +
                "<a href=\"/temperature\" class=\"active\">Temperature</a>" +
                "</nav>";
    }

    @Override
    String createContent() {
        return "<form method=\"POST\" action=\"\" target=\"_self\">" +
                "<div class=\"form_group\">" +
                createUnitLabelContent() +
                "<input type=\"number\" id=\"value\" name=\"value\">" +
                "</div>" +
                "<div class=\"form_group\">" +
                "<label for=\"from\">Unit to Convert from</label>" +
                "<select id=\"from\" name=\"from\">" +
                "<option value=\"\" selected disabled hidden></option>" +
                createSelectionContent() +
                "</select>" +
                "</div>" +
                "<div class=\"form_group\">" +
                "<label for=\"to\">Unit to Convert to</label>" +
                "<select id=\"to\" name=\"to\">" +
                "<option value=\"\" selected disabled hidden></option>" +
                createSelectionContent() +
                "</select>" +
                "</div>" +
                "<input type=\"submit\" value=\"Convert\">" +
                "</form>";
    }

    @Override
    String createResetButton() {
        return "<a href=\"/temperature\" class=\"reset-btn\">Reset</a>";
    }

    String createSelectionContent() {
        return "<option value=\"C\">Celsius</option>" +
                "<option value=\"F\">Fahrenheit</option>" +
                "<option value=\"K\">Kelvin</option>";
    }

    String createUnitLabelContent() {
        return "<label for=\"value\">Enter the temperature to convert</label>";
    }
}
