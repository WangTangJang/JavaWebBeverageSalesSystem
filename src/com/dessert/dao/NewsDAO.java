package com.dessert.dao;

import com.dessert.model.News;

import java.util.List;
/**
 * 新闻数据访问层接口
 *
 * @author Administrator
 *
 */
public interface NewsDAO {

    /**
     * 添加新闻
     *
     * @param en
     * @return
     * @throws Exception
     */
    public int addNews(News en) throws Exception;

    /**
     * 修改新闻
     *
     * @param en
     * @return
     * @throws Exception
     */
    public int modifyNews(News en) throws Exception;

    /**
     * 删除新闻
     *
     * @param id
     * @return
     * @throws Exception
     */
    public int delNews(int id) throws Exception;

    /**
     * 查询所有新闻信息
     *
     * @return
     * @throws Exception
     */
    public List<News> findAll() throws Exception;

    /**
     * 根据新闻ID查询新闻信息
     *
     * @return
     * @throws Exception
     */
    public News findNewsById(int id) throws Exception;

}
