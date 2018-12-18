package cn.mkp.entity;
/**
 * 技能实体类
 * @author mkp
 *
 */
public class MySkill {

	private long id;
	private String namePic;
	private long percent;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNamePic() {
		return namePic;
	}
	public void setNamePic(String namePic) {
		this.namePic = namePic;
	}
	public long getPercent() {
		return percent;
	}
	public void setPercent(long percent) {
		this.percent = percent;
	}
	
}
