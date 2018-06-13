<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css"
	href="<%=path%>/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="<%=path%>/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"
	href="<%=path%>/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css"
	href="<%=path%>/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css"
	href="<%=path%>/static/h-ui.admin/css/style.css" />
<link rel="stylesheet" type="text/css"
	href="<%=path%>/lib/css/admin.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>用户管理</title>
</head>
<body>
	<nav class="breadcrumb"> <i class="Hui-iconfont">&#xe67f;</i> 首页
	<span class="c-gray en">&gt;</span> 用户中心 <span class="c-gray en">&gt;</span>
	用户管理 <a class="btn btn-success radius r"
		style="line-height: 1.6em; margin-top: 3px"
		href="javascript:location.replace(location.href);" title="刷新"><i
		class="Hui-iconfont">&#xe68f;</i></a></nav>
	<div class="page-container">
		<div class="cl pd-5 bg-1 bk-gray mt-20">
			<span class="l"><a href="javascript:;"
				onclick="member_add('添加用户','<%=path%>/common/admin/user_add','','510')"
				class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i>
					添加用户</a> </span> <span class="r">共有数据：<strong>${totalcount }</strong> 条
			</span>
		</div>
		<div class="mt-20">
			<table class="table table-border table-bordered table-hover table-bg">
				<thead>
					<tr class="text-c">
						<th width="80">ID</th>
						<th>用户名</th>
						<th>姓名</th>
						<th>性别</th>
						<th>年龄</th>
						<th>手机</th>
						<th>办卡时间</th>
						<th>办卡时长</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list }" var="c">
						<tr class="text-c">
							<td>${c.user_id }</td>
							<td>${c.username }</td>
							<td>${c.name }</td>
							<td>${c.sex }</td>
							<td>${c.age }</td>
							<td>${c.tel }</td>
							<td>${c.cardtime }</td>
							<td>${c.cardlengthtime }</td>

							<td class="td-manage"><a title="编辑" href="javascript:;"
								onclick="member_edit('编辑','member-add.html','4','','510')"
								class="ml-5" style="text-decoration: none"><i
									class="Hui-iconfont">&#xe6df;</i></a> <a
								style="text-decoration: none" class="ml-5"
								onClick="change_password('修改密码','change-password.html','10001','600','270')"
								href="javascript:;" title="修改密码"><i class="Hui-iconfont">&#xe63f;</i></a>
								<a title="删除" href="javascript:;" onclick="member_del(this,'1')"
								class="ml-5" style="text-decoration: none"><i
									class="Hui-iconfont">&#xe6e2;</i></a></td>
						</tr>
					</c:forEach>
				</tbody>
				<tr>
					<td colspan="9"><div class="pagelist">
							<c:if test="${currpage > 1}">
								<a href="<%=path %>/userCtrl/queryUser?currpage=${currpage-1}">上一页</a>
							</c:if>
							<c:if test="${currpage < pagecount}">|当前${currpage}页/总${pagecount}页|
        <a href="<%=path %>/userCtrl/queryUser?currpage=${currpage+1}">下一页</a>
							</c:if>
						</div></td>
				</tr>
			</table>
		</div>
	</div>
	<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript"
		src="<%=path%>/lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path%>/lib/layer/2.4/layer.js"></script>
	<script type="text/javascript"
		src="<%=path%>/static/h-ui/js/H-ui.min.js"></script>
	<script type="text/javascript"
		src="<%=path%>/static/h-ui.admin/js/H-ui.admin.js"></script>
	<!--/_footer 作为公共模版分离出去-->

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript"
		src="<%=path%>/lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript"
		src="<%=path%>/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
	<script type="text/javascript"
		src="<%=path%>/lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript">
		$(function() {
			$('.table-sort').dataTable({
				"aaSorting" : [ [ 1, "desc" ] ],//默认第几个排序
				"bStateSave" : true,//状态保存

			});

		});
		/*用户-添加*/
		function member_add(title, url, w, h) {
			layer_show(title, url, w, h);
		}
		/*用户-查看*/
		function member_show(title, url, id, w, h) {
			layer_show(title, url, w, h);
		}
		/*用户-停用*/
		function member_stop(obj, id) {
			layer
					.confirm(
							'确认要停用吗？',
							function(index) {
								$
										.ajax({
											type : 'POST',
											url : '',
											dataType : 'json',
											success : function(data) {
												$(obj)
														.parents("tr")
														.find(".td-manage")
														.prepend(
																'<a style="text-decoration:none" onClick="member_start(this,id)" href="javascript:;" title="启用"><i class="Hui-iconfont">&#xe6e1;</i></a>');
												$(obj)
														.parents("tr")
														.find(".td-status")
														.html(
																'<span class="label label-defaunt radius">已停用</span>');
												$(obj).remove();
												layer.msg('已停用!', {
													icon : 5,
													time : 1000
												});
											},
											error : function(data) {
												console.log(data.msg);
											},
										});
							});
		}

		/*用户-启用*/
		function member_start(obj, id) {
			layer
					.confirm(
							'确认要启用吗？',
							function(index) {
								$
										.ajax({
											type : 'POST',
											url : '',
											dataType : 'json',
											success : function(data) {
												$(obj)
														.parents("tr")
														.find(".td-manage")
														.prepend(
																'<a style="text-decoration:none" onClick="member_stop(this,id)" href="javascript:;" title="停用"><i class="Hui-iconfont">&#xe631;</i></a>');
												$(obj)
														.parents("tr")
														.find(".td-status")
														.html(
																'<span class="label label-success radius">已启用</span>');
												$(obj).remove();
												layer.msg('已启用!', {
													icon : 6,
													time : 1000
												});
											},
											error : function(data) {
												console.log(data.msg);
											},
										});
							});
		}
		/*用户-编辑*/
		function member_edit(title, url, id, w, h) {
			layer_show(title, url, w, h);
		}
		/*密码-修改*/
		function change_password(title, url, id, w, h) {
			layer_show(title, url, w, h);
		}
		/*用户-删除*/
		function member_del(obj, id) {
			layer.confirm('确认要删除吗？', function(index) {
				$.ajax({
					type : 'POST',
					url : '',
					dataType : 'json',
					success : function(data) {
						$(obj).parents("tr").remove();
						layer.msg('已删除!', {
							icon : 1,
							time : 1000
						});
					},
					error : function(data) {
						console.log(data.msg);
					},
				});
			});
		}
	</script>
</body>
</html>