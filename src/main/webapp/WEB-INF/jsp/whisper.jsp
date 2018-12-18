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
	<div class="content whisper-content">
		<div class="cont">
			<div class="whisper-list">
			</div>
			<div id="demo" style="text-align: center;"></div>
		</div>
	</div>
	<script type="text/html" id="laytplCont">
    <div class="cont">
      <div class="img">
        <img src="{{d.avatar}}" alt="">
      </div>
      <div class="text">
        <p class="tit"><span class="name">{{d.username}}</span><span class="data">{{d.create_time}}</span></p>
        <p class="ct">{{d.cont}}</p>
      </div>
    </div>
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
						count : <%=request.getAttribute("whisperTotal")%>,
						jump : function(obj, first) {
							//obj包含了当前分页的所有参数，比如：
							/* alert(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
							alert(obj.limit);//得到每页显示的条数 */
							//首次不执行
							if (first) {
								 $.ajax({
									url : "/whisper/content", // 提交地址，该方法能够跳转到一个页面
									global : false,
									type : "GET",
									dataType : "html",
									data : {
										"currentPage" : obj.curr,
										"limit" : obj.limit
									},
									async : true,
									success : function(msg) {
										$(".whisper-list").html("");
										$(".whisper-list").html(msg);
										menu.init();
										menu.off();
										menu.submit();
									},
									error : function(msg) {
									}
								});
							}
							if (!first) {
								 $.ajax({
									url : "/whisper/content", // 提交地址，该方法能够跳转到一个页面
									global : false,
									type : "GET",
									dataType : "html",
									data : {
										"currentPage" : obj.curr,
										"limit" : obj.limit
									},
									async : true,
									success : function(msg) {
										$(".whisper-list").html("");
										$(".whisper-list").html(msg);
										menu.init();
										menu.off();
										menu.submit();
									},
									error : function(msg) {
									}
								});
							}
						}
					//数据总数，从服务端得到
					});
					menu.init();
					menu.off();
					menu.submit()
				})
				
	</script>
	<script type="text/javascript">
		function uuid() {
		    var s = [];
		    var hexDigits = "0123456789abcdef";
		    for (var i = 0; i < 36; i++) {
		        s[i] = hexDigits.substr(Math.floor(Math.random() * 0x10), 1);
		    }
		    s[14] = "4";  // bits 12-15 of the time_hi_and_version field to 0010
		    s[19] = hexDigits.substr((s[19] & 0x3) | 0x8, 1);  // bits 6-7 of the clock_seq_hi_and_reserved to 01
		    s[8] = s[13] = s[18] = s[23] = "-";
		 
		    var uuid = s.join("");
		    return uuid;
		};
		
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