<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="footer-wrap">
	<div class="footer w1000">
		<div class="qrcode">
			<img src="/res/img/erweima.jpg" width="160" id="imageId">
		</div>
		<div class="practice-mode">
			<img src="/res/img/down_img.jpg">
			<div class="text">
				<h4 class="title">我的联系方式</h4>
				<p>
					微信<span class="WeChat footer_wechat"></span>
				</p>
				<p>
					手机<span class="iphone footer_phone"></span>
				</p>
				<p>
					邮箱<span class="email"></span>
				</p>
			</div>
		</div>
	</div>
</div>
	<script type="text/javascript" src="../res/js/jquery-1.5.1.min.js"></script>
	<script type="text/javascript">
		window.onload = function () { 
			 $.ajax({
					url : "/about/foot", // 提交地址，该方法能够跳转到一个页面
					global : false,
					type : "POST",
					dataType:"json",
					data : {
					},
					async : true,
					success : function(data) {
						$(".footer_wechat").html(data.wechat);
						$(".footer_phone").html(data.phone);
						$(".email").html(data.email);
						$("#imageId").attr("src",data.wechatPic);
					},
					error : function(data) {
					}
				});
		}
	</script>