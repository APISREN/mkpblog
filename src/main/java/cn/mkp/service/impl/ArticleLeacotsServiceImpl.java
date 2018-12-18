package cn.mkp.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mkp.dao.ArticleLeacotsDao;
import cn.mkp.entity.ArticleLeacots;
import cn.mkp.service.ArticleLeacotsService;
@Service
public class ArticleLeacotsServiceImpl implements ArticleLeacotsService {

	@Autowired
	private ArticleLeacotsDao leacotsDao;
	public ArticleLeacots saveArticleLeacots(Long contentId,String desc) {
		
		ArticleLeacots leacots = new ArticleLeacots();
		leacots.setArticleId(contentId);
		leacots.setDesc(desc);
		String username = UUID.randomUUID().toString();
		leacots.setUsername(username);
		leacots.setCreateTime(new Date());
		leacots.setUpdateTime(new Date());
		leacotsDao.saveArticleLeacots(leacots);
		//System.out.println(id);
		return leacots;
	}

	@Override
	public List<ArticleLeacots> getListByArticleId(long articleId,long page,long pageSize) {
		long start = (page-1)*pageSize;
		List<ArticleLeacots> list = leacotsDao.getListByArticleId(articleId,start,pageSize);
		return list;
	}
	@Override
	public List<ArticleLeacots> getList(long articleId) {
		List<ArticleLeacots> list = leacotsDao.getList(articleId);
		return list;
	}

}
