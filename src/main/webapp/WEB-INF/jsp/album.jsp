<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
<title>小穆的博客</title>
<%@include file="public/common.jsp"%>
</head>
<body>
	<jsp:include page="public/header.jsp"></jsp:include>
	<div class="album-content w1000" id="layer-photos-demo"
		class="layer-photos-demo">
		<div class="img-info">
			<img src="${albumInfo.pic}" alt="">
			<div class="title">
				<p class="data">
					${albumInfo.feeling}<span><fmt:formatDate value="${albumInfo.createTime}" pattern="yyyy/MM/dd "/></span>
				</p>
				<p class="text">${albumInfo.subTitle}</p>
			</div>
		</div>
		<div class="img-list">
			<div class="layui-container" style="padding: 0" id="contain">
				<div class="layui-row layui-col-space40 space" >
					
				</div>
			</div>
			<div id="demo" style="text-align: center;"></div>
		</div>
	</div>
	<%@include file="public/footer.jsp"%>
	<script type="text/javascript" src="../res/js/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="../res/layui/layui.js"></script>
	<script type="text/javascript">
		layui.config({
			base : '../res/js/util/'
		}).use(
				[ 'element', 'laypage', 'form', 'layer', 'menu' ],
				function() {
					element = layui.element, laypage = layui.laypage,
							form = layui.form, layer = layui.layer,
							menu = layui.menu;
					var albumTotal =${albumTotal};
					laypage.render({
						elem : 'demo',
						limit:12,
						count : albumTotal,
					jump : function(obj, first) {
							//obj包含了当前分页的所有参数，比如：
							/* alert(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
							alert(obj.limit);//得到每页显示的条数 */
							/* alert(categoryId); */
							//首次不执行
							if (first) {
								 $.ajax({
									url : "/album/content", // 提交地址，该方法能够跳转到一个页面
									global : false,
									type : "GET",
									dataType : "html",
									data : {
										"currentPage" : obj.curr,
										"limit" : obj.limit
									},
									async : true,
									success : function(msg) {
										$(".layui-row").html("");
										$(".layui-row").html(msg);
										menu.init();
									},
									error : function(msg) {
									}
								});
							} 
							if (!first) {
								 $.ajax({
									url : "/album/content", // 提交地址，该方法能够跳转到一个页面
									global : false,
									type : "GET",
									dataType : "html",
									data : {
										"currentPage" : obj.curr,
										"limit" : obj.limit
									},
									async : true,
									success : function(msg) {
										$(".layui-row").html("");
										$(".layui-row").html(msg);
										menu.init();
									},
									error : function(msg) {
									}
								});
							} 
						} 
					//数据总数，从服务端得到
					});
					layer.photos({
						photos : '#layer-photos-demo',
						anim : 5 //0-6的选择，指定弹出图片动画类型，默认随机（请注意，3.0之前的版本用shift参数）
						,
						tab : function(pic, layero) {
							console.log(pic, layero)
						}
					});
					menu.init();
				});
		
		$('.menu').click(function(){
	        if($(this).hasClass('on')){
	          $(this).removeClass('on')
	          $('.header-down-nav').removeClass('layui-show');
	        }else{
	          $(this).addClass('on')
	          $('.header-down-nav').addClass('layui-show');
	        }
	      });
	</script>
</body>
</html>