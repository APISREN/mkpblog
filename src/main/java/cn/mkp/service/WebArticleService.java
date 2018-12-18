package cn.mkp.service;

import java.util.List;

import cn.mkp.entity.WebArticle;


public interface WebArticleService {

	/**
	 * 根据分类id查询文章分页列表
	 * @param categoryId
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public List<WebArticle> getListByCategoryId(long categoryId, long page, long pageSize);
	/**
	 * 查询分类文章总数
	 * @param categoryId
	 * @return
	 */
	public long getTotal(long categoryId);
	/**
	 * 根据内容id查询内容
	 * @param contentId
	 * @return
	 */
	public WebArticle getWebArticleById(long contentId);
	/**
	 * 查询所有分类的文章（不分页）
	 * @param categoryId
	 * @return
	 */
	public List<WebArticle> getList(long categoryId);
}
