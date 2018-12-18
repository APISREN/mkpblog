package cn.mkp.service;

import java.util.List;

import cn.mkp.entity.WebArticle;
import cn.mkp.entity.WebArticleCategory;


public interface WebArticleCateService {

	/**
	 * 查询文章分类列表
	 * @return
	 */
	public List<WebArticleCategory> getCategoryList();
	/**
	 * 根据分类id查询分类
	 * @param id
	 * @return
	 */
	WebArticleCategory selectCategoryById(long id);
}
