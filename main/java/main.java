import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.Comparator;

import java.io.IOException;
import java.util.*;
class  ListTitle {
    String titel ;
    String time ;
    ListTitle ( String titel ,String time ){
        this.titel = titel;
        this.time =time;
    }

    public String getTitel() {
        return titel;
    }

    public String getTime() {
        return time;
    }
}
class SortByCost implements Comparator<ListTitle> {
    public int compare(ListTitle a, ListTitle b) {
        int res ;
        res = a.getTime().compareTo(b.getTime());
        if ( res <0 ) return -1;
        else if ( res==0) return 0;
        else return 1;
    }
}
public class main {
    public static void main(String args[]) throws IOException {

        Document document = Jsoup.connect("https://www.udemy.com/course/learn-flutter-dart-to-build-ios-android-apps/").get();
        Elements listName = document.select("#udemy > div.main-content-wrapper > div.main-content > div.container.container--component-margin > div:nth-child(2) > div > div > div > div > div:nth-child(2)>div");

        ArrayList<ListTitle> list = new ArrayList<ListTitle>();
        ArrayList<String> title =new ArrayList<String>();
        ArrayList<String> time =new ArrayList<String>();
        for (Element element : listName.select("div.title")) {
            title.add(element.select("a").text().toString());
        }
        for (Element element : listName.select("span.content-summary")) {
            time.add(element.text().toString());
        }
        for (int i = 0 ; i <title.size(); i++ ) {
            list.add( new ListTitle(title.get(i),time.get(i)));
        }
        list.sort(new SortByCost());
        for(ListTitle s : list) {
            System.out.println(s.getTitel()+" "+s.getTime());
        }

    }
}