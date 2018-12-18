<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${whisperList}" var="whisper">
	<div class="item-box">
		<div class="item">
			<div class="whisper-title">
				<i class="layui-icon layui-icon-date"></i><span class="hour"><fmt:formatDate
						value="${whisper.createTime}" pattern="hh:mm" /></span> <span
					class="date"><fmt:formatDate value="${whisper.createTime}"
						pattern="yyyy/MM/dd " /></span>
			</div>
			<p class="text-cont">${whisper.content}</p>
			<div class="img-box">
				<img src="${whisper.pic}">
			</div>
			<div class="op-list">
				<p class="like">
					<input type="hidden" class="whis" value="${whisper.id}">
					<i class="layui-icon layui-icon-praise" ></i><span>${whisper.praiseCount}</span>
				</p>
				<p class="edit">
					<i class="layui-icon layui-icon-reply-fill"></i><span class="leacotTotal_${whisper.id}">${whisper.leacotTotal}</span>
				</p>
				<p class="off">
					<span>展开</span><i class="layui-icon layui-icon-down"></i>
				</p>
			</div> 
		</div>
		<div class="review-version layui-hide">
			<div class="form">
				<img src="../res/img/header2.png">
				<form class="layui-form" action="">
					<div class="layui-form-item layui-form-text">
						<div class="layui-input-block">
							
							<textarea name="desc" class="layui-textarea"></textarea>
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-input-block" style="text-align: right;">
							<input type="hidden" class="whis" value="${whisper.id}">
							<button class="layui-btn definite">確定</button>
						</div>
					</div>
				</form>
			</div>
			<div class="list-cont">
				<c:forEach items="${whisper.whisperLeacots}" var="leacots">
					<div class="cont">
						<div class="img">
							<img src="../res/img/header.png" alt="">
						</div>
						<div class="text">
							<p class="tit">
								<span class="name">${leacots.username}</span><span class="data"><fmt:formatDate value="${leacots.createTime}" pattern="yyyy/MM/dd "/></span>
							</p>
							<p class="ct">${leacots.desc}</p>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</c:forEach>

