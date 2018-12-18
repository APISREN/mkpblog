package cn.mkp.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mkp.dao.WhisperLeacotDao;
import cn.mkp.entity.WhisperLeacot;
import cn.mkp.service.WhisperLeacotService;
@Service
public class WhisperLeacotServiceImpl implements WhisperLeacotService {

	@Autowired
	private WhisperLeacotDao whisperLeacotDao;
	/**
	 * 查询微语留言列表
	 * @param whisperId
	 * @return
	 */
	public List<WhisperLeacot> getLeacotListByWhisperId(long whisperId) {
		List<WhisperLeacot> whisperLeacotList = whisperLeacotDao.getLeacotListByWhisperId(whisperId);
		return whisperLeacotList;
	}
	/**
	 * 保存微语留言
	 * @param whisperLeacot
	 * @return
	 */
	@Override
	public int saveWhisperLeacot(String desc,String username,long whisperId) {
		WhisperLeacot whisperLeacot =new WhisperLeacot();
		whisperLeacot.setWhisperId(whisperId);
		whisperLeacot.setDesc(desc);
		whisperLeacot.setUsername(username);
		whisperLeacot.setCreateTime(new Date());
		whisperLeacot.setUpdateTime(new Date());
		int index=whisperLeacotDao.saveWhisperLeacot(whisperLeacot);
		return index;
	}

}
