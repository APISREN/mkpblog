package cn.mkp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mkp.dao.WebWhisperDao;
import cn.mkp.entity.WebWhisper;
import cn.mkp.entity.WhisperLeacot;
import cn.mkp.service.WebWhisperService;
import cn.mkp.service.WhisperLeacotService;
/**
 * 微语服务
 * @author mkp
 *
 */
@Service
public class WebWhisperServiceImpl implements WebWhisperService {

	@Autowired
	private WebWhisperDao whisperDao;
	@Autowired
	private WhisperLeacotService whisperLeacotService;
	//查询微语总数
	public long getWhisperTotal(){
		long total = whisperDao.getWhisperTotal();
		return total;
	}
	//查询微语分页列表
	public List<WebWhisper> getWhisperList(long page, long pageSize) {
		long start = (page-1)*pageSize;
		List<WebWhisper> whisperList = whisperDao.getWhisperList(start, pageSize);
		List<WebWhisper> list = new ArrayList<>();
		for (WebWhisper webWhisper : whisperList) {
			List<WhisperLeacot> leacotList = whisperLeacotService.getLeacotListByWhisperId(webWhisper.getId());
			webWhisper.setWhisperLeacots(leacotList);
			webWhisper.setLeacotTotal(leacotList.size());
			list.add(webWhisper);
		}
		return list;
	}
	//修改点赞
	@Override
	public int updatePraise(long num,long whisperId) {
		whisperDao.updatePraise(num, whisperId);
		return 0;
	}

}
