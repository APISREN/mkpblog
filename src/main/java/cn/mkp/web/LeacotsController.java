package cn.mkp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.mkp.entity.WebLeacots;
import cn.mkp.service.WebLeacotsService;

@Controller
public class LeacotsController {
	@Autowired
	private WebLeacotsService leacotsService;
	/**
	 * 展示留言页面，获取留言总数
	 * @param model
	 * @return
	 */
	@RequestMapping("/leacots")
	public String index(Model model) {
		long leacotTotal = leacotsService.getTotal();
		model.addAttribute("leacotTotal", leacotTotal);
		return "leacots";
	}
	/**
	 * 查询留言分页列表，和文章留言调用同一个jsp
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/leacots/content")
	public String contentList(long currentPage,long limit,Model model){
		List<WebLeacots> leacotList = leacotsService.getList(currentPage, limit);
		model.addAttribute("leacotList", leacotList);
		return "articleLeacot";
	}
	/**
	 * 保存留言
	 * @param desc
	 * @return
	 */
	@RequestMapping("/leacots/save")
	@ResponseBody
	public long saveLeacot(String desc){
		int index = leacotsService.saveWebLeacots(desc);
		if(index==1){
			
			long total = leacotsService.getTotal();
			return total;
		}
		return index;
	}
}
