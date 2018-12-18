<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:forEach items="${contentList}" var="content">
	<div class="list-item">
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
							<a href="/details?articleId=${content.id}" class="go-icon" ></a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</c:forEach>
