package fangtianxia;

import jingdong.*;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/14.
 */
public class Main {
    public static void main(String[] args) {
        String url="http://esf.cd.fang.com/house/i31/";
        String html = Spider.crawling(url);
        int pageNum = HtmlParse.getPageNum(html);
        int count=0;
        for (int i = 0; i < pageNum; i++) {
            String url1="http://esf.cd.fang.com/house/i3"+i;
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String html1 = Spider.crawling(url1);
            ArrayList<AddressModel> addressModels = HtmlParse.addressParse(html1);
            for (AddressModel address:addressModels
                 ) {
                count++;
                System.out.println("正在爬取第"+count+"个页面。。。");
                String url2=address.getUrl();
                String html2 = Spider.crawling(url2);
                ContentModel contentModel = HtmlParse.contentParse(html2);
                System.out.println(contentModel);
            }
        }
    }
}
