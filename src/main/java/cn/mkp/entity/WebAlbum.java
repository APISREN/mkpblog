package cn.mkp.entity;

import java.util.Date;

public class WebAlbum {

	 /*`id` bigint(10) NOT NULL AUTO_INCREMENT,
	  `title` varchar(255) NOT NULL COMMENT '标题',
	  `place` varchar(255) NOT NULL COMMENT '地点',
	  `weather` varchar(255) NOT NULL COMMENT '天气',
	  `pic` varchar(255) NOT NULL COMMENT '图片',
	  `create_time` datetime NOT NULL,
	  `update_time` datetime NOT NULL,
	  */
	private long id;
	private String title;
	private String place;
	private String weather;
	private String pic;
	private Date createTime;
	private Date updateTime;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
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
