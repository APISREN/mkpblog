package cn.mkp.entity;

import java.util.Date;
import java.util.List;

public class ArticleLeacots {

	/*
	`id` bigint(20) NOT NULL,
	  `arti_id` bigint(20) NOT NULL,
	  `username` varchar(255) NOT NULL COMMENT '留言名字',
	  `content` text NOT NULL COMMENT '留言内容',
	  `pic` varchar(255) DEFAULT NULL,
	  `create_time` datetime NOT NULL COMMENT '留言时间',
	  `update_time` datetime NOT NULL,*/
	private long id;
	private long articleId;
	private String username;
	private String desc;
	private String pic;
	private Date createTime;
	private Date updateTime;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getArticleId() {
		return articleId;
	}
	public void setArticleId(long articleId) {
		this.articleId = articleId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
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
	@Override
	public String toString() {
		return "ArtiLeacots [id=" + id + ", articleId=" + articleId + ", username=" + username + ", desc=" + desc
				+ ", pic=" + pic + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}
}
