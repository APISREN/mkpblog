package cn.mkp.dao;

import java.util.List;

import cn.mkp.entity.MySkill;
import cn.mkp.entity.WebAbout;

public interface WebAboutDao {

	/**
	 * 查询个人信息
	 * @return
	 */
	List<WebAbout> getList();
	
	/**
	 * 查询技能列表
	 * @return
	 */
	List<MySkill> getMySkillList();
}
