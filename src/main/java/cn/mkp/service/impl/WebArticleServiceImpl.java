package cn.mkp.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mkp.dao.WebArticleDao;
import cn.mkp.entity.WebArticle;
import cn.mkp.service.WebArticleService;
/**
 * 文章列表查询
 * @author mkp
 *
 */
@Service
public class WebArticleServiceImpl implements WebArticleService {

	@Autowired
	private WebArticleDao articleDao;
	/**
	 * 根据分类id查询文章分页列表
	 */
	public List<WebArticle> getListByCategoryId(long categoryId,long page, long pageSize) {
		long start = (page-1)*pageSize;
		List<WebArticle> list = articleDao.getListBycategoryId(categoryId,start,pageSize);
		return list;
	}
	/**
	 * 查询总计
	 */
	@Override
	public long getTotal(long categoryId) {
		long total = articleDao.getTotal(categoryId);
		return total;
	}
	/**
	 * 根据id查询文章
	 */
	@Override
	public WebArticle getWebArticleById(long contentId) {
		
			WebArticle article = articleDao.getWebArticleById(contentId);
			return article;
	}
	/**
	 * 查询所有文章（全部）
	 */
	@Override
	public List<WebArticle> getList(long categoryId) {
		List<WebArticle> articleList = articleDao.getList(categoryId);
		return articleList;
	}
	
}
