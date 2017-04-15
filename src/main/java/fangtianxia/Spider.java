package fangtianxia;

import jingdong.HtmlParse;
import jingdong.JDModel;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/4/13.
 */
public class Spider {
    public static String crawling(String url){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet=new HttpGet(url);
        CloseableHttpResponse response=null;
        String html=null;//待解析的页面
        try {
            response= httpClient.execute(httpGet);
        } catch (IOException e) {
            System.out.println("请求网站异常");
            e.printStackTrace();
        }
        HttpEntity entity = response.getEntity();
        StatusLine statusLine = response.getStatusLine();
        int statusCode = statusLine.getStatusCode();
        if (statusCode!=200){
            System.out.println("返回状态码异常："+statusCode);
        }
        try {
            html = EntityUtils.toString(entity, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return html;
    }
}
