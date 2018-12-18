<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${leacotList}" var="leacot">
		<div class="cont">
			<div class="img">
				<img src="../res/img/header.png" alt="">
			</div>
			<div class="text">
				<p class="tit">
					<span class="name">${leacot.username}</span><span class="data"><fmt:formatDate
							value="${leacot.createTime}" pattern="yyyy/MM/dd " /></span>
				</p>
				<p class="ct">${leacot.desc}</p>
			</div>
		</div>
</c:forEach>
