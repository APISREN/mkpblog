package cn.mkp.entity;

import java.util.Date;

public class WebLog {
	/*
	 `id` bigint(10) NOT NULL AUTO_INCREMENT,
	  `num` bigint(20) NOT NULL,
	  `create_time` datetime NOT NULL,
	  `update_time` datetime NOT NULL,*/
	private long id;
	private long num;
	private Date createTime;
	private Date updateTime;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getNum() {
		return num;
	}
	public void setNum(long num) {
		this.num = num;
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
