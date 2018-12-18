package cn.mkp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.mkp.entity.AlbumInfo;
import cn.mkp.entity.WebAlbum;

public interface WebAlbumDao {

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
	List<WebAlbum> getAlbumList(@Param("start")long start,@Param("pageSize")long pageSize);
	/**
	 * 查询相册信息
	 * @return
	 */
	List<AlbumInfo> getAlbumInfoList();
}
