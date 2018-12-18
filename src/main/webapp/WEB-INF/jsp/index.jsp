<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>小穆的博客</title>
<%@include file="public/common.jsp"%>
</head>
<body>
	<jsp:include page="public/header.jsp"></jsp:include>
	<div class="banner">
		<div class="cont w1000">
			<div class="title">
				<h3>
					MY<br />BLOG
				</h3>
				<h4>well-balanced heart</h4>
			</div>
			<div class="amount">
				<p>
					<span class="text">访问量</span><span class="access">${weblog.num}</span>
				</p>
				<p>
					<span class="text">日志</span><span class="daily-record">1000</span>
				</p>
			</div>
		</div>
	</div>

	<div class="content">
		<div class="cont w1000">
			<div class="title">
				<span class="layui-breadcrumb" lay-separator="|"> <c:forEach
						items="${catList}" var="cat">
						<c:if test="${cat.num==1 }">
							<a href="javascript:;" class="menu_class active"
								onclick="doSomething(this,'${cat.id}');">${cat.name}</a>
						</c:if>
						<c:if test="${cat.num!=1 }">
							<a href="javascript:;" class="menu_class"
								onclick="doSomething(this,'${cat.id}');">${cat.name}</a>
						</c:if>
					</c:forEach> <!--  <a href="javascript:;" class="active">设计文章</a>
          <a href="javascript:;">前端文章</a>
          <a href="javascript:;">旅游杂记</a> -->
				</span>
			</div>
				<div class="list-item">
						<c:forEach items="${contentList}" var="content" varStatus="status">
						<div class="item">
							<div class="layui-fluid">
								<div class="layui-row">
									<div class="layui-col-xs12 layui-col-sm4 layui-col-md5">
										<div class="img">
											<img src="${content.pic }" alt="">
										</div>
									</div>
									<div class="layui-col-xs12 layui-col-sm8 layui-col-md7">
										<div class="item-cont">
											<h3>
												${content.subTitle }
												<button class="layui-btn layui-btn-danger new-icon">new</button>
											</h3>
											<h5>${category.name}</h5>
											<p>${content.subDesc }</p>
											<a href="/details?articleId=${content.id}" class="go-icon" id="detail"></a>
										</div>
									</div>
								</div>
							</div>
						</div>
				</c:forEach>
			</div>
		</div>
		<div id="demo" style="text-align: center;"></div>
	</div>
	<%@include file="public/footer.jsp"%>
	<script type="text/javascript" src="/res/layui/layui.js"></script>
	<script type="text/javascript">
		layui.config({
			base : '/res/js/util/'
		}).use(
				[ 'element', 'laypage', 'jquery', 'menu' ],
				function() {

					element = layui.element, laypage = layui.laypage,
							$ = layui.$, menu = layui.menu;
					laypage.render({
						elem : 'demo',
						limit : 5,
						count :<%=request.getAttribute("total")%>,
						jump : function(obj, first) {
							//obj包含了当前分页的所有参数，比如：
							/* alert(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
							alert(obj.limit);//得到每页显示的条数 */
							var categoryId = ${category.id};
							/* alert(categoryId); */
							//首次不执行
							if (!first) {
								$.ajax({
									url : "/content", // 提交地址，该方法能够跳转到一个页面
									global : false,
									type : "GET",
									dataType : "html",
									data : {
										"categoryId" : categoryId,
										"currentPage" : obj.curr,
										"limit" : obj.limit
									},
									async : true,
									success : function(msg) {
										$(".list-item").html("");
										$(".list-item").html(msg);
									},
									error : function(msg) {
									}
								});
							}
						}
					//数据总数，从服务端得到
					});
					menu.init();
				})
	</script>
	<script type="text/javascript">
		function doSomething(obj, menu_id) {
			var total;
			$.ajax({
				url : "/total", // 提交地址，该方法能够跳转到一个页面
				global : false,
				type : "GET",
				dataType : "json",
				data : {
					"categoryId" : menu_id
				},
				async : false,
				success : function(data) {
					total =data;
				},
				error : function(data) {
				}
			});
			$(".menu_class").removeClass("active");
			$(obj).addClass("active");
			layui.config({
				base : '/res/js/util/'
			}).use(
					[ 'element', 'laypage', 'jquery', 'menu' ],
					function() {

						element = layui.element, laypage = layui.laypage,
								$ = layui.$, menu = layui.menu;
						laypage.render({
							elem : 'demo',
							limit : 5,
							count : total,
							jump : function(obj, first) {
								var categoryId = menu_id;
								if (first) {
									$.ajax({
										url : "/content", // 提交地址，该方法能够跳转到一个页面
										global : false,
										type : "GET",
										dataType : "html",
										data : {
											"categoryId" : categoryId,
											"currentPage" : obj.curr,
											"limit" : obj.limit
										},
										async : true,
										success : function(msg) {
											$(".list-item").html("");
											$(".list-item").html(msg);
										},
										error : function(msg) {
										}
									});
								}
								if (!first) {
									$.ajax({
										url : "/content", // 提交地址，该方法能够跳转到一个页面
										global : false,
										type : "GET",
										dataType : "html",
										data : {
											"categoryId" : categoryId,
											"currentPage" : obj.curr,
											"limit" : obj.limit
										},
										async : true,
										success : function(msg) {
											$(".list-item").html("");
											$(".list-item").html(msg);
										},
										error : function(msg) {
										}
									});
								}
							}
						//数据总数，从服务端得到
						});
						menu.init();
					}) 
		}
		
	</script>
</body>
</html>