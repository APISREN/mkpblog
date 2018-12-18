package cn.mkp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.mkp.entity.WebArticle;

public interface WebArticleDao {

	/**
	 * 根据分类id查询文章分页列表
	 * @param categoryId
	 * @param start
	 * @param pageSize
	 * @return
	 */
	List<WebArticle> getListBycategoryId(@Param("categoryId")long categoryId, @Param("start")long start, @Param("pageSize")long pageSize);
	
	/**
	 * 查询总计
	 * @param categoryId
	 * @return
	 */
	long getTotal(long categoryId);
	
	/**
	 *  根据id查询文章
	 * @param contentId
	 * @return
	 */
	WebArticle getWebArticleById(long contentId);
	
	/**
	 * 查询所有文章（全部）
	 * @param categoryId
	 * @return
	 */
	List<WebArticle> getList(long categoryId);
}
