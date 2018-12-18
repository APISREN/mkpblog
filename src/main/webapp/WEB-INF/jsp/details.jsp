<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>小穆的博客</title>
<%@include file="public/common.jsp"%>
</head>
<body >
	<jsp:include page="public/header.jsp"></jsp:include>
	<div class="content whisper-content leacots-content details-content" id="allContent">
		<div class="cont w1000">
			<div class="whisper-list">
				<div class="item-box">
					<div class="review-version">
						<div class="form-box">
							<div class="article-cont">
								<div class="title">
									<h3>${article.subTitle}</h3>
									<p class="cont-info">
										<span class="data"><fmt:formatDate value="${article.createTime}" pattern="yyyy/MM/dd "/></span><span class="types">${articleCategory.name}</span>
									</p>
								</div>
								<p>${article.subDesc}</p>
								<img src="${article.pic}">
								<pre><font size=5>${article.content}</font></pre>
								<!-- <p>以前爷爷都是用扁担一头面叶一头板鸡挑到街上摊位上卖，现在爷爷年纪大了，只能用三轮车推着。摊位摆好奶奶就会慢悠悠的拎着一个保温桶和一个小红桶过来，保温桶里装的是卤鸡蛋，小红桶留着装别人吃剩的骨头喂狗。他们只有晚上出摊，收完摊已经要9点钟了，回去还要洗一天用的抹布和衣服，爷爷奶奶都非常爱干净，摊上的所有抹布纱布都是白色的每天洗的一个油点都看不到。9年前奶奶去世了，爷爷奶奶青梅竹马感情非常好，奶奶去世的时候爷爷甚至还要求过把奶奶埋在院子里。现在爷爷有时候会偷偷跟我说，你奶奶昨天回来看我了，她还给我掖被子，我知道是她，我跟她说你别挂念我，我好的很
									跑题了。</p>
								<p>昨天我给爷爷打电话，他跟我说他卖板鸡有人给他拍照，他问别人你拍我干嘛，那个人回答他说我给你照片放到网上，你生意会更好，我爷爷说你不用放网上我都不够卖的。</p> -->
								<div class="btn-box">
									 <c:if test="${index==0}"> 
										<button class="layui-btn layui-btn-primary" >上一篇</button>
										<button class="layui-btn layui-btn-primary" onclick="nextOne('${articleList.get(index+1).id}')">下一篇</button>
									</c:if> 
									<c:if test="${index==(total-1)}">
										<button class="layui-btn layui-btn-primary" onclick="upOne('${articleList.get(index-1).id}')">上一篇</button>
										<button class="layui-btn layui-btn-primary" >下一篇</button>
									</c:if>
									<c:if test="${index!=0&&index!=(total-1)}">
										<button class="layui-btn layui-btn-primary" onclick="upOne('${articleList.get(index-1).id}')">上一篇</button>
										<button class="layui-btn layui-btn-primary" onclick="nextOne('${articleList.get(index+1).id}')">下一篇</button>
									</c:if>
										
								</div>
							</div>
							<div class="form">
								<form class="layui-form" action="#">
									<div class="layui-form-item layui-form-text">
										<div class="layui-input-block">
											<textarea name="desc" id="desc" placeholder="既然来了，就说几句"
												class="layui-textarea"></textarea>
										</div>
									</div>
									<div class="layui-form-item">
										<div class="layui-input-block" style="text-align: right;">
											<button class="layui-btn definite" onclick="leacot(${article.id})">確定</button>
										</div>
									</div>
								</form>
							</div>
						</div>
						<div class="volume">
							全部留言 <span id="sp">${leacotsTotal}</span>
						</div>
						<div class="list-cont">
							<c:forEach items="${leacotList}" var="leacot">
								<div class="cont">
									<div class="img">
										<img src="../res/img/header.png" alt="">
									</div>
									<div class="text">
										<p class="tit">
											<span class="name">${leacot.username}</span><span class="data"><fmt:formatDate value="${leacot.createTime}" pattern="yyyy--MM--dd "/></span>
										</p>
										<p class="ct">${leacot.desc}</p>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
			<div id="demo" style="text-align: center;"></div>
		</div>
	</div>
	<script type="text/html" id="laytplCont">
  	</script>
	<%@include file="public/footer.jsp"%>
	<script type="text/javascript" src="../res/js/jquery-1.5.1.min.js"></script> 
	<script type="text/javascript" src="../res/layui/layui.js"></script>
	<!-- <script type="text/javascript" src="../res/layui/lay/modules/element.js"></script>
	 -->
	<script type="text/javascript">
		layui.config({
			base : '../res/js/util/'
		}).use(
				[ 'element', 'laypage', 'form', 'menu' ],
				function() {
					element = layui.element, laypage = layui.laypage,
							form = layui.form, menu = layui.menu;
					laypage.render({
						elem : 'demo',
						limit : 5,
						count : <%=request.getAttribute("leacotsTotal")%>,
						jump : function(obj, first) {
							//obj包含了当前分页的所有参数，比如：
							/* alert(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
							alert(obj.limit);//得到每页显示的条数 */
							var articleId = ${article.id};
							var total = ${leacotsTotal};
							/* alert(categoryId); */
							//首次不执行
							if (first) {
								 $.ajax({
									url : "/leacotContent", // 提交地址，该方法能够跳转到一个页面
									global : false,
									type : "GET",
									dataType : "html",
									data : {
										"articleId" : articleId,
										"currentPage" : obj.curr,
										"limit" : obj.limit
									},
									async : true,
									success : function(msg) {
										$("#sp").empty();
										$("#sp").html(total);
										$(".list-cont").html("");
										$(".list-cont").html(msg);
									},
									error : function(msg) {
									}
								});
							} 
							if (!first) {
								 $.ajax({
									url : "/leacotContent", // 提交地址，该方法能够跳转到一个页面
									global : false,
									type : "GET",
									dataType : "html",
									data : {
										"articleId" : articleId,
										"currentPage" : obj.curr,
										"limit" : obj.limit
									},
									async : true,
									success : function(msg) {
										$("#sp").empty();
										$("#sp").html(total);
										$(".list-cont").html("");
										$(".list-cont").html(msg);
									},
									error : function(msg) {
									}
								});
							} 
						}
					//数据总数，从服务端得到
					});
					menu.init();
					menu.submit();
				})
	</script>
	<script type="text/javascript">
		function upOne(id){
			location.href="/details?articleId="+id; 
		}
		function nextOne(id){
		location.href="/details?articleId="+id;
		}
				    
		function leacot(id){
					 
			var total ;
			var desc = $("#desc").val();
			 	$.ajax({
				url : "/leacot/save", // 提交地址，该方法能够跳转到一个页面
				global : false,
				type : "GET",
				dataType : "json",
				data : {
					"articleId" : id,
					"desc" : desc
				},
				async : false,
				success : function(data) {
					total=data;
					$("#desc").val("");
				},
				error : function(msg) {
				}
			});
			 	layui.config({
					base : '../res/js/util/'
				}).use(
						[ 'element', 'laypage', 'form', 'menu' ],
						function() {
							element = layui.element, laypage = layui.laypage,
									form = layui.form, menu = layui.menu;
							laypage.render({
								elem : 'demo',
								limit : 5,
								count : total,
								jump : function(obj, first) {
									//obj包含了当前分页的所有参数，比如：
									/* alert(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
									alert(obj.limit);//得到每页显示的条数 */
									var articleId = ${article.id};
									var size = total;
									/* alert(categoryId); */
									//首次不执行
									if (first) {
										 $.ajax({
											url : "/leacotContent", // 提交地址，该方法能够跳转到一个页面
											global : false,
											type : "GET",
											dataType : "html",
											data : {
												"articleId" : articleId,
												"currentPage" : obj.curr,
												"limit" : obj.limit
											},
											async : true,
											success : function(msg) {
												$("#sp").empty();
												$("#sp").html(size);
												$(".list-cont").html("");
												$(".list-cont").html(msg);
											},
											error : function(msg) {
											}
										});
									} 
									if (!first) {
										 $.ajax({
											url : "/leacotContent", // 提交地址，该方法能够跳转到一个页面
											global : false,
											type : "GET",
											dataType : "html",
											data : {
												"articleId" : articleId,
												"currentPage" : obj.curr,
												"limit" : obj.limit
											},
											async : true,
											success : function(msg) {
												$("#sp").empty();
												$("#sp").html(total);
												$(".list-cont").html("");
												$(".list-cont").html(msg);
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