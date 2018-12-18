package cn.mkp.entity;

import java.util.List;

public class WebAbout {

	/*`id` int(10) NOT NULL AUTO_INCREMENT,
	  `name` varchar(255) NOT NULL COMMENT '我的名字',
	  `age` int(11) NOT NULL,
	  ` job` varchar(255) NOT NULL COMMENT '职业',
	  ` interest` varchar(255) NOT NULL COMMENT '爱好',
	  `pic` varchar(255) DEFAULT NULL COMMENT '图片',
	  `qq` varchar(255) NOT NULL COMMENT 'qq',
  		`weixin` varchar(255) NOT NULL COMMENT '微信',
  	`	email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  		`phone` varchar(255) DEFAULT NULL COMMENT '电话',
	  */
	private Integer id;
	private String name;
	private Integer age;
	private String job;
	private String interest;
	private String pic;
	private String qq;
	private String wechat;
	private String email;
	private String phone;
	private String wechatPic;
	private List<MySkill> mySkills;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getwechat() {
		return wechat;
	}
	public void setwechat(String wechat) {
		this.wechat = wechat;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getWechatPic() {
		return wechatPic;
	}
	public void setWechatPic(String wechatPic) {
		this.wechatPic = wechatPic;
	}
	public List<MySkill> getMySkills() {
		return mySkills;
	}
	public void setMySkills(List<MySkill> mySkills) {
		this.mySkills = mySkills;
	}
	
}
