<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://huahua.cn/common/" prefix="itcast" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>智游教育</title>

<link href="/static/z/bootstrap/css/bootstrap.css"
	rel="stylesheet">

<script src="/static/js/jquery-1.js"></script>
<script src="/static/js/bootstrap.js"></script>
<script src="/static/js/confirm.js"></script>
<script src="/static/js/jquery.js"></script>
<script src="/static/js/message_cn.js"></script>

<style type="text/css">
th {
	text-align: center;
}
.d{

padding-left: 400px;
display:inline-block;
}
</style>
</head>

<body>
	<nav class="navbar-inverse">
		<div class="container">

			<div class="navbar-header">
				<a class="navbar-brand">视频管理系统</a>
			</div>

			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-9">
				<ul class="nav navbar-nav">
					<li class="active"><a href="/video/show.do">视频管理</a></li>
					<li><a href="/speaker/show.do">主讲人管理</a></li>
					<li><a href="/course/list.do">课程管理</a></li>
				</ul>
				<p class="navbar-text navbar-right">
					<span>${admin.accounts}</span> <i
						class="glyphicon glyphicon-log-in" aria-hidden="true"></i>&nbsp;&nbsp;<a
						href="loginOut.do" class="navbar-link">退出</a>
				</p>
			</div>
			<!-- /.navbar-collapse -->


		</div>
		<!-- /.container-fluid -->
	</nav>






	<div class="jumbotron" style="padding-top: 15px; padding-bottom: 15px;">
		<div class="container">
			<h2>视频管理</h2>
		</div>
	</div>

	<form action="${pageContext.request.contextPath}/video/show.do" class="form-inline" method="post">

		<div class="container">
			<button onclick="showAddPage()" type="button"
				class="btn btn-info dropdown-toggle" data-toggle="dropdown"
				aria-haspopup="true" aria-expanded="false">添加</button>

			<button onclick="deleteAll()" type="button" id="btn"
				class="btn btn-info dropdown-toggle">批量删除</button>
		<div class="form-group">
			<input type="text" class="form-control" name="title" placeholder="标题" value="${video.title}">
		</div>	
		<div class="form-group">
			<select class="form-control" name="speakerId">
				<option value="">--请选择老师--</option>
				<c:forEach items="${speakerAll}" var="i">
					<%-- <option value="${i.id}">${i.speakerName}</option> --%>
					<c:if test="${i.id == video.speakerId}">
						<option value="${i.id}" selected="selected">${i.speakerName}</option>
					</c:if>
					<c:if test="${i.id != video.speakerId}">
						<option value="${i.id}">${i.speakerName}</option>
					</c:if> 
				</c:forEach>
			</select>
		</div>	
		<div class="form-group">
			<select class="form-control" name="courseId">
				<option value="">--请选择课程--</option>
				<c:forEach items="${courseAll}" var="i">
					<%-- <option value="${i.id}">${i.courseTitle}</option> --%>
					<c:if test="${i.id == video.courseId}">
						<option value="${i.id}" selected="selected">${i.courseTitle}</option>
					</c:if>
					<c:if test="${i.id != video.courseId}">
						<option value="${i.id}">${i.courseTitle}</option>
					</c:if>
				</c:forEach>
			</select>
		</div>	
		<div class="form-group">
			<button type="submit" class="btn btn-primary">查询</button>
		</div>	
			
				
			
			
			
		</div>

		<div class="container" style="margin-top: 20px;">

			<table class="table table-bordered table-hover"
				style="text-align: center; table-layout: fixed;">
				<thead>
					<tr class="active">
						<th><input type="checkbox" id="all" onclick="swapCheck()"></th>
						<th>序号</th>
						<th style="width: 15%">名称</th>
						<th style="width: 40%">介绍</th>
						<th>讲师</th>
						<th>时长</th>
						<th>播放次数</th>
						<th>编辑</th>
						<th>删除</th>
					</tr>
				</thead>
				<tbody>
				
					<c:forEach items="${page.rows}" var="i">
						<tr>
							<td><input type="checkbox" name="check" value="${i.videoId}"></td>
							<td>${i.videoId}</td>
							<td>${i.title}</td>
							<td style="overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${i.detail}</td>
							<td>${i.speaker.speakerName}</td>
							<td>${i.time}</td>
							<td>${i.playNum}</td>
							<td><a href="${pageContext.request.contextPath}/video/edit.do?videoId=${i.videoId}">✎</a></td>
							<td><a id="del" href="javascript:void(0);" onclick="delVideoById('#del','${i.videoId}','${i.title}')">X</a></td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="9">
							<itcast:page url="${pageContext.request.contextPath}/video/show.do"/>
						</td>
					</tr>
				</tbody>
			</table>

		</div>
	</form>




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


	
	
	
	<script type="text/javascript">
		function showAddPage(){
			location.href="${pageContext.request.contextPath}/video/addVideoShow.do";
		}
		function delVideoById(Obj,id,title){

			Confirm.show('温馨提示：', '确定要删除'+title+'么？', {
				'Delete': {
					'primary': true,
					'callback': function() {
						var param={"id":id};
						$.post("${pageContext.request.contextPath}/video/delVideoById.do",param,function(data){
							if(data == "success"){
								Confirm.show('温馨提示：', '删除成功');
								$(Obj).parent().parent().remove();
								window.location.reload();
							}else{
								Confirm.show('温馨提示：', '操作失败');
							}
						});
					}
				}
			});
		}
		
		
		/*全选与取消*/
		var isCheckAll = false;  
	    function swapCheck() {  
	        if (isCheckAll) {  
	            $("input[type='checkbox']").each(function() {  
	                this.checked = false;  
	            });  
	            isCheckAll = false;  
	        } else {  
	            $("input[type='checkbox']").each(function() {  
	                this.checked = true;  
	            });  
	            isCheckAll = true;  
	        }  
	    }
		
	    /*批量删除*/
	    function deleteAll() {
			var check = document.getElementsByName("check");
			var ids = "";
			for (var i = 0; i < check.length; i++) {
				if (i == check.length-1) {
					if (check[i].checked) {
						ids+=check[i].value;
					}
				} else {
					if (check[i].checked) {
						ids+=check[i].value+",";
					}
				}
			}
			deleteCustomer(ids);
		}
	    function deleteCustomer(ids) {
	    	Confirm.show('温馨提示：', '确定要删除所选用户吗？',{
				'Delete': {
					'primary': true,
					'callback': function() {
						$.post({
							url:"${pageContext.request.contextPath}/video/deleteAll.do?ids="+ids,
							success:function(data){
			    				Confirm.show('温馨提示：', '删除成功');
			    				setTimeout(function(){
			    					window.location.reload();
			    				},2000)
			    			}
							
						});
					}
				}
			});
		}
	    
	    
	</script>
</body>
</html>