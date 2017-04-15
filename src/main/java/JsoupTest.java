import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by Administrator on 2017/4/13.
 */
public class JsoupTest {
    public static void main(String[] args) {
        String html="<a target=\"_blank\" title=\"台电（Teclast）Tbook 16 Power 二合一平板电脑 双系统 11.6英寸(Intel X7 8G+64G 1920x1080 Win10+安卓)\" href=\"//item.jd.com/3560725.html\" onclick=\"searchlog(1,3560725,5,2,'','flagsClk=1614811784')\">\n" +
                "\t\t\t\t\t\t\t<img width=\"220\" height=\"220\" class=\"err-product\" data-img=\"1\" src=\"//img10.360buyimg.com/n7/jfs/t3748/286/1862288330/217887/6ad1ec48/5832bd42N14c99d79.jpg\" />\n" +
                "\t\t\t\t\t\t</a>\n" +
                "\t\t\t\t\t\t<div data-catid=\"2694\" data-jq=\"1\" data-dq=\"1\" data-venid=\"1000000167\"></div>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t<div class=\"p-price\">\n" +
                "<strong class=\"J_3560725\" data-price=\"1969.00\"><em>¥</em><i>1969.00</i></strong>\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t<div class=\"p-name p-name-type-2\">\n" +
                "\t\t\t\t\t\t<a target=\"_blank\" title=\"台电（Teclast）Tbook 16 Power 二合一平板电脑 双系统 11.6英寸(Intel X7 8G+64G 1920x1080 Win10+安卓)\" href=\"//item.jd.com/3560725.html\" onclick=\"searchlog(1,3560725,5,1,'','flagsClk=1614811784')\">\n" +
                "\t\t\t\t\t\t\t<em>台电（Teclast）Tbook 16 Power 二合一平板电脑 双系统 11.6英寸(Intel X7 8G+64G 1920x1080 <font class=\"skcolor_ljg\">Win</font>10+安卓)</em>\n" +
                "\t\t\t\t\t\t\t<i class=\"promo-words\" id=\"J_AD_3560725\"></i>\n" +
                "\t\t\t\t\t\t</a>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t<div class=\"p-commit\">\n" +
                "\t\t\t\t\t\t<strong>已有<a id=\"J_comment_3560725\" target=\"_blank\" href=\"//item.jd.com/3560725.html#comment\" onclick=\"searchlog(1,3560725,5,3,'','flagsClk=1614811784')\">1400+</a>人评价</strong>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t<div class=\"p-shop\" data-selfware=\"1\" data-score=\"5\" data-reputation=\"92\" data-shopid=\"1000000167\"></div>\n" +
                "\t\t\t\t\t<div class=\"p-icons\" id=\"J_pro_3560725\">\n" +
                "\t\t\t\t\t\t<img src=\"//img14.360buyimg.com/uba/jfs/t3139/175/3796130719/1386/3a9cc545/57f8ac4fN87e531d5.png\" alt=\"\" width=\"44\" height=\"16\" class=\"goods-icons-img J-picon-tips J-picon-fix\" data-tips=\"京东自营，品质保障\">\n" +
                "\t\t\t\t\t\t<i class=\"goods-icons-s1 J-picon-tips\" data-tips=\"本商品支持货到付款\">货到付款</i>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t<div class=\"p-operate\">\n" +
                "\t\t\t\t\t\t<a class=\"p-o-btn contrast J_contrast\" data-sku=\"3560725\" href=\"javascript:;\" onclick=\"searchlog(1,3560725,5,6,'','flagsClk=1614811784')\"><i></i>对比</a>\n" +
                "\t\t\t\t\t\t<a class=\"p-o-btn focus J_focus\" data-sku=\"3560725\" href=\"javascript:;\" onclick=\"searchlog(1,3560725,5,5,'','flagsClk=1614811784')\"><i></i>关注</a>\n" +
                "\t\t\t\t\t\t<a class=\"p-o-btn addcart\" data-stock=\"3560725\" data-stock-val=\"1\" data-disable-notice=\"0\" data-presale=\"0\" href=\"//cart.jd.com/gate.action?pid=3560725&pcount=1&ptype=1\" target=\"_blank\" onclick=\"searchlog(1,3560725,5,4,'','flagsClk=1614811784')\" data-limit=\"0\"><i></i>加入购物车</a>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t</div>\n" +
                "</li>\n" +
                "<li data-sku=\"3766957\" class=\"gl-item\">\n" +
                "\t<div class=\"gl-i-wrap\">\n" +
                "\t\t\t\t\t<div class=\"p-img\">\n" +
                "\t\t\t\t\t\t<a target=\"_blank\" title=\"台电（Teclast）Tbook 10S 二合一平板电脑 双系统 10.1英寸(Intel X5 4G内存 1920x1200 正版Win10+安卓)\" href=\"//item.jd.com/3766957.html\" onclick=\"searchlog(1,3766957,6,2,'','flagsClk=1615868552')\">\n" +
                "\t\t\t\t\t\t\t<img width=\"220\" height=\"220\" class=\"err-product\" data-img=\"1\" src=\"//img12.360buyimg.com/n7/jfs/t3214/17/4902265118/220806/cf687505/5858e1c8Nb80e36bb.jpg\" />\n" +
                "\t\t\t\t\t\t</a>\n" +
                "\t\t\t\t\t\t<div data-catid=\"2694\" data-jq=\"1\" data-dq=\"1\" data-venid=\"1000000167\"></div>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t<div class=\"p-price\">\n" +
                "<strong class=\"J_3766957\" data-price=\"1049.00\"><em>¥</em><i>1049.00</i></strong>\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t<div class=\"p-name p-name-type-2\">\n" +
                "\t\t\t\t\t\t<a target=\"_blank\" title=\"台电（Teclast）Tbook 10S 二合一平板电脑 双系统 10.1英寸(Intel X5 4G内存 1920x1200 正版Win10+安卓)\" href=\"//item.jd.com/3766957.html\" onclick=\"searchlog(1,3766957,6,1,'','flagsClk=1615868552')\">\n" +
                "\t\t\t\t\t\t\t<em><span class=\"p-tag\">已浏览品牌</span>台电（Teclast）Tbook 10S 二合一平板电脑 双系统 10.1英寸(Intel X5 4G内存 1920x1200 正版<font class=\"skcolor_ljg\">Win</font>10+安卓)</em>\n" +
                "\t\t\t\t\t\t\t<i class=\"promo-words\" id=\"J_AD_3766957\"></i>\n" +
                "\t\t\t\t\t\t</a>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t<div class=\"p-commit\">\n" +
                "\t\t\t\t\t\t<strong>已有<a id=\"J_comment_3766957\" target=\"_blank\" href=\"//item.jd.com/3766957.html#comment\" onclick=\"searchlog(1,3766957,6,3,'','flagsClk=1615868552')\">2000+</a>人评价</strong>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t<div class=\"p-shop\" data-selfware=\"1\" data-score=\"5\" data-reputation=\"92\" data-shopid=\"1000000167\"></div>\n" +
                "\t\t\t\t\t<div class=\"p-icons\" id=\"J_pro_3766957\">\n" +
                "\t\t\t\t\t\t<img src=\"//img14.360buyimg.com/uba/jfs/t3139/175/3796130719/1386/3a9cc545/57f8ac4fN87e531d5.png\" alt=\"\" width=\"44\" height=\"16\" class=\"goods-icons-img J-picon-tips J-picon-fix\" data-tips=\"京东自营，品质保障\">\n" +
                "\t\t\t\t\t\t<i class=\"goods-icons-s1 J-picon-tips\" data-tips=\"本商品支持货到付款\">货到付款</i>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t<div class=\"p-operate\">\n" +
                "\t\t\t\t\t\t<a class=\"p-o-btn contrast J_contrast\" data-sku=\"3766957\" href=\"javascript:;\" onclick=\"searchlog(1,3766957,6,6,'','flagsClk=1615868552')\"><i></i>对比</a>\n" +
                "\t\t\t\t\t\t<a class=\"p-o-btn focus J_focus\" data-sku=\"3766957\" href=\"javascript:;\" onclick=\"searchlog(1,3766957,6,5,'','flagsClk=1615868552')\"><i></i>关注</a>\n" +
                "\t\t\t\t\t\t<a class=\"p-o-btn addcart\" data-stock=\"3766957\" data-stock-val=\"1\" data-disable-notice=\"0\" data-presale=\"0\" href=\"//cart.jd.com/gate.action?pid=3766957&pcount=1&ptype=1\" target=\"_blank\" onclick=\"searchlog(1,3766957,6,4,'','flagsClk=1615868552')\" data-limit=\"0\"><i></i>加入购物车</a>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t</div>\n" +
                "</li>\n" +
                "<li data-sku=\"4215536\" class=\"gl-item\">\n" +
                "\t<div class=\"gl-i-wrap\">\n" +
                "\t\t\t\t\t<div class=\"p-img\">";
        Document document = Jsoup.parse(html);
        Elements elements = document.select("div[data-catid]");
        System.out.println(elements);

    }
}
