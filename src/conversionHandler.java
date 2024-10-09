import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class conversionHandler {
    public Map<String, String> getValuesFromForm(String formData) {

        String regex = "value=(\\d+)&from=(\\w+)&to=(\\w+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(formData);

        if (matcher.find()) {
            Map<String, String> params = new HashMap<>();

            params.put("value", matcher.group(1));
            params.put("from", matcher.group(2));
            params.put("to", matcher.group(3));

            return params;
        }
        return null;
    }
}
