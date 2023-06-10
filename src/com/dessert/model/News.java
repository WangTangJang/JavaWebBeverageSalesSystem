package com.dessert.model;

import java.util.Date;

/**
 * 新闻实体类
 *
 * @author Administrator
 *
 */
public class News {
    /**
     * 新闻ID
     */
    private int id;
    /**
     * 新闻标题
     */
    private String title;
    /**
     * 新闻内容
     */
    private String content;
    /**
     * 创建时间
     */
    private Date createTime;

    @Override
    public String toString() {
        return "EasyBuyNews [id=" + id + ", title=" + title + ", content=" + content + ", createTime=" + createTime
                + "]";
    }

    public News() {

    }

    public News(int id, String title, String content, Date createTime) {
        super();
        this.id = id;
        this.title = title;
        this.content = content;
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
