

import org.apache.http.HttpEntity;
import org.apache.http.client.*;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Administrator on 2017/4/7.
 */
public class HttpClientTest {
    public static void downloadPage(String path){
        InputStream inputStream=null;
        OutputStream outputStream=null;
        CloseableHttpClient httpClient= HttpClients.createDefault();
        HttpGet get=new HttpGet(path);
        try {
            CloseableHttpResponse response = httpClient.execute(get);
            HttpEntity entity = response.getEntity();
            outputStream =new FileOutputStream("C:\\Users\\Administrator\\Desktop\\图片\\xx.html");
            entity.writeTo(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        downloadPage("http://www.baidu.com");
    }
}
