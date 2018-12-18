package cn.mkp.dao;

import cn.mkp.entity.WebLog;

public interface WebLogDao {

	
	//访问数量加1
	public int updateNum();
	//查询fangwen数量
	public WebLog getWebLog();
}
