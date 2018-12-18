package cn.mkp.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mkp.dao.WebLogDao;
import cn.mkp.entity.WebLog;
import cn.mkp.service.WebLogService;
@Service
public class WebLogServiceImpl implements WebLogService {

	@Autowired
	private WebLogDao webLogDao;
	public WebLog updateAndGetNum(){		
		webLogDao.updateNum();
		WebLog webLog = webLogDao.getWebLog();		
		return webLog;
	}
	
	@Override
	public WebLog selectNum() {
		WebLog webLog = webLogDao.getWebLog();
		return webLog;
	}


}
