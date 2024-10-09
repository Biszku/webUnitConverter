public class pageStyles {

    public static String createStyles() {
        return "<style>" + createDefaultStyles() + createRestStyle() + "</style>";
    }

    private static String createDefaultStyles() {
        return createDefaultAllElementsStyle() +
                createDefaultHtmlStyle() +
                createDefaultBodyStyle();
    }

    private static String createDefaultAllElementsStyle() {
        return "*,*::after,*::before {" +
                "box-sizing: border-box;" +
                "padding: 0;" +
                "margin: 0;" +
                "}";
    }

    private static String createDefaultHtmlStyle() {
        return "html {" +
                "font-size: 62.5%;" +
                "}";
    }

    private static String createDefaultBodyStyle() {
        return "body {" +
                "font-family: Arial, sans-serif;" +
                "font-size: 1.6rem;" +
                "background-color: #f4f4f4;" +
                "color: #333;" +
                "line-height: 1.6;" +
                "height: 100svh;" +
                "display: grid;" +
                "place-items: center;" +
                "}";
    }

    private static String createRestStyle() {
        return "main {" +
                "width: 90%;" +
                "max-width: 600px;" +
                "margin: 0 auto;" +
                "background-color: #fff;" +
                "padding: 2rem;" +
                "border-radius: 10px;" +
                "box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);" +
                "}" +
                "h1 {" +
                "font-size: 2.5rem;" +
                "margin-bottom: 1rem;" +
                "}" +
                "nav {" +
                "display: flex;" +
                "gap: 1rem;" +
                "margin-bottom: 1rem;" +
                "}" +
                "a {" +
                "display: inline-block;" +
                "text-decoration: none;" +
                "color: #333;" +
                "}" +
                "a.active {" +
                "color: blue;" +
                "text-decoration: underline;" +
                "text-underline-offset: .6rem;" +
                "}" +
                "a:hover {" +
                "color: #000;" +
                "}" +
                "form {" +
                "display: flex;" +
                "flex-direction: column;" +
                "width: max-content;" +
                "}" +
                ".form_group {" +
                "display: flex;" +
                "flex-direction: column;" +
                "}" +
                "label {" +
                "margin-bottom: .5rem;" +
                "}" +
                "input[type=\"number\"] {" +
                "width: 100%;" +
                "padding: .5rem;" +
                "margin-bottom: 1rem;" +
                "border: 1px solid #ccc;" +
                "border-radius: 5px;" +
                "}" +
                "select {" +
                "width: 100%;" +
                "padding: .5rem;" +
                "margin-bottom: 1rem;" +
                "border: 1px solid #ccc;" +
                "border-radius: 5px;" +
                "}" +
                "input[type=\"submit\"], .reset-btn {" +
                "padding: 1rem 2rem;" +
                "align-self: flex-start;" +
                "font-size: 1.6rem;" +
                "background-color: blue;" +
                "color: #fff;" +
                "border: none;" +
                "border-radius: .5rem;" +
                "cursor: pointer;" +
                "}" +
                "input[type=\"submit\"]:hover, .reset-btn:hover {" +
                "background-color: #000;" +
                "color: #fff;"+
                "}";
    }
}
