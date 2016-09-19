package com.icloud.model;

/**
 * 商户表
 * @author luoqw
 * 2016-9-5下午3:38:08
 */
public class MerchantsSupplier {
    private Integer id;

    private String merchantsName;//商户名称

    private String province;//省

    private String city;//市

    private String area;//区

    private String address;//地址

    private String longitude;//经度

    private String latitude;//纬度

    private String contact;//联系人

    private String phone;//电话

    private String auditStatus;//审核状态，添加是默认为0，管理员审核后改为1

    private String idCard;//身份证号

    private String idCardUrl;//身份证照URL

    private String businessLicense;//营业执照URL

    private String parentId;//上级店铺ID，如为总店则该值为0

    private String paymentChannel;//支付渠道0支付至平台，1支付至自定义公众号

    private String supllierType;//商户类型0供应商，1零售商

    private String storeState;//店铺状态1开启0关闭，不填则默认关闭.审核状态，添加是默认为0，管理员审核后改为1

    private String serviceRadius;//服务半径

    private String merchantsLogoUrl;//商户Logo

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMerchantsName() {
        return merchantsName;
    }

    public void setMerchantsName(String merchantsName) {
        this.merchantsName = merchantsName == null ? null : merchantsName.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus == null ? null : auditStatus.trim();
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getIdCardUrl() {
        return idCardUrl;
    }

    public void setIdCardUrl(String idCardUrl) {
        this.idCardUrl = idCardUrl == null ? null : idCardUrl.trim();
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense == null ? null : businessLicense.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getPaymentChannel() {
        return paymentChannel;
    }

    public void setPaymentChannel(String paymentChannel) {
        this.paymentChannel = paymentChannel == null ? null : paymentChannel.trim();
    }

    public String getSupllierType() {
        return supllierType;
    }

    public void setSupllierType(String supllierType) {
        this.supllierType = supllierType == null ? null : supllierType.trim();
    }

    public String getStoreState() {
        return storeState;
    }

    public void setStoreState(String storeState) {
        this.storeState = storeState == null ? null : storeState.trim();
    }

    public String getServiceRadius() {
        return serviceRadius;
    }

    public void setServiceRadius(String serviceRadius) {
        this.serviceRadius = serviceRadius == null ? null : serviceRadius.trim();
    }

    public String getMerchantsLogoUrl() {
        return merchantsLogoUrl;
    }

    public void setMerchantsLogoUrl(String merchantsLogoUrl) {
        this.merchantsLogoUrl = merchantsLogoUrl == null ? null : merchantsLogoUrl.trim();
    }
}