public class lengthPage extends pageCreator {

    @Override
    String createMenuContent() {
        return "<nav>" +
                "<a href=\"/length\" class=\"active\">Length</a>" +
                "<a href=\"/weight\">Weight</a>" +
                "<a href=\"/temperature\">Temperature</a>" +
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
        return "<a href=\"/length\" class=\"reset-btn\">Reset</a>";
    }

    String createUnitLabelContent() {
        return "<label for=\"value\">Enter the length to convert</label>";
    }

    String createSelectionContent() {
        return "<form method=\"POST\" action=\"\" target=\"_self\">" +
                "<div class=\"form_group\">" +
                "<option value=\"mm\">millimeter</option>" +
                "<option value=\"cm\">centimeter</option>" +
                "<option value=\"in\">inch</option>"+
                "<option value=\"ft\">foot</option>"+
                "<option value=\"yd\">yard</option>"+
                "<option value=\"m\">meter</option>" +
                "<option value=\"km\">kilometer</option>" +
                "<option value=\"mi\">mile</option>";
    }
}
