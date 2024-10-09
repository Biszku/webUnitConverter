public abstract class pageCreator {

    public String createPage() {
        return createHead() + createBody(createForm());
    }

    public String createResultPage(String from, String to) {
        return createHead() + createBody(createResultView(from, to));
    }


    private String createHead() {
        return "<!DOCTYPE html>" +
                "<html lang=\"en\">" +
                "<head>" +
                "<meta charset=\"UTF-8\">" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">" +
                "<meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">" +
                "<title>Unit converter</title>" +
                pageStyles.createStyles() +
                "</head>";
    }

    private String createBody(String contentOfPage) {
        return "<body>" +
                "<main>" +
                "<section>" +
                "<h1>Unit converter</h1>" +
                createMenu() +
                contentOfPage +
                "</section>" +
                "</main>" +
                "</body>" +
                "</html>";
    }

    private String createResultView(String from, String to) {
        return "<h2>Result of your calculation</h2>" +
                "<span>" +
                from +
                "</span> = <span>" +
                to +
                "</span>" +
                "<br>" +
                createResetButton();
    }

    abstract String createForm();
    abstract String createMenu();
    abstract String createResetButton();
}
