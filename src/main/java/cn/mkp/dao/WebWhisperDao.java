package cn.mkp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.mkp.entity.WebWhisper;

public interface WebWhisperDao {

	/**
	 * 获取微语分页列表
	 * @param start 
	 * @param pageSize
	 * @return
	 */
	List<WebWhisper> getWhisperList(@Param("start")long start,@Param("pageSize") long pageSize);
	/**
	 * 获取微语总数
	 * @return
	 */
	long getWhisperTotal();
	/**
	 * 修改点赞
	 * @param whisperId
	 * @param num
	 * @return
	 */
	int updatePraise(@Param("num")long num,@Param("whisperId")long whisperId);
}
