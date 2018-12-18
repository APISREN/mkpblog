package cn.mkp.entity;

import java.util.Date;
import java.util.List;

public class WebArticleCategory {

	private long id;
	private String name;
	private long num;
	private List<WebArticle> articleList;
	
	public List<WebArticle> getArticleList() {
		return articleList;
	}
	public void setArticleList(List<WebArticle> articleList) {
		this.articleList = articleList;
	}
	public long getNum() {
		return num;
	}
	public void setNum(long num) {
		this.num = num;
	}
	private Date createTime;
	private Date updateTime;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}
