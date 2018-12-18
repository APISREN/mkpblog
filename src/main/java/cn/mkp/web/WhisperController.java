package cn.mkp.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.mkp.entity.WebWhisper;
import cn.mkp.entity.WhisperLeacot;
import cn.mkp.service.WebWhisperService;
import cn.mkp.service.WhisperLeacotService;

/**
 * @author mkp
 *
 */
@Controller
public class WhisperController {
	@Autowired
	private WebWhisperService whisperService;
	@Autowired
	private WhisperLeacotService whisperLeacotService;
	/**
	 * 显示微语页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/whisper")
	public String index(Model model) {
		long whisperTotal = whisperService.getWhisperTotal();
		model.addAttribute("whisperTotal", whisperTotal);
		return "whisper";
	}

	/**
	 * 获取微语分页列表，
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/whisper/content")
	public String content(Model model, HttpServletRequest request) {
		long page = Long.parseLong(request.getParameter("currentPage"));
		// 3.每页显示的数量
		long pageSize = Long.parseLong(request.getParameter("limit"));
		List<WebWhisper> whisperList = whisperService.getWhisperList(page, pageSize);
		model.addAttribute("whisperList", whisperList);
		return "whisperContent";
	}

	/**
	 * 点赞
	 * @param num
	 * @param whisperId
	 * @return
	 */
	@RequestMapping(value = "/whisper/praise", method = RequestMethod.POST)
	public String praise(Long num, Long whisperId,HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.getAttribute("ip");
		whisperService.updatePraise(num, whisperId);
		return null;
	}
	/**
	 * 保存微语留言
	 * @param num
	 * @param whisperId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/whisper/leacot/save", method = RequestMethod.POST)
	public Object saveWhisperLeacot(String desc ,String username,Long whisperId) {
		return whisperLeacotService.saveWhisperLeacot(desc, username, whisperId);
	}
}
