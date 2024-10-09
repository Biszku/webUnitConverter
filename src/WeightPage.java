public class WeightPage extends PageCreator {

    @Override
    String createMenu() {
        return "<nav>" +
                "<a href=\"/length\">Length</a>" +
                "<a href=\"/weight\" class=\"active\">Weight</a>" +
                "<a href=\"/temperature\">Temperature</a>" +
                "</nav>";
    }

    @Override
    String createForm() {
        return "<form method=\"POST\" action=\"\" target=\"_self\">" +
                "<div class=\"form_group\">" +
                "<label for=\"value\">Enter the weight to convert</label>" +
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
        return "<a href=\"/weight\" class=\"reset-btn\">Reset</a>";
    }

    String createSelectionContent() {
        return "<option value=\"mg\">milligram</option>" +
                "<option value=\"g\">gram</option>" +
                "<option value=\"oz\">Ounce</option>"+
                "<option value=\"lb\">Pound</option>" +
                "<option value=\"kg\">kilogram</option>";
    }
}
