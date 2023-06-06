package com.beverage.model;
/**
 * 产品实体类
 *
 * @author Administrator
 *
 */
public class Product {
    /**
     * 饮品编号
     */
    private int id;
    /**
     * 饮品名称
     */
    private String name;
    /**
     * 饮品描述
     */
    private String description;
    /**
     * 饮品价格
     */
    private float price;
    /**
     * 饮品库存
     */
    private int stock;
    /**
     * 饮品一级分类
     */
    private int categoryLevel1Id;
    /**
     * 饮品二级分类
     */
    private int categoryLevel2Id;
    /**
     * 饮品三级分类
     */
    private int categoryLevel3Id;
    /**
     * 饮品图片
     */
    private String fileName;
    /**
     * 饮品删除状态(0 正常 1 已删除)
     */
    private int isDelete;
    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
                + ", stock=" + stock + ", categoryLevel1Id=" + categoryLevel1Id + ", categoryLevel2Id="
                + categoryLevel2Id + ", categoryLevel3Id=" + categoryLevel3Id + ", fileName=" + fileName + ", isDelete="
                + isDelete + "]";
    }


    public Product(){}


    public Product(int id, String name, String description, float price, int stock, int categoryLevel1Id,
                          int categoryLevel2Id, int categoryLevel3Id, String fileName, int isDelete) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.categoryLevel1Id = categoryLevel1Id;
        this.categoryLevel2Id = categoryLevel2Id;
        this.categoryLevel3Id = categoryLevel3Id;
        this.fileName = fileName;
        this.isDelete = isDelete;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public int getCategoryLevel1Id() {
        return categoryLevel1Id;
    }
    public void setCategoryLevel1Id(int categoryLevel1Id) {
        this.categoryLevel1Id = categoryLevel1Id;
    }
    public int getCategoryLevel2Id() {
        return categoryLevel2Id;
    }
    public void setCategoryLevel2Id(int categoryLevel2Id) {
        this.categoryLevel2Id = categoryLevel2Id;
    }
    public int getCategoryLevel3Id() {
        return categoryLevel3Id;
    }
    public void setCategoryLevel3Id(int categoryLevel3Id) {
        this.categoryLevel3Id = categoryLevel3Id;
    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public int getIsDelete() {
        return isDelete;
    }
    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

}
