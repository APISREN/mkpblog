package cn.mkp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.mkp.entity.WebLeacots;
/**
 * 留言Dao
 * @author mkp
 *
 */
public interface WebLeacotsDao {

	/**
	 * 保存留言
	 * @param leacots
	 * @return
	 */
	int saveWebLeacots(WebLeacots leacots);
	/**
	 * 留言总数
	 * @return
	 */
	long getTotal();
	/**
	 * 留言分页列表
	 * @param start
	 * @param pageSize
	 * @return
	 */
	List<WebLeacots> getList(@Param("start") long start,@Param("pageSize")long pageSize);
}
