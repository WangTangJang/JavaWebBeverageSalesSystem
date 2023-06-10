package com.dessert.model;

import java.sql.Date;

/**
 * 购物车实体类
 */
public class Shopping {
    /**
     * 编号
     */
    private int shoppingid;
    /**
     * 商品编号
     */
    private int productid;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 商品价格
     */
    private float price;
    /**
     * 商品库存
     */
    private float stock;

    /**
     * 用户ID
     */
    private int userid;

    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 购买数量
     */
    private int number;
    /**
     * 加入购物车日期
     */
    private Date createTime;

    /**
     * 商品图片
     */
    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getShoppingid() {
        return shoppingid;
    }

    public void setShoppingid(int shoppingid) {
        this.shoppingid = shoppingid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getStock() {
        return stock;
    }

    public void setStock(float stock) {
        this.stock = stock;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
