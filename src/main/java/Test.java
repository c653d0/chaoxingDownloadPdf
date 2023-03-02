import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        String url = "https://mooc1.chaoxing.com/mycourse/studentstudy?chapterId=352780738&courseId=214584094&clazzid=59764946&cpi=95191912&enc=eeada553a394c54d81fabbadcef51417&mooc2=1&openc=e6ae0e0485c29cabbef0098e02295942";
        try {
            ArrayList<String> urls = new ArrayList<>();
            Document document = Jsoup.connect(url).get();
            System.out.println(document);
        } catch (IOException ioE) {
            ioE.printStackTrace();
        }
    }
    public static HashMap<String, String> convertCookie(String cookie) {
        HashMap<String, String> cookiesMap = new HashMap<String, String>();
        String[] items = cookie.trim().split(";");
        for (String item : items) cookiesMap.put(item.split("=")[0], item.split("=")[1]);
        return cookiesMap;
    }
}
