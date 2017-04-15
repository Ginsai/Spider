package fangtianxia;

/**
 * Created by Administrator on 2017/4/13.
 */
public class ContentModel {
    private String phone;
    private String description;
    private String houseId;
    private String price;
    private String proportion;
    private String compoundName;

    public ContentModel() {
    }
    public ContentModel(String phone, String description, String houseId, String price, String proportion, String compoundName) {
        this.phone = phone;
        this.description = description;
        this.houseId = houseId;
        this.price = price;
        this.proportion = proportion;
        this.compoundName = compoundName;
    }

    @Override
    public String toString() {
        return "ContentModel{" +
                "phone='" + phone + '\'' +
                ", description='" + description + '\'' +
                ", houseId='" + houseId + '\'' +
                ", price='" + price + '\'' +
                ", proportion='" + proportion + '\'' +
                ", compoundName='" + compoundName + '\'' +
                '}';
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProportion() {
        return proportion;
    }

    public void setProportion(String proportion) {
        this.proportion = proportion;
    }

    public String getCompoundName() {
        return compoundName;
    }

    public void setCompoundName(String compoundName) {
        this.compoundName = compoundName;
    }
}
