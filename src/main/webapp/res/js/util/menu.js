/**
 
 @Name: layuiSimpleBlog - 极简博客模板
 @Author: xuzhiwen
 @Copyright: layui.com
 
 */
 layui.use('util', function(){
  var util = layui.util;
  
  //示例
  var endTime = new Date(2099,1,1).getTime() //假设为结束日期
  ,serverTime = new Date().getTime(); //假设为当前服务器时间，这里采用的是本地时间，实际使用一般是取服务端的
   
  util.countdown(endTime, serverTime, function(date, serverTime, timer){
    var str = date[0] + '天' + date[1] + '时' +  date[2] + '分' + date[3] + '秒';
    layui.$('#test').html('距离2099年1月1日还有：'+ str);
  });
});
 
layui.define(['mm','jquery'],function(exports){
	 var util = layui.util;
  var $ = layui.$,mm = layui.mm;
  var menu = {
    init: function(){
      $('.menu').on('click',function(){
        if($(this).hasClass('on')){
          $(this).removeClass('on')
          $('.header-down-nav').removeClass('layui-show');
        }else{
          $(this).addClass('on')
          $('.header-down-nav').addClass('layui-show');
        }
      })
      window.onresize = function () {
        var curwidth = document.documentElement.clientWidth;
        if(curwidth > 760){
          $('.header-down-nav').removeClass('layui-show');
          $('.menu').removeClass('on');
        }
      };
    var count = $('.list-cont .cont').length;
    $('.volume span').text(count);
    $('.op-list .like').on('click',function(){
    var whisperId =$(this).children('.whis').val();
      var oSpan =  $(this).children('span');
      var num = parseInt($(oSpan).text())
      var off = $(this).attr('off')
        if(off){
          $(this).removeClass('active');
          off = true;
          $(oSpan).text(num-1)
          $(this).attr('off','')
        }else{
          $(this).addClass('active');
          off = false;
          $(oSpan).text(num+1)
          $(this).attr('off','true')
        }
      //提交点赞start
      $.ajax({
			url : "/whisper/praise", // 提交地址，该方法能够跳转到一个页面
			global : false,
			type : "POST",
			data : {
				"num" : parseInt($(oSpan).text()),
				"whisperId":whisperId
			},
			async : true,
			success : function(data) {
				
			},
			error : function(data) {
			}
		});
      //提交点赞end
      })
      
    },
    off:function(){
      $('.off').on('click',function(){
        var off = $(this).attr('off');
        var chi = $(this).children('i');
        var text = $(this).children('span');
        var cont = $(this).parents('.item').siblings('.review-version');
        if(off){
          $(text).text('展开');
          $(chi).attr('class','layui-icon layui-icon-down');
          $(this).attr('off','');
          $(cont).addClass('layui-hide');
        }else{
          $(text).text('收起');
          $(chi).attr('class','layui-icon layui-icon-up')
          $(this).attr('off','true')
          $(cont).removeClass('layui-hide')
        }
       
      })
    },
    submit: function(){
      $('.definite').on('click',function(e){
    	var whisperId =$(this).prev('.whis').val();
        var event = e || event;
        event.preventDefault();
        var $listcont = $(this).parents('.form').siblings('.list-cont').length ? $(this).parents('.form').siblings('.list-cont') : $(this).parents('.form-box').siblings('.list-cont');
        console.log($listcont)
        var img = $(this).parents('form').siblings('img').attr('src');
        var textarea = $(this).parents('.layui-form-item').siblings('.layui-form-text').children('.layui-input-block').children('textarea');
        var name = $(textarea).val();
        var html = laytplCont.innerHTML;
        var username = "mkp"+uuid();
        var create_time=util.toDateString(new Date(), "yyyy/MM/dd");
        var data = {
          avatar : img,
          username : username,
          cont : name,
          create_time : create_time
        }
        if(name){
          var cont = mm.renderHtml(html,data);
          $listcont.prepend(cont);
          var cunt = $(this).parents('.form-box').siblings('.volume').children('span');
          var cunts = $(this).parents('.form-box').siblings('.list-cont').children('.cont').length;
          textarea.val('')
        }else{
          layer.msg('请输入内容')
        } 
        cunt.text(cunts);
        $.ajax({
			url : "/whisper/leacot/save", // 提交地址，该方法能够跳转到一个页面
			global : false,
			type : "POST",
			//dataType : "html",
			data : {
				"username" : username,
				"desc" : name,
				"whisperId":whisperId
			},
			async : true,
			success : function(data) {
				if(data==1){
					 var leacotTotal = parseInt($(".leacotTotal_"+whisperId).text())+1;
					 $(".leacotTotal_"+whisperId).text(leacotTotal)
				}
			},
			error : function(data) {
			}
		});
        
      })
    }
  }     
  exports('menu',menu)
});