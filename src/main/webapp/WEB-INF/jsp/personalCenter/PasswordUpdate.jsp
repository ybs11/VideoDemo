<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- saved from url=(0044)http://localhost:8080/Voids/user/password.do -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <!-- base href="http://localhost:8080/video/" -->
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
    
        
<!--<base href="http://localhost:8080/Voids/">--><base href=".">
    <meta name="renderer" content="webkit">
    <meta name="keywords" content="Web前端视频教程,大数据视频教程,HTML5视频教程,UI视频教程,PHP视频教程,java视频教程,python基础教程">
    <meta name="description" content="智游教育在线课程视频,为您提供java,python,HTML5,UI,PHP,大数据等学科经典视频教程在线浏览学习,精细化知识点解析,深入浅出,想学不会都难,智游教育,学习成就梦想！">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/z/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/z/profile.css">
    <link rel="icon" href="${pageContext.request.contextPath}/static/z/favicon.png" type="image/png">
    <title>在线公开课-智游教育|java|大数据|HTML5|python|UI|PHP视频教程</title>

</head>

<body class="w100">
   



<header>
	<div class="container top_bar clearfix">
		<img src="${pageContext.request.contextPath}/static/z/logo.png" alt="智游">
		<div id="tele">
			<span>4006-371-555</span>
			<span>0371-88888598</span>
		</div>
	</div>
	<menu>
		<div class="container clearfix">
			<ul class="clearfix f_left">
				<li><a href="${pageContext.request.contextPath}/index">首页</a></li>
				
				<li class="menu_active"><a href="${pageContext.request.contextPath}/foreground/PersonalCenter.do">个人中心</a></li>
			</ul>
			
			<div id="user_bar">
				<a>
						
						<img id="avatar" src="${user.imgurl }" alt="" "="">
						
						
					

				</a>
				<a   id="lay_out" href="${pageContext.request.contextPath}/loginOut.do">退出</a>
			</div>
		</div>
	</menu>
</header>

   <main>
        <div class="container">
            <h2>我的资料</h2>
            <div id="profile_tab">
                <ul class="profile_tab_header f_left clearfix">
                    <li><a href="${pageContext.request.contextPath}/userUpadteShow">更改资料</a></li>
                    <li class="profile_tab_line">|</li>
                    <li><a href="${pageContext.request.contextPath}/AvatarUpload">更改头像</a></li>
                    <li class="profile_tab_line">|</li>
                    <li><a href="${pageContext.request.contextPath}/PasswordUpdate">密码安全</a></li>
                </ul>
                <div class="proflle_tab_body">
                    <div class="proflle_tab_workplace clearfix">
                        <div class="profile_avatar_area">
                        
                           
		                         <img id="avatar" width="200px;" src="${user.imgurl }" alt="">
		                      
		                      
		                      
                           
                        </div>
                      
                        <div class="profile_ifo_area">
                            <form action="${pageContext.request.contextPath}/passwordUpdate" method="post">
                                <div class="form_group">
                                    <span class="dd">旧　密　码：</span>
                                    <input id="originalPassword" type="password" name="originalPassword"><span id="oldMsg"></span>
                                </div>
                                <div class="form_group">
                                    <span class="dd">新　密　码：</span>
                                    <input  id="newPassword" type="password" name="newPassword">
                                </div>
                                <div class="form_group">
                                    <span class="dd">确认新密码：</span>
                                    <input id="rePassword"  type="password" name="rePassword"><span id="passMsg"></span>
                                </div>
                                <div class="form_submit dd">
                                    <input   value="保　存" type="submit" id="subBtn">
                                    <a href="${pageContext.request.contextPath}/foreground/PersonalCenter.do">取消</a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
    


<footer>
	<div class="container">
		<ul>
			<li><img src="${pageContext.request.contextPath}/static/z/footer_logo.png" alt="" id="foot_logo"></li>
			<li>版权所有：智游3G教育　　　©&nbsp;www.zhiyou100.com</li>
			<li><img src="${pageContext.request.contextPath}/static/z/a.png" alt="" id="wxgzh"></li>
		</ul>
	</div>
</footer>

 <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
 <script type="text/javascript">
 $(function(){
		$("#subBtn").attr('disabled',true);
		$("#originalPassword").blur(originalPasswordCheck);
		$("#newPassword").blur(rePasswordCheck);
		$("#rePassword").blur(rePasswordCheck);
		$("#subBtn").click(rePasswordCheck);
		$("#subBtn").click(originalPasswordCheck);
	});
	function originalPasswordCheck(){
    
		$.ajax({
		url:"${pageContext.request.contextPath}/originalPasswordCheck",
		type:"post",		
		data:{
			originalPassword:$("#originalPassword").val()
		},
		dataType:"json",
		success:function(msg){
			if(msg.isSuccess){
				$("#oldMsg").html("<font color='green'>原密码正确!</font>");
			}else{
				$("#subBtn").attr('disabled',true);
				$("#oldMsg").html("<font color='red'>原密码错误!</font>");
			    
			}
		}
	});

	}
	function rePasswordCheck() {
		$.ajax({
			url:"${pageContext.request.contextPath}/rePasswordCheck",
			type:"post",		
			data:{
				newPassword:$("#newPassword").val(),
				rePassword:$("#rePassword").val()
			},
			dataType:"json",
			success:function(msg){
				if(msg.isSuccess){
					$("#subBtn").attr('disabled',false);
					$("#passMsg").html("<font color='green'>两次密码一致!</font>");
				}else{
					$("#subBtn").attr('disabled',true);
					$("#passMsg").html("<font color='red'>两次密码不一致!</font>");
				    
				}
			}
		});
	}
 </script>   

 
</body></html>