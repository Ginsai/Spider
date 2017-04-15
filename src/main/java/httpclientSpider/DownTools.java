package httpclientSpider;

import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.*;

/**
 * Created by Administrator on 2017/4/10.
 */
public class DownTools {
    /**
     * 根据 URL 和网页类型生成需要保存的网页的文件名，去除 URL 中的非文件名字符
     */
    private String getFileNameByUrl(String url, String contentType) {
        //移除http://字符串
        url.substring(7);
        //确认抓取的页面为text/html类型
        if (contentType.indexOf("html") != -1) {
            // 把所有的url中的特殊符号转化成下划线
            url = url.replaceAll("[\\?/:*|<>\"]", "_") + ".html";
        } else {
            url = url.replaceAll("[\\?/:*|<>\"]", "_") + "."
                    + contentType.substring(contentType.lastIndexOf("/") + 1);
        }
        return url;
    }

    /**
     * 保存网页字节数组到本地文件，filePath 为要保存的文件的相对地址
     */
    private void saveToLocal(InputStream inputStream, String filePath) {
        try {
            FileOutputStream outputStream = new FileOutputStream(new File(filePath));
            int len = inputStream.available();
            if (len <= 1024 * 1024) {
                byte[] bytes = new byte[len];
                inputStream.read(bytes);
                outputStream.write(bytes);
            } else {
                int size = 0;
                byte[] bytes = new byte[1024 * 1024];
                while ((size = inputStream.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, size);
                }

            }
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String downloadFile(String url) {
        String filePath = null;
        InputStream contentInputStream = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet get = new HttpGet(url);
        StringBuffer stringBuffer=new StringBuffer();
        try {
            CloseableHttpResponse response = httpClient.execute(get);
            HttpEntity entity = response.getEntity();
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if (statusCode != 200) {
                System.err.println("有一丢丢问题：" + statusLine);
            } else {
                //处理http相应内容
                contentInputStream = entity.getContent();
                filePath = "C:\\Users\\Administrator\\Desktop\\图片\\" + getFileNameByUrl(url, response.getLastHeader("Content-Type").getValue());
                saveToLocal(contentInputStream, filePath);
               BufferedReader reader=new BufferedReader(new InputStreamReader(contentInputStream));
               String line;
                while ((line=reader.readLine())!=null){
                       stringBuffer.append(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (contentInputStream!=null){
                    contentInputStream.close();
                }
                if (httpClient!=null){
                    httpClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringBuffer.toString();
    }
}

