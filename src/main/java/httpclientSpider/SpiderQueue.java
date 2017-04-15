package httpclientSpider;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/4/7.
 */
public class SpiderQueue {
    private static Set<Object> visitedUrl=new HashSet<>();
    public static void addVisitedUrl(String url){
        visitedUrl.add(url);
    }
    public static void removeVisitedUrl(String url){
        visitedUrl.remove(url);
    }
    public static int getVisitedUrlNum(){
        return visitedUrl.size();
    }
    private static Queue unVisitedUrl=new Queue();
    public static Queue getUnVisitedUrl(){
        return unVisitedUrl;
    }
    public static Object dequeueUnVisitedUrl(){
        return unVisitedUrl.deQueue();
    }
    public static void addUnVisitedUrl(String url){
        if (url!=null&&!url.trim().equals("")&&!visitedUrl.contains(url)){
            unVisitedUrl.enQueue(url);
        }
    }
    public static boolean unVisitedIsEmpty(){
        return unVisitedUrl.isEmpty();
    }
}
