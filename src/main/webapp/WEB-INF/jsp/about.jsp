<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>小穆的博客</title>
<%@include file="public/common.jsp"%>
</head>
<body>
	<jsp:include page="public/header.jsp"></jsp:include>
	<div class="about-content">
		<div class="w1000">
			<div class="item info">
				<div class="title">
					<h3>我的介绍</h3>
				</div>
				<div class="cont">
					<img src="${webAbout.pic}">
					<div class="per-info">
						<p>
							<span class="name">${webAbout.name}</span><br /> <span class="age">${webAbout.age}岁</span><br />
							<span class="Career">${webAbout.job}</span><br /> <span
								class="interest">${webAbout.interest}</span>
						</p>
					</div>
				</div>
			</div>
			<div class="item tool">
				<div class="title">
					<h3>我的技能</h3>
				</div>
				<div class="layui-fluid">
					<div class="layui-row">
						<c:forEach items="${webAbout.mySkills}" var="skill">
							<div class="layui-col-xs6 layui-col-sm3 layui-col-md3">
								<div class="cont-box">
									<img src="${skill.namePic}">
									<p>${skill.percent}%</p>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="item contact">
				<div class="title">
					<h3>联系方式</h3>
				</div>
				<div class="cont">
					<img src="${webAbout.wechatPic}">
					<div class="text">
						<p class="WeChat">微信：<span>${webAbout.wechat}</span>
						</p>
						<p class="qq">qq：<span>${webAbout.qq}</span>
						</p>
						<p class="iphone">电话：<span>${webAbout.phone}</span>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="public/footer.jsp" flush="true"/>
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
					menu.init();
				})
	</script>
</body>
</html>