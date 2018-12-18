package cn.mkp.entity;

import java.util.Date;

public class AlbumInfo {

	/*`id` bigint(10) NOT NULL AUTO_INCREMENT,
	  `feeling` varchar(255) NOT NULL,
	  `sub_title` varchar(255) NOT NULL,
	  `pic` varchar(255) NOT NULL,
	  `create_time` datetime NOT NULL,
	  `update_time` datetime NOT NULL,*/
	
	private long id;
	private String feeling;
	private String subTitle;
	private String pic;
	private Date createTime;
	private Date updateTime;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFeeling() {
		return feeling;
	}
	public void setFeeling(String feeling) {
		this.feeling = feeling;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
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
