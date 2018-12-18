<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>小穆的博客</title>
<%@include file="public/common.jsp"%>
</head>
<body>
	<jsp:include page="public/header.jsp"></jsp:include>
	<div class="content whisper-content leacots-content">
		<div class="cont w1000">
			<div class="whisper-list">
				<div class="item-box">
					<div class="review-version">
						<div class="form-box">
							<img class="banner-img" src="../res/img/liuyan.jpg">
							<div class="form">
								<form class="layui-form" action="">
									<div class="layui-form-item layui-form-text">
										<div class="layui-input-block">
											<textarea name="desc" id="desc" placeholder="既然来了，就说几句"
												class="layui-textarea"></textarea>
										</div>
									</div>
									<div class="layui-form-item">
										<div class="layui-input-block" style="text-align: right;">
											<button class="layui-btn definite" onclick="lea()">確定</button>
										</div>
									</div>
								</form>
							</div>
						</div>
						<div class="volume">
							全部留言 <span class="leacot_total">${leacotTotal}</span>
						</div>
						<div class="list-cont">
							<div class="cont">
								<div class="img">
									<img src="../res/img/header.png" alt="">
								</div>
								<div class="text">
									<p class="tit">
										<span class="name">吳亦凡</span><span class="data">2018/06/06</span>
									</p>
									<p class="ct">敢问大师，师从何方？上古高人呐逐一地看完你的作品后，我的心久久
										不能平静！这世间怎么可能还有如此精辟的作品？我不敢相信自己的眼睛。自从改革开放以后，我就以为再也不会有任何作品能打动我，没想到今天看到这个如此精妙绝伦的作品好厉害！</p>
								</div>
							</div>
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
						count : <%=request.getAttribute("leacotTotal")%>,
						jump : function(obj, first) {
							//obj包含了当前分页的所有参数，比如：
							/* alert(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
							alert(obj.limit);//得到每页显示的条数 */
							var total = ${leacotTotal}
							//首次不执行
							if (first) {
								 $.ajax({
									url : "/leacots/content", // 提交地址，该方法能够跳转到一个页面
									global : false,
									type : "GET",
									dataType : "html",
									data : {
										"currentPage" : obj.curr,
										"limit" : obj.limit
									},
									async : true,
									success : function(msg) {
										$(".leacot_total").empty();
										$(".leacot_total").html(total);
										$(".list-cont").html("");
										$(".list-cont").html(msg);
									},
									error : function(msg) {
									}
								});
							}
							if (!first) {
								 $.ajax({
									url : "/leacots/content", // 提交地址，该方法能够跳转到一个页面
									global : false,
									type : "GET",
									dataType : "html",
									data : {
										"currentPage" : obj.curr,
										"limit" : obj.limit
									},
									async : true,
									success : function(msg) {
										$(".leacot_total").empty();
										$(".leacot_total").html(total);
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
					menu.submit()
				})
	</script>
	<script type="text/javascript">
	function lea(){
		var total ;
		var desc = $("#desc").val();
		 	$.ajax({
			url : "/leacots/save", // 提交地址，该方法能够跳转到一个页面
			global : false,
			type : "GET",
			dataType : "json",
			data : {
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
								var size = total;
								if (first) {
									 $.ajax({
										url : "/leacots/content", // 提交地址，该方法能够跳转到一个页面
										global : false,
										type : "GET",
										dataType : "html",
										data : {
											"currentPage" : obj.curr,
											"limit" : obj.limit
										},
										async : true,
										success : function(msg) {
											$(".leacot_total").empty();
											$(".leacot_total").html(size);
											$(".list-cont").html("");
											 $("#desc").empty();
											$(".list-cont").html(msg);
											menu.submit();
										},
										error : function(msg) {
										}
									});
								} 
								if (!first) {
									 $.ajax({
										url : "/leacots/content", // 提交地址，该方法能够跳转到一个页面
										global : false,
										type : "GET",
										dataType : "html",
										data : {
											"currentPage" : obj.curr,
											"limit" : obj.limit
										},
										async : true,
										success : function(msg) {
											$(".leacot_total").empty();
											$(".leacot_total").html(size);
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