import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/4/6.
 */
public class Test {
    public static void main(String[] args) {
//        ArrayList<Zhihu> zhihu = Spider.getZhihu("https://www.zhihu.com/explore/recommendations");
//        for (Zhihu z:zhihu
//             ) {
//            Spider.writeIntoFile(z.writeToString(),"C:/Users/Administrator/Desktop/图片/知乎/zhihu.text",true);
//        }
//       String match="CopyrightRichText-richText\">(.*?)</span>";
//        ArrayList list = Spider.match("https://www.zhihu.com/question/20265972/answer/155597903", match);
//        System.out.println(list);
        Pattern pattern=Pattern.compile("(\"http://.*?\\.html\")");
        String s="\"http://www.baidu.html\"";
        Matcher matcher=pattern.matcher(s);
        while (matcher.find()){
            System.out.println(matcher.group(1));
        }
    }
}
