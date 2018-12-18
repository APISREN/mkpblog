<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="header" style="z-index: 1000">
	<%--  <jsp:include page="public/header.jsp"></jsp:include> --%>
	<div class="menu-btn">
		<div class="menu"></div>
	</div>
	<h1 class="logo">
		<a href="/index"> <span>MYBLOG</span> <img src="/res/img/logo.png">
		</a>
	</h1>
	<div class="nav">
		<a href="/index" class="active">文章</a> <a href="/whisper">微语</a> <a
			href="/leacots">留言</a> <a href="/album">相册</a> <a href="/about">关于</a>
	</div>
	<ul class="layui-nav header-down-nav">
		<li class="layui-nav-item"><a href="/index" class="active">文章</a></li>
		<li class="layui-nav-item"><a href="/whisper">微语</a></li>
		<li class="layui-nav-item"><a href="/leacots">留言</a></li>
		<li class="layui-nav-item"><a href="/album">相册</a></li>
		<li class="layui-nav-item"><a href="/about">关于</a></li>
	</ul>
	<p class="welcome-text">
		欢迎来到<span class="name">小穆</span>的博客~
	</p>
</div>