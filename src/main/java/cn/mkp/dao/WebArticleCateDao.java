package cn.mkp.dao;

import java.util.List;

import cn.mkp.entity.WebArticle;
import cn.mkp.entity.WebArticleCategory;

public interface WebArticleCateDao {

	List<WebArticleCategory> getCategoryList();
	WebArticleCategory selectCategoryById(long id);
}
