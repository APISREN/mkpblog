package cn.mkp.service;

import java.util.List;


import cn.mkp.entity.WebLeacots;

public interface WebLeacotsService {
	
	/**
	 * 保存留言
	 * @param leacots
	 * @return
	 */
	public int saveWebLeacots(String desc);
	/**
	 * 留言总数
	 * @return
	 */
	public long getTotal();
	/**
	 * 留言分页列表
	 * @param start
	 * @param pageSize
	 * @return
	 */
	public List<WebLeacots> getList(long page,long pageSize);
}
