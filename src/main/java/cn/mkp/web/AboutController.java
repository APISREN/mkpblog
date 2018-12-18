package cn.mkp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.mkp.entity.WebAbout;
import cn.mkp.service.WebAboutService;

@Controller
public class AboutController {
	
	@Autowired
	private WebAboutService aboutService;
	
	/**
	 * 回显页面
	 * @return
	 */
	@RequestMapping("/about")
	public String index(Model model) {

		List<WebAbout> allList = aboutService.getAllList();
		WebAbout webAbout = allList.get(0);
		model.addAttribute("webAbout", webAbout);
		return "about";
	}
	@RequestMapping("/about/foot")
	@ResponseBody
	public WebAbout foot(Model model) {
		
		List<WebAbout> allList = aboutService.getAllList();
		WebAbout webAbout = allList.get(0);
		return webAbout;
	}
}
