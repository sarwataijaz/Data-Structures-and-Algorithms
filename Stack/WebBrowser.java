public class WebBrowser {
        private LinkedListStack<String> backwardHistory;
        private LinkedListStack<String> forwardHistory;
        private String currentUrl;

        public WebBrowser() {
            backwardHistory = new LinkedListStack<>();
            forwardHistory = new LinkedListStack<>();
            currentUrl = "https://www.google.com";
        }

        public void enterURL(String url) {
            backwardHistory.push(currentUrl);
            currentUrl = url;
        }

        public void goBack() {
            if (!backwardHistory.isEmpty()) {
                forwardHistory.push(currentUrl);
                currentUrl = backwardHistory.pop();
                System.out.println("Backward to: " + currentUrl);
            } else {
                System.out.println("No backward history available.");
            }
        }

        public void goForward() {
            if (!forwardHistory.isEmpty()) {
                backwardHistory.push(currentUrl);
                currentUrl = forwardHistory.pop();
                System.out.println("Forward to: " + currentUrl);
            } else {
                System.out.println("No forward history available.");
            }
        }

        public String getCurrentUrl() {
            return currentUrl;
        }

        public static void main(String[] args) {
            WebBrowser browser = new WebBrowser();

            browser.enterURL("https://www.google.com");
            browser.enterURL("https://www.github.com");
            browser.enterURL("https://www.stackoverflow.com");

            browser.goBack();

            browser.goForward();


        }

}
