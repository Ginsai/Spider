package jingdong;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/12.
 */
public class HtmlParse {
    public static List<JDModel> parse(String html){
        Document document = Jsoup.parse(html);
        Elements elements = document.select("ul[class=gl-warp clearfix]").select("li[data-sku]");
        ArrayList<JDModel> list=new ArrayList<JDModel>();
        for (Element element:elements
             ) {
            String id = element.attr("data-sku");
            String price = element.select("div[class=gl-i-wrap]").select("div[class=p-price]").attr("data-price");
            String title = element.select("div[class=gl-i-wrap]").select("div[class=p-name p-name-type-2]").select("a").select("em").text();
            String num = element.select("div[class=gl-i-wrap]").select("div[class=p-commit]").select("strong").select("a").text();
            JDModel jdModel=new JDModel(id,price,title,num);
            list.add(jdModel);
        }
        return list;
    }
}
