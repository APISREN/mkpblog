<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
		<c:forEach items="${albumList}" var="album">
			<div class="layui-col-xs12 layui-col-sm4 layui-col-md4">
				<div class="item">
					<img src="${album.pic}" height="200" width="230" />
					<div class="cont-text">
						<div class="data">
							<fmt:formatDate value="${album.createTime}" pattern="yyyy/MM/dd " />
						</div>
						<p class="address">
							<i class="layui-icon layui-icon-location"></i><span>${album.place}</span>
						</p>
						<p class="briefly">${album.weather},${album.title}</p>
					</div>
				</div>
			</div>
		</c:forEach>
