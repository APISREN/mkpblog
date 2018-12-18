package cn.mkp.service;

import java.util.List;

import cn.mkp.entity.WebAbout;

public interface WebAboutService {

	/**
	 * 查询关于所有的信息
	 * @return
	 */
	public List<WebAbout> getAllList();
}
