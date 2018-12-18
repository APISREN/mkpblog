package cn.mkp.service;

import java.util.List;

import cn.mkp.entity.ArticleLeacots;

public interface ArticleLeacotsService {

	ArticleLeacots saveArticleLeacots(Long contentId,String desc);
	List<ArticleLeacots> getListByArticleId(long articleId, long page, long pageSize);
	List<ArticleLeacots> getList(long articleId);
}
