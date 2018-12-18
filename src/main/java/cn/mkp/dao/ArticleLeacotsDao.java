package cn.mkp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.mkp.entity.ArticleLeacots;

public interface ArticleLeacotsDao {

	int saveArticleLeacots(ArticleLeacots leacots);
	List<ArticleLeacots> getListByArticleId(@Param("articleId")long articleId,@Param("start")long start, @Param("pageSize")long pageSize);
	List<ArticleLeacots> getList(long articleId);
}
