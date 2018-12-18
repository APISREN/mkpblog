package cn.mkp.service;

import java.util.List;


import cn.mkp.entity.WebWhisper;

public interface WebWhisperService {
	/**
	 * 获取微语分页列表
	 * @param page
	 * @param pageSize
	 * @return
	 */
	List<WebWhisper> getWhisperList(long page,long pageSize);
	/**
	 * 获取微语总数
	 * @return
	 */
	long getWhisperTotal();
	/**
	 * 点赞数量
	 * @param num
	 * @param whisperId
	 * @return
	 */
	int updatePraise(long num,long whisperId);
}
