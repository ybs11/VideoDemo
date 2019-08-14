<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!--<base href="http://localhost:8080/Voids/">-->
<base href=".">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>智游教育</title>

<link href="/VideoSSM/static/z/bootstrap/css/bootstrap.css" rel="stylesheet">

<style type="text/css">
.col-md-1 {
	padding-top: 20px;
}

.a1 {
	color: gray;
}

b {
	float: right;
}
</style>



</head>

<body>






	<nav class="navbar-inverse">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<a class="navbar-brand">视频管理系统</a>
			</div>

			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-9">
				<ul class="nav navbar-nav">
					<li><a href="/VideoSSM/videoShow.do">视频管理</a></li>
					<li><a href="/VideoSSM/speakerShow.do">主讲人管理</a></li>
					<li class="active"><a href="/VideoSSM/courseShow.do">课程管理
						</a></li>
				</ul>
				<p class="navbar-text navbar-right">
					<span>${admin.accounts}</span> <i class="glyphicon glyphicon-log-in"
						aria-hidden="true"></i>&nbsp;&nbsp;<a class="navbar-link" href="loginOut.do">退出</a>
				</p>
			</div>
			<!-- /.navbar-collapse -->


		</div>
		<!-- /.container-fluid -->
	</nav>



	<div class="jumbotron" style="padding-top: 15px; padding-bottom: 15px;">
		<div class="container">



			<h2>修改课程</h2>

		</div>
	</div>



	<div class="container" style="margin-top: 20px;">

		<form id="infoForm" class="form-horizontal" action="/VideoSSM/courseUpdate.do">

			<input name="id" value="${course.id }" type="hidden">

			<div class="form-group">
				<label for="subjectId" class="col-sm-2 control-label">所属学科</label>
				<div class="col-sm-10">

					<select name="subjectID" id="subjectId" class="form-control">
						<option value="0" 
						<c:if test="${course.subjectId eq '0'}">selected="selected"</c:if>						
						>请选择所属学科</option>
 
						<option value="1"
						<c:if test="${course.subjectId eq '1'}">selected="selected"</c:if>	
						>WEB前端</option>

						<option value="2"
						<c:if test="${course.subjectId eq '2'}">selected="selected"</c:if>	
						>Java</option>

			           <option value="3" 
			           <c:if test="${course.subjectId eq '3'}">selected="selected"</c:if>	
			           >Android</option>

						<option value="4"
						<c:if test="${course.subjectId eq '4'}">selected="selected"</c:if>	
						
						>IOS</option>

						<option value="5"
						<c:if test="${course.subjectId eq '5'}">selected="selected"</c:if>	
						>大数据</option>

						<option value="6"
						<c:if test="${course.subjectId eq '6'}">selected="selected"</c:if>	
						>UI</option>

						<option value="7"
                        <c:if test="${course.subjectId eq '7'}">selected="selected"</c:if>							
						>VR</option>

						<option value="8"
						<c:if test="${course.subjectId eq '8'}">selected="selected"</c:if>	
						>U3D</option>

						<option value="9"
						<c:if test="${course.subjectId eq '9'}">selected="selected"</c:if>	
						>人工智能</option>

						<option value="10"
						<c:if test="${course.subjectId eq '10'}">selected="selected"</c:if>	
						>Python</option>

                 		<option value="11"
                 		<c:if test="${course.subjectId eq '11'}">selected="selected"</c:if>	
                 		>PHP</option>
					
					</select>

				</div>
			</div>



			<div class="form-group">
				<label for="subjectTitle" class="col-sm-2 control-label">标题</label>
				<div class="col-sm-10">
					<input class="form-control" name="courseTitle" id="subjectTitle"
						value="${course.courseTitle} " placeholder="课程标题" type="text">
				</div>
			</div>
			<div class="form-group">
				<label for="courseDesc" class="col-sm-2 control-label">简介</label>
				<div class="col-sm-10">
					<textarea class="form-control" id="courseDesc" name="courseDesc"
						rows="3">${course.courseDesc}</textarea>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">保存</button>
				</div>
			</div>
		</form>
	</div>

	<!-- å¦æIEçæ¬å°äº9ï¼å è½½ä»¥ä¸js,è§£å³ä½çæ¬å¼å®¹é®é¢ -->
	<!--[if lt IE 9]>
<script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
<script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
	<script src="/VideoSSM/static/js/jquery-1.js"></script>
	<script src="/VideoSSM/static/js/bootstrap.js"></script>
	<script src="/VideoSSM/static/js/confirm.js"></script>
	<script src="/VideoSSM/static/js/jquery.js"></script>
	<script src="/VideoSSM/static/js/message_cn.js"></script>





	<div id="modal-background" class=""></div>
	<div id="confirm-modal" class="modal fade role=" dialog"=""
		tabindex="-1">
		<div class="modal-dialog modal-undefined">
			<div class="modal-content">
				<div class="modal-header">
					<button id="modal-upper-close" class="close modal-close"
						aria-label="Close" type="button">
						<span aria-hidden="true">×</span>
					</button>
					<h4 id="modal-title" class="modal-title">Modal Title</h4>
				</div>
				<div id="modal-body" class="modal-body">Modal Message</div>
				<div id="modal-footer" class="modal-footer"></div>
			</div>
		</div>
	</div>
	<div id="modal-background" class=""></div>
</body>
</html>