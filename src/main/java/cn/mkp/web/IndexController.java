package cn.mkp.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.mkp.entity.WebArticle;
import cn.mkp.entity.WebArticleCategory;
import cn.mkp.entity.WebLog;
import cn.mkp.service.WebArticleCateService;
import cn.mkp.service.WebArticleService;
import cn.mkp.service.WebLogService;
/**
 * 文章Controller
 * @author mkp
 *
 */
@Controller
public class IndexController {
	@Autowired
	private WebLogService webLogService;
	@Autowired
	private WebArticleCateService webIndexCatService;
	@Autowired
	private WebArticleService webIndexService;
	//默认每页数量为4
	@Value("${PAGE_SIZE}")
	private long PAGE_SIZE;

	/**
	 * 显示文章页面
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/index")
	public String index(Model model, HttpServletRequest request) {
		//页面加载调用访问量方法
		pageView(model, request);
		//获取分类列表
		List<WebArticleCategory> catList = webIndexCatService.getCategoryList();
		//获得第一个分类
		WebArticleCategory category = catList.get(0);
		model.addAttribute("catList", catList);
		//默认当前页为1
		long index =1;		
		//分页列表
		List<WebArticle> contentList = webIndexService.getListByCategoryId(category.getId(),index,PAGE_SIZE);
		//文章总计
		long total = webIndexService.getTotal(category.getId());
		request.setAttribute("total", total);
		model.addAttribute("category", category);
		model.addAttribute("contentList", contentList);

		return "index";
	}
	/**
	 * 文章分页查询
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/content")
	public String content(Model model, HttpServletRequest request) {
		//获取传过来的参数
		//1.分类id
		long categoryId = Long.parseLong(request.getParameter("categoryId"));
		//2.当前页
		long page = Long.parseLong(request.getParameter("currentPage"));
		//3.每页显示的数量
		long pageSize = Long.parseLong(request.getParameter("limit"));
		//跟据分类id查询 类型
		WebArticleCategory category = webIndexCatService.selectCategoryById(categoryId);
		//分页查询
		List<WebArticle> contentList = webIndexService.getListByCategoryId(categoryId,page,pageSize);
		model.addAttribute("category", category);
		model.addAttribute("contentList", contentList);
		return "content";
	}
	/**
	 * 各类文章总计
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/total")
	@ResponseBody
	public Long total(Model model, HttpServletRequest request) {
		//查询分类内容总数
		long categoryId = Long.parseLong(request.getParameter("categoryId"));
		long total = webIndexService.getTotal(categoryId);
		return total;
	}

	/**
	 *  访问量
	 * @param model
	 * @param request
	 */
	public void pageView(Model model, HttpServletRequest request) {

		//判断是否有ip
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("ip");
		if (username == null) {
			WebLog weblog = webLogService.updateAndGetNum();
			String ip = request.getRemoteAddr();
			session.setAttribute("ip", ip);
			session.setMaxInactiveInterval(300);
			model.addAttribute("weblog", weblog);
		} else {

			WebLog weblog = webLogService.selectNum();
			model.addAttribute("weblog", weblog);
		}

	}
}
