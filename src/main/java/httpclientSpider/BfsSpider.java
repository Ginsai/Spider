package httpclientSpider;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/4/10.
 */
public class BfsSpider {
    private void initCrawlerWithSeeds(String[] seeds){
        for (int i = 0; i < seeds.length; i++) {
            SpiderQueue.addUnVisitedUrl(seeds[i]);
        }
    }
    public void crawling(String[] seeds){
        initCrawlerWithSeeds(seeds);
        while (!SpiderQueue.unVisitedIsEmpty()&&SpiderQueue.getVisitedUrlNum()<=1000){
          String visitUrl= (String) SpiderQueue.dequeueUnVisitedUrl();
          if (visitUrl==null){
              continue;
          }
           DownTools downTools=new DownTools();
            System.out.println("正在爬取:"+visitUrl);
            String html = downTools.downloadFile(visitUrl);
            SpiderQueue.addVisitedUrl(visitUrl);
            Set<String> urlSet = getUrlSet(html);
            System.out.println("当前队列大小:"+urlSet.size());
            for (String s :
                    urlSet) {
                SpiderQueue.addUnVisitedUrl(s);
            }
        }
    }

    /**
     * 从一个网页中提取所有http链接
     * @param html
     * @return
     */
    private static Set<String> getUrlSet(String html){
        String regex="(http://.*?.com)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher=pattern.matcher(html);
        Set<String> set=new HashSet<>();
        while (matcher.find()){
            String s = matcher.group();
            System.out.println("正在添加网址到队列");
            set.add(s);
        }
        return set;
    }

    public static void main(String[] args) {
        BfsSpider spider = new BfsSpider();
        String[] seeds = new String[]{"http://www.baidu.com"};
        spider.crawling(seeds);
    }
}
