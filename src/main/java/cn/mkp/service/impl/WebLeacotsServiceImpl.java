package cn.mkp.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mkp.dao.WebLeacotsDao;
import cn.mkp.entity.WebLeacots;
import cn.mkp.service.WebLeacotsService;
/**
 * 留言Service
 * @author mkp
 *
 */
@Service
public class WebLeacotsServiceImpl implements WebLeacotsService {

	@Autowired
	private WebLeacotsDao leacotsDao;
	/**
	 * 保存留言
	 */
	@Override
	public int saveWebLeacots(String  desc) {
		WebLeacots leacot = new WebLeacots();
		leacot.setDesc(desc);
		leacot.setPic(null);
		String username=UUID.randomUUID().toString();
		leacot.setUsername(username);
		leacot.setCreateTime(new Date());
		leacot.setUpdateTime(new Date());
		return leacotsDao.saveWebLeacots(leacot);
	}
	/**
	 * 获取留言总数
	 */
	@Override
	public long getTotal() {
		long total = leacotsDao.getTotal();
		return total;
	}
	/**
	 * 获取留言分页列表
	 */
	@Override
	public List<WebLeacots> getList(long page, long pageSize) {
		long start = (page-1)*pageSize;
		List<WebLeacots> leacotsList = leacotsDao.getList(start, pageSize);
		return leacotsList;
	}

}
