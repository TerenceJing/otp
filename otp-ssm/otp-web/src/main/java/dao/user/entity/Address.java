package dao.user.entity;


/**
 * @desc: 收获地址
 */
public class Address {
    private Long id;
    private Long userId;
    private String name;
    private String phoneNo;
    private String province;
    private String city;
    private String addressPostDetail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddressPostDetail() {
        return addressPostDetail;
    }

    public void setAddressPostDetail(String addressPostDetail) {
        this.addressPostDetail = addressPostDetail;
    }
}
