package jingdong;

/**
 * Created by Administrator on 2017/4/12.
 */
public class JDModel {
    private String id;
    private String price;
    private String title;
    private String evaluationNum;

    public JDModel(String id, String price, String title, String evaluationNum) {
        this.id = id;
        this.price = price;
        this.title = title;
        this.evaluationNum = evaluationNum;
    }
    public JDModel(){}
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEvaluationNum() {
        return evaluationNum;
    }

    public void setEvaluationNum(String evaluationNum) {
        this.evaluationNum = evaluationNum;
    }

    @Override
    public String toString() {
        return "商品id："+id+" 商品名字："+title+" 商品售价："+" 已有"+evaluationNum+"人评价";
    }
}
