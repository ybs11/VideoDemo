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

<link href="/VideoSSM/static/z/bootstrap/css/bootstrap.css"
	rel="stylesheet">

<script src="/VideoSSM/static/js/jquery-1.js"></script>
<script src="/VideoSSM/static/js/bootstrap.js"></script>
<script src="/VideoSSM/static/js/confirm.js"></script>
<script src="/VideoSSM/static/js/jquery.js"></script>
<script src="/VideoSSM/static/js/message_cn.js"></script>

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
					<li class="active"><a href="/VideoSSM/videoShow.do">视频管理</a></li>
					<li><a href="/VideoSSM/speakerShow.do">主讲人管理</a></li>
					<li><a href="/VideoSSM/courseShow.do">课程管理</a></li>
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

	<form action="/VideoSSM/videoDeleteAll.do" id="videoForm">
		<div class="container">
			<button onclick="showAddPage()" type="button"
				class="btn btn-info dropdown-toggle" data-toggle="dropdown"
				aria-haspopup="true" aria-expanded="false">添加</button>
			<input id="ids" name="ids" type="hidden">
			<button onclick="deleteAll()" type="submit" id="btn"
				class="btn btn-primary">批量删除</button>
		<div class="d">
		<input type="text" placeholder="标题" id="in" name="factor" class="" value="">
			<select name="speakerId" id="speaker" class="btn btn-primary">
				<option value="0">请选择老师</option>	
			           <c:forEach items="${speaker}" var="i" >
				        <option value="${i.id}">${i.speakerName}</option>
				       </c:forEach>
			</select>
			<select name="courseId" id="course" class="btn btn-primary">
				<option value="0">请选择课程</option>	
			       <c:forEach items="${course}" var="j" >
				        <option value="${j.id}">${j.courseTitle}</option>
				    </c:forEach>
			</select>
			<button type="button" onclick="selectFor()" class="btn btn-info dropdown-toggle">查询</button>
		</div>
		
		</div>

		<div class="container" style="margin-top: 20px;">

			<table class="table table-bordered table-hover"
				style="text-align: center; table-layout: fixed;">
				<thead>
					<tr class="active">
						<th><input type="checkbox" id="all"></th>
						<th>序号</th>
						<th style="width: 16%">标题</th>
						<th style="width: 36%">介绍</th>
						<th>讲师</th>
						<th>时长</th>
						<th>播放次数</th>
						<th>编辑</th>
						<th>删除</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${video}" var="k">
						<tr>
							<td><input type="checkbox" name="select" value="${k.videoId}"></td>
							<td>${k.videoId}</td>
							<td>${k.title}</td>
							<td style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis;">${k.detail}</td>
							<td>${k.speaker.speakerName}</td>
							<td>${k.time}</td>
							<td>${k.playNum}</td>
							
							
							<td><a href="/VideoSSM/videoUpdateShow.do?id=${k.videoId} ">✎</a></td>
							<td><a href="javascript:void(0);" id="del"
								onclick="delVideoById('#del','${k.videoId}','${k.title}')">X</a></td>
					</c:forEach>
					<tr>
						<td colspan="9"><font>总共${count}条,当前第${page}页</font> <c:if
								test="${count%5==0}">
								<c:set var="page" value="${count/5}">
								</c:set>
							</c:if> <c:if test="${count%5!=0}">
								<c:set var="page" value="${count/5+1}">
								</c:set>
							</c:if>
							<c:if test="${factor != null || speakerId !=null  || courseId !=null}">
							<c:forEach var="i" begin="1" end="${page}">
								<a href="videoSelectLike.do?page=${i}&factor=${factor}&speakerId=${speakerId}&courseId=${courseId}">第${i}页</a>
							</c:forEach>
							</c:if>
							<c:if test="${factor eq null}">
							<c:forEach var="i" begin="1" end="${page}">
								<a href="videoShow.do?page=${i}">第${i}页</a>
							</c:forEach>	
							</c:if>
						
					</tr>
				</tbody>
			</table>

		</div>
	</form>




	<script type="text/javascript">
		function selectFor(){
			$("#videoForm").attr('action','/VideoSSM/videoSelectLike.do').submit();
			
		}
	
	
	   $(function() {
			$("#all").click(function() {
				$("input[name='select']").attr("checked", this.checked);
			})

		})
		function deleteAll() {
			var selected = [];
			$.each($("input[name='select']"), function() {
				if (this.checked) {
					selected.push($(this).val());
				}
			})
			var ids = JSON.stringify(selected);
			$("#ids").val(ids);
		}
		function showAddPage() {
			location.href = "/VideoSSM/videoAddShow.do";
		}
		function delVideoById(Obj, id, title) {

			Confirm.show('温馨提示：', '确定要删除' + title + '么？', {
				'Delete' : {
					'primary' : true,
					'callback' : function() {
						var param = {
							"id" : id
						};
						$.post("/VideoSSM/videoDelete.do", param, function(
								data) {
							if (data == 'success') {
								
								Confirm.show('温馨提示：', '删除成功');
								window.location.reload();
								//$(Obj).parent().parent().remove();
							} else {
								Confirm.show('温馨提示：', '操作失败');
							}
						});
					}
				}
			});
		}
	</script>


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