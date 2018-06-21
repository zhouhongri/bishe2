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
<link rel="Bookmark" href="/favicon.ico">
<link rel="Shortcut Icon" href="/favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css"
	href="<%=path %>/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="<%=path %>/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"
	href="<%=path %>/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css"
	href="<%=path %>/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css"
	href="<%=path %>/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<!--/meta 作为公共模版分离出去-->

<title>更新用户</title>
</head>
<body>
	<article class="page-container">
	<form action="<%=path %>/userCtrl/updateUserByIdentity" method="post" class="form form-horizontal"
		id="form-member-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>用户名：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${User.username }" placeholder=""
					id="username" name="username" readonly="readonly">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>姓名：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${User.name }" placeholder=""
					id="name" name="name"  readonly="readonly">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>性别：</label>
			<div class="formControls col-xs-8 col-sm-9 skin-minimal">
				<div class="radio-box">
					<input name="sex" type="radio" id="sex-1" value="男" readonly="readonly"> <label
						for="sex-1">男</label>
				</div>
				<div class="radio-box">
					<input type="radio" id="sex-2" name="sex" value="女"  readonly="readonly"> <label
						for="sex-2">女</label>
				</div>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>年龄：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${User.age }" placeholder=""
					id="age" name="age"  readonly="readonly">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span
				class="c-red">*</span>手机：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${User.tel }" placeholder=""
					id="tel" name="tel"  readonly="readonly">
			</div>
		</div>
		<c:choose>
			<c:when test="${User.identity=='1' }">
				<div class="row cl" id="cardlengthtimeDiv">
					<label class="form-label col-xs-4 col-sm-3"><span
						class="c-red">*</span>办卡时长（天）：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" class="input-text" value="" placeholder=""
							id="cardlengthtime" name="cardlengthtime">
					</div>
				</div>
				<input type="text" name="flag" value="tourist" style="display: none;">
			</c:when>
			<c:otherwise>
				<div class="row cl" id="cardlengthtimeDiv">
					<label class="form-label col-xs-4 col-sm-3"><span
						class="c-red">*</span>续卡时长（天）：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" class="input-text" value="" placeholder=""
							id="lengthtime" name="lengthtime" onblur="add();">
					</div>
				</div>
				<input type="text" id="cardlengthtime" name="cardlengthtime" value="${User.cardlengthtime }" style="display: none;">
				<input type="text" name="flag" value="member" style="display: none;">
			</c:otherwise>
		</c:choose>
		<div style="display: none;">
			<input type="text" id="cardtime" name="cardtime" value=""/>
			<input type="text" name="userId" value="${User.userId }"/>
			<input type="text" name="password" value="${User.password }"/>
			<input type="text" name="money" value="${User.money }"/>
			<input type="text" name="prelogintime" value="${User.prelogintime }"/>
			<input type="text" name="identity" value="2">
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" type="submit"
					value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
			</div>
		</div>
	</form>
	</article>

	<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript" src="<%=path %>/lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path %>/lib/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="<%=path %>/static/h-ui/js/H-ui.min.js"></script>
	<script type="text/javascript" src="<%=path %>/static/h-ui.admin/js/H-ui.admin.js"></script>
	<!--/_footer 作为公共模版分离出去-->

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript"
		src="<%=path %>/lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript"
		src="<%=path %>/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
	<script type="text/javascript"
		src="<%=path %>/lib/jquery.validation/1.14.0/validate-methods.js"></script>
	<script type="text/javascript"
		src="<%=path %>/lib/jquery.validation/1.14.0/messages_zh.js"></script>
	<script type="text/javascript">
		$(function() {
			
			var sexval = '${User.sex}';
			if(sexval=="男"){
				$("#sex-1").attr("checked","checked")
			}else{
				$("#sex-2").attr("checked","checked")
			}
			
			var cardtimeval = '${User.cardtime}';
			if(cardtimeval==null||cardtimeval==""){
				cardtimeval = getTime();
			}
			$("#cardtime").val(cardtimeval);
			
			$('.skin-minimal input').iCheck({
				checkboxClass : 'icheckbox-blue',
				radioClass : 'iradio-blue',
				increaseArea : '20%'
			});

			$("#form-member-add").validate({
				rules : {
					username : {
						required : true,
						minlength : 2,
						maxlength : 16
					},
					name : {
						required : true
					},
					sex : {
						required : true
					},
					age : {
						required : true,
						digits:true
					},
					tel : {
						required : true,
						isMobile : true
					},
					lengthtime : {
						required : true,
						digits:true
					}
				},
				onkeyup : false,
				focusCleanup : true,
				success : "valid",
				submitHandler : function(form) {
					$.post($(form).attr('action'),$(form).serialize(),function(result){
						if(result){
							var index = parent.layer.getFrameIndex(window.name);
							parent.location.reload();
							parent.layer.close(index);
						}else{
							parent.layer.msg('系统错误！');
						}
					},"json");
				}
			});
		});
		function getTime(){
			var date = new Date();
		    var seperator1 = "-";
		    var seperator2 = ":";
		    var month = date.getMonth() + 1;
		    var strDate = date.getDate();
		    if (month >= 1 && month <= 9) {
		        month = "0" + month;
		    }
		    if (strDate >= 0 && strDate <= 9) {
		        strDate = "0" + strDate;
		    }
		    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate;
		    return currentdate;
	 }
		
	function add(){
		var lengthtimeval = $("#lengthtime").val();
		var cardlengthtimeval = $("#cardlengthtime").val();
		$("#cardlengthtime").val(lengthtimeval*1+cardlengthtimeval*1);
	}
	</script>
	<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>