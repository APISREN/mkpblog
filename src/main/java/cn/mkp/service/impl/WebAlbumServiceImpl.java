package cn.mkp.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mkp.dao.WebAlbumDao;
import cn.mkp.entity.AlbumInfo;
import cn.mkp.entity.WebAlbum;
import cn.mkp.service.WebAlbumService;
/**
 * 相册Service
 * @author mkp
 *
 */
@Service
public class WebAlbumServiceImpl implements WebAlbumService{

	@Autowired
	private WebAlbumDao albumDao;
	
	/**
	 * 查询相册总计
	 */
	@Override
	public long getAlbumTotal() {
		long albumTotal = albumDao.getAlbumTotal();
		return albumTotal;
	}

	/**
	 * 查询相册分页列表
	 * @param start
	 * @param pageSize
	 * @return
	 */
	@Override
	public List<WebAlbum> getAlbumList(long page, long pageSize) {
		long start = (page-1)*pageSize;
		List<WebAlbum> albumList = albumDao.getAlbumList(start, pageSize);
		return albumList;
	}

	/**
	 * 查询相册信息
	 */
	@Override
	public List<AlbumInfo> getAlbumInfoList() {
		List<AlbumInfo> list = albumDao.getAlbumInfoList();
		return list;
	}

}
