package fangtianxia;

/**
 * Created by Administrator on 2017/4/13.
 */
public class AddressModel {
    //记录首页上的每条房产链接的基本信息
    private String id;
    private String title;
    private String url;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
