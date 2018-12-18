package cn.mkp.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.mkp.entity.ArticleLeacots;
import cn.mkp.entity.WebArticle;
import cn.mkp.entity.WebArticleCategory;
import cn.mkp.service.ArticleLeacotsService;
import cn.mkp.service.WebArticleCateService;
import cn.mkp.service.WebArticleService;
import cn.mkp.utils.JsonUtils;

/**
 * 详情Controller
 * @author mkp
 *
 */
@Controller
public class DetailsController {
	@Autowired
	private WebArticleService articleService;
	@Autowired
	private WebArticleCateService articleCateService;
	@Autowired
	private ArticleLeacotsService leacotsService;

	/**
	 * 详情页面展示
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/details")
	public String detailIndex(HttpServletRequest request, Model model) {
		//获取内容id
		String id = request.getParameter("articleId");
		long articleId = Long.parseLong(id);
		//查询内容
		WebArticle article = articleService.getWebArticleById(articleId);
		//查询内容分类id
		long categoryId = article.getCategoryId();
		//查询分类下的所有文章
		List<WebArticle> articleList = articleService.getList(categoryId);
		
		if (articleList.contains(article)) {
			//获取角标
			int index = articleList.indexOf(article);
			model.addAttribute("index", index);
		}
		long total = articleList.size();
		//查询分类
		WebArticleCategory articleCategory = articleCateService.selectCategoryById(categoryId);
		//根据文章id查询所有留言列表
		List<ArticleLeacots> leacotAllList = leacotsService.getList(articleId);
		long leacotsTotal = leacotAllList.size();
		model.addAttribute("leacotsTotal", leacotsTotal);
		model.addAttribute("articleList", articleList);
		model.addAttribute("article", article);
		model.addAttribute("total", total);
		model.addAttribute("articleCategory", articleCategory);
		return "details";
	}
	
	/**
	 * 文章留言分页列表
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/leacotContent")
	public String content(Model model, HttpServletRequest request) {
		//获取传过来的参数
		//1.分类id
		long articleId = Long.parseLong(request.getParameter("articleId"));
		//2.当前页
		long page = Long.parseLong(request.getParameter("currentPage"));
		//3.每页显示的数量
		long pageSize = Long.parseLong(request.getParameter("limit"));
		//分页查询
		List<ArticleLeacots> leacotList = leacotsService.getListByArticleId(articleId, page, pageSize);
		model.addAttribute("leacotList", leacotList);
		return "articleLeacot";
	}
	
	/**
	 * 保存留言，并加载
	 * @param articleId
	 * @param desc
	 * @param model
	 * @return
	 */
	@RequestMapping("/leacot/save")
	@ResponseBody
	public Long saveLeacots(Long articleId, String desc, Model model) {
		ArticleLeacots articleLeacot = leacotsService.saveArticleLeacots(articleId, desc);
		List<ArticleLeacots> leacotAllList = leacotsService.getList(articleId);
		long total=leacotAllList.size();
		model.addAttribute("leacotAll",total);
		long page = 1;
		long pageSize = 5;
		List<ArticleLeacots> leacotList = leacotsService.getListByArticleId(articleId, page, pageSize);
		model.addAttribute("leacotList", leacotList);
		model.addAttribute("articleLeacot", articleLeacot);
		return total;
	}

}
