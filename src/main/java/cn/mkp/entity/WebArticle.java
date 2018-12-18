package cn.mkp.entity;

import java.util.Date;
import java.util.List;

public class WebArticle {

	/*`id` bigint(10) NOT NULL AUTO_INCREMENT,
	  `category_id` bigint(10) NOT NULL COMMENT '分类id',
	  `sub_title` varchar(255) NOT NULL COMMENT '标题',
	  `sub_desc` varchar(255) NOT NULL COMMENT '内容',
	  `pic` varchar(255) NOT NULL COMMENT '图片',
	  `create_time` datetime NOT NULL COMMENT '创建时间',
	  `update_time` datetime NOT NULL COMMENT '修改时间',
	  */
	private long id;
	private long categoryId;
	private String subTitle;
	private String subDesc;
	private String content;
	private String pic;
	private Date createTime;
	private Date updateTime;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	
	public String getsubTitle() {
		return subTitle;
	}
	public void setsubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public String getSubDesc() {
		return subDesc;
	}
	public void setSubDesc(String subDesc) {
		this.subDesc = subDesc;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (categoryId ^ (categoryId >>> 32));
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((pic == null) ? 0 : pic.hashCode());
		result = prime * result + ((subDesc == null) ? 0 : subDesc.hashCode());
		result = prime * result + ((subTitle == null) ? 0 : subTitle.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WebArticle other = (WebArticle) obj;
		if (categoryId != other.categoryId)
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (id != other.id)
			return false;
		if (pic == null) {
			if (other.pic != null)
				return false;
		} else if (!pic.equals(other.pic))
			return false;
		if (subDesc == null) {
			if (other.subDesc != null)
				return false;
		} else if (!subDesc.equals(other.subDesc))
			return false;
		if (subTitle == null) {
			if (other.subTitle != null)
				return false;
		} else if (!subTitle.equals(other.subTitle))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		return true;
	}
	
	
}
