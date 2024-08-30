package collection.deque.stack;

public class BrowserHistoryTest {

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory();

        browserHistory.visitPage("youtube.com");
        browserHistory.visitPage("google.com");
        browserHistory.visitPage("facebook.com");

        String currentPage1 = browserHistory.goBack();
        System.out.println(currentPage1);

        String currentPage2 = browserHistory.goBack();
        System.out.println(currentPage2);

    }
}
