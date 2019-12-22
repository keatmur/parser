import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.Comparator;

import java.io.IOException;
import java.util.*;
class  ListTitle {
    Element titel ;
    Element time ;
    ListTitle ( Element titel ,Element time ){
        this.titel = titel;
        this.time =time;
    }

    public Element getTitel() {
        return titel;
    }

    public Element getTime() {
        return time;
    }
}
class MyClassComparator implements Comparator
{
    public int compare(Object o1, Object o2) {
        return o1.toString().compareTo(o2.toString());
    }
}
public class main {
    public static void main(String args[]) throws IOException {

        Document document = Jsoup.connect("https://www.udemy.com/course/learn-flutter-dart-to-build-ios-android-apps/").get();
        Elements listName = document.select("#udemy > div.main-content-wrapper > div.main-content > div.container.container--component-margin > div:nth-child(2) > div > div > div > div > div:nth-child(2)>div");

        ArrayList<String> list = new ArrayList<String>();

        for (Element element : listName.select("div.title")) {
            list.add(element.text().toString());
        }

        }
}