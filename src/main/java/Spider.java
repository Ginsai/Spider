import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/4/4.
 */
public class Spider {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        // String url="http://tu.duowan.com/m/meinv";
        String url = "https://www.zhihu.com/explore/recommendations";
        String result = sendGet(url);
        // regexString(result, "<img[\\s]+src[\\s]*=\\\"(.*?)\\\"",list);
        regexString(result, "question_link.+?>(.+?)<", list);
        System.out.println(result);
        System.out.println(list);
//        for (String s:list
//             ) {
//            StringBuffer stringBuffer=new StringBuffer();
//            BufferedInputStream inputStream=null;
//            FileOutputStream outputStream=null;
//            try {
//                URL realURL=new URL(s);
//                URLConnection connection = realURL.openConnection();
//                connection.connect();
//                int name= new Random().nextInt(1000);
//                 inputStream = new BufferedInputStream(connection.getInputStream());
//                 outputStream = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\图片\\"+name+".jpg");
//                int size=0;
//                byte[] buf=new byte[1024];
//                while ((size=inputStream.read(buf))!=-1){
//                    outputStream.write(buf,0,size);
//                }
//                outputStream.flush();
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }finally {
//                try {
//                    outputStream.close();
//                    inputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//            }}
        System.out.println("执行完毕");

    }

    static ArrayList match(String url, String match) {
        ArrayList<String> list = new ArrayList<String>();
        String result = sendGet(url);
        regexString(result, match, list);
        return list;
    }

    /**
     *
     * @param targetStr 目标字符串
     * @param patternStr 匹配字符串
     * @param list
     */
    static void regexString(String targetStr, String patternStr, ArrayList<String> list) {
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(targetStr);
        while (matcher.find()) {
            list.add(matcher.group(1));
        }

    }

    /**
     *
     * @param url
     * @return 返回访问到的网址的字符串结果
     */
    static String sendGet(String url) {
        // 定义即将访问的链接
        // String url = "http://www.baidu.com";
        // 定义一个字符串用来存储网页内容
        StringBuffer stringBuffer = new StringBuffer();
        // 定义一个缓冲字符输入流
        BufferedReader in = null;
        try {
            // 将string转成url对象
            URL realUrl = new URL(url);
            // 初始化一个链接到那个url的连接
            URLConnection connection = realUrl.openConnection();
            // 开始实际的连接
            connection.connect();
            // 初始化 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            // 用来临时存储抓取到的每一行的数据
            String line;
            while ((line = in.readLine()) != null) {
                //遍历抓取到的每一行并将其存储到result里面
                stringBuffer.append(line);
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return stringBuffer.toString();
    }
    static ArrayList<Zhihu> getZhihu(String zhihuUrl){
                String targetStr = sendGet(zhihuUrl);
                ArrayList<Zhihu> resultList=new ArrayList<Zhihu>();
                //正则表达式
                String question="question_link.*?>(.*?)<";
                String url="question_link\" href=\"(.*?)\"";
                String urlDescription="class=\"RichText\">(.*?)</span>";
                String answers="CopyrightRichText-richText\">(.*?)</span>";
                //正则匹配
                Pattern questionPattern=Pattern.compile(question);
                Pattern urlPattern = Pattern.compile(url);
                Pattern answersPattern = Pattern.compile(answers);
                Pattern desciptionPattern = Pattern.compile(urlDescription);
                Matcher questionMatcher =questionPattern.matcher(targetStr);
                Matcher urlMatcher = urlPattern.matcher(targetStr);
                while (urlMatcher.find()&&questionMatcher.find()){
                    Zhihu zhihu=new Zhihu();
            //问题和问题url匹配
            zhihu.setQuestion(questionMatcher.group(1));
            String questionUrl="https://www.zhihu.com"+urlMatcher.group(1);
            System.out.println("正在抓取："+questionUrl);
            zhihu.setUrl(questionUrl);
            //根据问题url获取url页面的信息
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String questionPage = sendGet(getRightUrl(questionUrl));
            //问题描述和答案匹配
            Matcher descriptionMatcher = desciptionPattern.matcher(questionPage);
            //添加问题描述
            while (descriptionMatcher.find()){
                zhihu.setQuestionDescription(descriptionMatcher.group(1));
            }
            Matcher answersMatcher = answersPattern.matcher(questionPage);
            ArrayList<String> answersList=new ArrayList<String>();
            //添加答案组
            while (answersMatcher.find()){
                answersList.add(answersMatcher.group(1));
            }
            zhihu.setAnswers(answersList);
            resultList.add(zhihu);
        }
        return resultList;
    }

    /**
     * https://www.zhihu.com/question/20265972/answer/155597903
     * 变为https://www.zhihu.com/question/20265972
     * @param url
     * @return
     */
    private static String getRightUrl(String url){
        String[] answers = url.split("/answer");
        return answers[0];
    }

    /**
     * 创建文件
     * @param filePath
     * @return
     */
    public static boolean createFile(String filePath){
        boolean isSuccess=true;
        String filePathTurn = filePath.replaceAll("\\\\", "/");
        //获取文件夹名
        String substring = filePathTurn.substring(0,filePathTurn.lastIndexOf("/"));
        //创建文件夹
        File fileDir=new File(substring);
        isSuccess=fileDir.mkdir();
        //创建文件
        File file = new File(filePathTurn);
        try {
            isSuccess= file.createNewFile();
        } catch (IOException e) {
            isSuccess=false;
            e.printStackTrace();
        }
        return isSuccess;
    }
     public static boolean writeIntoFile(String content,String filePath,boolean isAppend){
               boolean isSuccess=true;
         //获取文件夹名
         String substring = filePath.substring(0,filePath.lastIndexOf("/"));
         //创建文件夹
         File fileDir=new File(substring);
         isSuccess=fileDir.mkdir();
         //创建文件
         File file = new File(filePath);
         try {
             isSuccess= file.createNewFile();
         } catch (IOException e) {
             isSuccess=false;
             e.printStackTrace();
         }
         FileWriter writer=null;
         try {
             writer=new FileWriter(file,isAppend);
             writer.write(content);
             writer.flush();
         } catch (IOException e) {
             isSuccess=false;
             e.printStackTrace();
         }finally {
                 try {
                     if (writer!=null) {
                         writer.close();
                     }
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
             return isSuccess;
         }

}
