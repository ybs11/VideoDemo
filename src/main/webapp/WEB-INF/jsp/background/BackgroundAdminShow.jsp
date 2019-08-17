<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>智游教育</title>

<link href="/static/z/bootstrap/css/bootstrap.css" rel="stylesheet">

<script src="/static/js/jquery-1.js"></script>
<script src="/static/js/bootstrap.js"></script>
<script src="/static/js/confirm.js"></script>
<script src="/static/js/jquery.js"></script>
<script src="/static/js/message_cn.js"></script>

<style type="text/css">
th {
	text-align: center;
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
					<li><a href="/video/show.do">视频管理</a></li>
					<li> <a href="/speaker/show.do">主讲人管理</a></li>
					<li ><a href="/course/list.do">课程管理</a></li>
					<c:if test="${admin.adminIsSuper==1}">
						<li class="active"><a href="/admin/show.do">管理员管理</a></li>
					</c:if>
</ul>
				<p class="navbar-text navbar-right">
					<span>${admin.accounts}</span> <i class="glyphicon glyphicon-log-in"
						aria-hidden="true"></i>&nbsp;&nbsp;<a class="navbar-link" href="/admin/loginOut.do">退出</a>
				</p>
			</div>
			


		</div>

	</nav>






	<div class="jumbotron" style="padding-top: 15px; padding-bottom: 15px;">
		<div class="container">
			<h2>管理员管理</h2>
		</div>
	</div>

	<form action="">
		<div class="container">
			<button onclick="showAddPage()" type="button"
				class="btn btn-info dropdown-toggle" data-toggle="dropdown"
				aria-haspopup="true" aria-expanded="false">添加</button>

			<button onclick="deleteAll()" type="button" id="btn"
				class="btn btn-info dropdown-toggle">批量删除</button>
		</div>

		<div class="container" style="margin-top: 20px;">

			<table class="table table-bordered table-hover"
				style="text-align: center; table-layout: fixed;">
				<thead>
					<tr class="active">
						<th><input type="checkbox" id="all" onclick="swapCheck()"></th>
						<th>序号</th>
						<th>用户名</th>
						<th>是否为超级管理员</th>
						<th style="width: 30%">备注</th>
						<th>编辑</th>
						<th>删除</th>
					</tr>
				</thead>
				<tbody>
				
					<c:forEach items="${list.data}" var="i">
						<tr>
							<td><input type="checkbox" name="check" value="${i.adminId}"></td>
							<td>${i.adminId}</td>
							<td>${i.accounts}</td>
							<c:if test="${i.adminIsSuper==1}">
								<td>超级管理员</td>
							</c:if>
							<c:if test="${i.adminIsSuper!=1}">
								<td>普通管理员</td>
							</c:if>
							<td style="overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${i.adminRemark}</td>
							<td><a href="${pageContext.request.contextPath}/admin/edit.do?id=${i.adminId}">✎</a></td>
							<td><a id="del" href="javascript:void(0);" onclick="delAdminById('#del','${i.adminId}','${i.accounts}')">X</a></td>
						</tr>
					</c:forEach>

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
			location.href="${pageContext.request.contextPath}/admin/addAdminShow.do";
		}
		function delAdminById(Obj,id,title){

			Confirm.show('温馨提示：', '确定要删除'+title+'么？', {
				'Delete': {
					'primary': true,
					'callback': function() {
						var param={"id":id};
						$.post("${pageContext.request.contextPath}/admin/delAdminById.do",param,function(data){
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
							url:"${pageContext.request.contextPath}/admin/deleteAll.do?ids="+ids,
							success:function(data){
			    				Confirm.show('温馨提示：', '删除成功');
			    				setTimeout(function(){
			    					window.location.reload();
			    				},3000)
			    			}
							
						});
					}
				}
			});
		}
	    
	    
	</script>
	
	
</body>
</html>