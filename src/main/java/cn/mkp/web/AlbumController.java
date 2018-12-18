package cn.mkp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import cn.mkp.entity.AlbumInfo;
import cn.mkp.entity.WebAlbum;
import cn.mkp.service.WebAlbumService;
/**
 * 相册Controller
 * @author mkp
 *
 */
@Controller
public class AlbumController {
	
	@Autowired
	private WebAlbumService albumService;
	/**
	 * 显示相册页面，获取相册总数
	 * @return
	 */
	@RequestMapping("/album")
	public String index(Model model) {
		//查询总数，为分页做准备
		long albumTotal = albumService.getAlbumTotal();
		//查询相册信息
		List<AlbumInfo> list = albumService.getAlbumInfoList();
		AlbumInfo albumInfo = list.get(0);
		model.addAttribute("albumTotal", albumTotal);
		model.addAttribute("albumInfo", albumInfo);
		return "album";
	}
	/**
	 * 查询相册分页列表
	 * @param currentPage
	 * @param limit
	 * @return
	 */
	@RequestMapping("/album/content")
	public String getAlbumList(Long currentPage,Long limit,Model model) {
		List<WebAlbum> albumList = albumService.getAlbumList(currentPage, limit);
		model.addAttribute("albumList", albumList);
		return "album_content";
	}

}
