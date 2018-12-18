package cn.mkp.entity;

import java.util.Date;
import java.util.List;

public class WebWhisper {

	/* `id` bigint(10) NOT NULL AUTO_INCREMENT,
	  `content` text NOT NULL COMMENT '内容',
	  `pic` varchar(255) NOT NULL COMMENT '图片',
	  `praise_count` bigint(10) DEFAULT NULL COMMENT '点赞数量',
	  `create_time` datetime NOT NULL,
	  `update_time` datetime NOT NULL,*/
	private long id;
	private String content;
	private String pic;
	private long praiseCount;
	private long leacotTotal;
	private List<WhisperLeacot> whisperLeacots;
	private Date createTime;
	private Date updateTime;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public long getPraiseCount() {
		return praiseCount;
	}
	public void setPraiseCount(long praiseCount) {
		this.praiseCount = praiseCount;
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
	public List<WhisperLeacot> getWhisperLeacots() {
		return whisperLeacots;
	}
	public void setWhisperLeacots(List<WhisperLeacot> whisperLeacots) {
		this.whisperLeacots = whisperLeacots;
	}
	public long getLeacotTotal() {
		return leacotTotal;
	}
	public void setLeacotTotal(long leacotTotal) {
		this.leacotTotal = leacotTotal;
	}
	
}
