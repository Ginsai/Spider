package fangtianxia;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/13.
 */
public class HtmlParse {
    public static ArrayList<AddressModel> addressParse(String html){
        Document document = Jsoup.parse(html);
        Elements elements = document.select("div[class=houseList]").select("dl");
        ArrayList<AddressModel> list=new ArrayList<>();
        for (Element element:elements
             ) {
            //条目id
            String id = element.attr("id");
            String title = element.select("dd").select("p").select("a").attr("title");
            String url = "http://esf.cd.fang.com"+element.select("dd").select("p").select("a").attr("href");
            AddressModel addressModel=new AddressModel();
            addressModel.setId(id);
            addressModel.setTitle(title);
            addressModel.setUrl(url);
            list.add(addressModel);
        }
        return list;
    }
    public static ContentModel contentParse(String html){
        Document document = Jsoup.parse(html);
        Element element = document.select("div[class=inforTxt]").first();
        String phone = element.select("div[class=phone_top]").select("p").select("label").text();
        String price = element.select("dl").select("dt").select("span[class=red20b]").text()+"万";
        String houseId= document.select("p[class=gray9]").select("span[class=mr10]").text();
        String proportion = element.select("dl").select("dd[class=gray6]").select("span[class=black]").text();
        String compoundName = element.select("dl").select("dt").select("span[class=gray6]").text();
        String description = document.select("div[class=describe mt10]").select("div[onselectstart]").select("div[style]").text();
        ContentModel contentModel=new ContentModel(phone,description,houseId,price,proportion,compoundName);
        return contentModel;
    }
    public static int getPageNum(String html){
        Document document=Jsoup.parse(html);
        String text = document.select("div[class=fanye gray6]").select("span[class=txt]").text();
        int num = Integer.parseInt(text.replaceAll("\\D", ""));//将中文替换成""
        return num;
    }
}
