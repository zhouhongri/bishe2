<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
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
<link href="<%=path%>/static/h-ui/css/H-ui.min.css" rel="stylesheet"
	type="text/css" />
<link href="<%=path%>/static/h-ui.admin/css/H-ui.login.css"
	rel="stylesheet" type="text/css" />
<link href="<%=path%>/static/h-ui.admin/css/style.css" rel="stylesheet"
	type="text/css" />
<link href="<%=path%>/lib/Hui-iconfont/1.0.8/iconfont.css"
	rel="stylesheet" type="text/css" />
<link href="<%=path%>/lib/layer/2.4/skin/layer.css"
	rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>健身房后台管理系统</title>
</head>
<body>
	<input type="hidden" id="TenantId" name="TenantId" value="" />
	<div class="loginWraper">
		<div id="loginform" class="loginBox">
			<h1 style="text-align: center;">健身房后台管理系统</h1>
			<div class="row cl">
				<label class="form-label col-xs-3"><i class="Hui-iconfont" style="float: right;">&#xe60d;</i></label>
				<div class="formControls col-xs-8">
					<input id="usernameipt" name="username" type="text"
						placeholder="账户" class="input-text size-L">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-3"><i class="Hui-iconfont" style="float: right;">&#xe60e;</i></label>
				<div class="formControls col-xs-8">
					<input id="passwordipt" name="password" type="password"
						placeholder="密码" class="input-text size-L">
				</div>
			</div>
			<div class="row cl">
				<div class="formControls col-xs-8 col-xs-offset-4">
					<input type="button" class="btn btn-success radius size-L" 
					value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;" onclick="toLogin();"> 
						<input type="button" class="btn btn-default radius size-L"
						value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;">
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="<%=path%>/lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="<%=path%>/static/h-ui/js/H-ui.min.js"></script>
		<script type="text/javascript"
		src="<%=path%>/lib/layer/2.4/layer.js"></script>
	<script type="text/javascript">
	function toLogin(){
		var usernameval = $("#usernameipt").val();
		var passwordval = $("#passwordipt").val();
		
		$.post("<%=path%>/loginCtrl/login",{
		"username":usernameval,
		"password":passwordval},function(result){
			if(result.result){
				if(result.useridentity=="管理员"){
					window.location.href="<%=path%>/common/admin/index";
				}else if(result.useridentity=="游客"){
					window.location.href="<%=path%>/common/driver/index";
				}else if(result.useridentity=="会员"){
					window.location.href="<%=path%>/common/driverdemp/index";
				}else if(result.useridentity=="教练"){
					window.location.href="<%=path%>/common/officials/index";
				}
				layer.msg(result.mess, {
					icon : 6
				});
			} else {
				layer.msg(result.mess, {
					icon : 5
				});
			}
			});

		}

		function keyLogin(e) {
			var theEvent = window.event || e;
			var code = theEvent.keyCode || theEvent.which;
			if (code == 13) {
				toLogin();
			}
		}
	</script>
</body>
</html>