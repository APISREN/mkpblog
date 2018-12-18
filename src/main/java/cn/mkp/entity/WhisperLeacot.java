package cn.mkp.entity;

import java.util.Date;

public class WhisperLeacot {

	/*`id` bigint(10) NOT NULL AUTO_INCREMENT,
	  `whisper_id` bigint(20) NOT NULL,
	  `username` varchar(255) NOT NULL,
	  `desc` varchar(255) NOT NULL,
	  `pic` varchar(255) NOT NULL,
	  `create_time` datetime NOT NULL,
	  `update_time` datetime NOT NULL,*/
	private long id;
	private long whisperId;
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
	public long getWhisperId() {
		return whisperId;
	}
	public void setWhisperId(long whisperId) {
		this.whisperId = whisperId;
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
	
}
