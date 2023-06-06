package com.beverage.dao.impl;

import com.beverage.dao.BaseDAO;
import com.beverage.dao.NewsDAO;
import com.beverage.model.News;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 新闻数据访问层实现类
 *
 * @author Administrator
 *
 */
public class NewsDAOImpl implements NewsDAO {

    public static void main(String[] args) {

        NewsDAOImpl daoImpl = new NewsDAOImpl();

        /*
         * News enBuyNews=new News(); enBuyNews.setTitle("今天小雨");
         * enBuyNews.setContent("今天有点冷...");
         *
         * try { int r=daoImpl.addNews(enBuyNews); System.out.println(r); } catch
         * (Exception e) { // TODO Auto-generated catch block e.printStackTrace(); }
         */

        /*
         * News enBuyNews = new News(); enBuyNews.setTitle("今天大雨");
         * enBuyNews.setContent("今天太冷了..."); enBuyNews.setId(704); try { int r =
         * daoImpl.modifyNews(enBuyNews); System.out.println(r); } catch (Exception e) {
         * e.printStackTrace(); }
         */


        /*
         * try { System.out.println(daoImpl.delNews(704)); } catch (Exception e) { //
         * TODO Auto-generated catch block e.printStackTrace(); }
         */

        /*
         * try { List<News> list=daoImpl.findAll();
         *
         * for(News en:list) { System.out.println(en.getTitle()); }
         *
         *
         * } catch (Exception e) { // TODO Auto-generated catch block
         * e.printStackTrace(); }
         */

        try {
            News en=daoImpl.findNewsById(703);

            System.out.println(en.getTitle());

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    BaseDAO bd = new BaseDAO();

    /**
     * 添加新闻
     *
     * @param en
     * @return
     * @throws Exception
     */
    @Override
    public int addNews(News en) throws Exception {

        int r = -1;

        try {

            SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");

            String nowDate = sFormat.format(new Date());

            String sql = "insert into news(title,content,createTime) values(?,?,?)";

            Object param[] = { en.getTitle(), en.getContent(), nowDate };

            r = bd.executeUpdate(sql, param);

        } catch (Exception e) {
            throw e;
        }
        return r;
    }

    /**
     * 修改新闻
     *
     * @param en
     * @return
     * @throws Exception
     */
    @Override
    public int modifyNews(News en) throws Exception {
        int r = -1;
        try {
            String sql = "update news set title=?,content=? where id=? ";

            Object param[] = { en.getTitle(), en.getContent(), en.getId() };

            r = bd.executeUpdate(sql, param);

        } catch (Exception e) {
            throw e;
        }
        return r;
    }

    /**
     * 删除新闻
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public int delNews(int id) throws Exception {
        int r = -1;
        try {
            String sql = "delete from  news where id=? ";

            Object param[] = { id };

            r = bd.executeUpdate(sql, param);

        } catch (Exception e) {
            throw e;
        }
        return r;
    }

    /**
     * 查询所有新闻信息
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<News> findAll() throws Exception {

        List<News> list = new ArrayList<News>();

        try {
            Connection conn = bd.getConnection();
            String sql = "select * from news order by id desc";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                News enBuyNews = new News();
                enBuyNews.setId(rs.getInt("id"));
                enBuyNews.setContent(rs.getString("content"));
                enBuyNews.setTitle(rs.getString("title"));
                enBuyNews.setCreateTime(rs.getDate("createTime"));
                list.add(enBuyNews);
            }
            bd.closeConnection(rs, ps, conn);

        } catch (Exception e) {
            throw e;
        }
        return list;
    }

    /**
     * 根据新闻ID查询新闻信息
     *
     * @return
     * @throws Exception
     */
    @Override
    public News findNewsById(int id) throws Exception {
        News enBuyNews = null;

        try {
            Connection conn = bd.getConnection();
            String sql = "select * from news where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                enBuyNews = new News();
                enBuyNews.setId(rs.getInt("id"));
                enBuyNews.setContent(rs.getString("content"));
                enBuyNews.setTitle(rs.getString("title"));
                enBuyNews.setCreateTime(rs.getDate("createTime"));

            }
            bd.closeConnection(rs, ps, conn);

        } catch (Exception e) {
            throw e;
        }
        return enBuyNews;
    }

}
