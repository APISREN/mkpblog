package cn.mkp.service;

import java.util.List;

import cn.mkp.entity.AlbumInfo;
import cn.mkp.entity.WebAlbum;

public interface WebAlbumService {

	/**
	 * 查询相册总计
	 * @return
	 */
	long getAlbumTotal();

	/**
	 * 查询相册分页列表
	 * @param start
	 * @param pageSize
	 * @return
	 */
	List<WebAlbum> getAlbumList(long page,long pageSize);

	List<AlbumInfo> getAlbumInfoList();
}
