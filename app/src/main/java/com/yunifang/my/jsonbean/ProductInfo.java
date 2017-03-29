package com.yunifang.my.jsonbean;


public class ProductInfo extends BaseInfo {
    private String imageUrl;
    private String name;
    private String sid;
    private double price;
    private int position;// 绝对位置，只在ListView构造的购物车中，在删除时有效
    private int count;
    private boolean check;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ProductInfo() {
        super();
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public ProductInfo(String name, String imageUrl, String sid, double price, int count, boolean check) {

        this.imageUrl = imageUrl;
        this.name = name;
        this.price = price;
        this.sid = sid;
        this.count = count;
        this.check = check;

    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
