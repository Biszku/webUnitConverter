public abstract class pageCreator {

    public String createPage() {
        return createHeadOfPage() + createBodyOfPage(createContent());
    }

    public String createResultPage(String from, String to) {
        return createHeadOfPage() + createBodyOfPage(createResultContent(from, to));
    }


    private String createHeadOfPage() {
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

    private String createBodyOfPage(String contentOfPage) {
        return "<body>" +
                "<main>" +
                "<section>" +
                "<h1>Unit converter</h1>" +
                createMenuContent() +
                contentOfPage +
                "</section>" +
                "</main>" +
                "</body>" +
                "</html>";
    }

    private String createResultContent(String from, String to) {
        return "<h2>Result of your calculation</h2>" +
                "<span>" +
                from +
                "</span> = <span>" +
                to +
                "</span>" +
                "<br>" +
                createResetButton();
    }

    abstract String createContent();
    abstract String createMenuContent();
    abstract String createResetButton();
}
