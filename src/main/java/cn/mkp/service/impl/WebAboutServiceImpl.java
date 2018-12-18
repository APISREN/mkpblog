package cn.mkp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mkp.dao.WebAboutDao;
import cn.mkp.entity.MySkill;
import cn.mkp.entity.WebAbout;
import cn.mkp.service.WebAboutService;
/**
 *  关于 Service
 * @author mkp
 *
 */
@Service
public class WebAboutServiceImpl implements WebAboutService {

	@Autowired
	private WebAboutDao aboutDao;
	
	/**
	 * 查询所有信息
	 * 
	 */
	@Override
	public List<WebAbout> getAllList() {
		//查询列表
		List<WebAbout> aboutList = aboutDao.getList();
		//查询技能列表
		List<MySkill> mySkillList = aboutDao.getMySkillList();
		List<WebAbout> list = new ArrayList<>();
		for (WebAbout webAbout : aboutList) {
			webAbout.setMySkills(mySkillList);
			list.add(webAbout);
		}
		return list;
	}

}
