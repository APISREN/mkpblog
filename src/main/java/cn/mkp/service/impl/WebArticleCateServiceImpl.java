package cn.mkp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mkp.dao.WebArticleCateDao;
import cn.mkp.entity.WebArticleCategory;
import cn.mkp.service.WebArticleCateService;
/**
 * 文章列表查询
 * @author Index
 *
 */
@Service
public class WebArticleCateServiceImpl implements WebArticleCateService {

	@Autowired
	private WebArticleCateDao articleCateDao;

	/**
	 * 文章分类列表
	 */
	@Override
	public List<WebArticleCategory> getCategoryList() {
		List<WebArticleCategory> list = articleCateDao.getCategoryList();
		return list;
	}
	/**
	 * 根据id查询分类
	 */
	@Override
	public WebArticleCategory selectCategoryById(long id) {
		WebArticleCategory category = articleCateDao.selectCategoryById(id);
		return category;
	}


}
