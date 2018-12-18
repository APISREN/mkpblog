package cn.mkp.service;

import java.util.List;

import cn.mkp.entity.WhisperLeacot;

public interface WhisperLeacotService {

	/**
	 * 查询微语留言列表
	 * @param whisperId
	 * @return
	 */
	List<WhisperLeacot> getLeacotListByWhisperId(long whisperId);
	
	/**
	 * 保存微语留言
	 * @param whisperLeacot
	 * @return
	 */
	int saveWhisperLeacot(String desc,String username,long whisperId);
}
