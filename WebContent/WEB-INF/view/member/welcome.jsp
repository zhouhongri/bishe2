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
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>健身房后台管理系统</title>
</head>
<body>
	<div class="page-container">
		<p class="f-20 text-success">欢迎使用</p>
		<c:choose>
			<c:when test="${user.prelogintime!=null && user.prelogintime!=''}">
				<p>上次登录时间：${user.prelogintime }</p>
			</c:when>
			<c:otherwise>
				<p>上次登录时间：无</p>
			</c:otherwise>
		</c:choose>
		<table class="table table-border table-bordered table-bg mt-20">
			<thead>
				<tr>
					<th colspan="2" scope="col">个人信息</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th width="30%">用户名</th>
					<td><span id="username">${user.username }</span></td>
				</tr>
				<tr>
					<td>真实姓名</td>
					<td>${user.name }</td>
				</tr>
				<tr>
					<td>性别</td>
					<td>${user.sex }</td>
				</tr>
				<tr>
					<td>年龄</td>
					<td>${user.age }</td>
				</tr>
				<tr>
					<td>积分</td>
					<td id="integraltd"></td>
				</tr>
				<tr>
					<td>类型</td>
					<td id="typetd"></td>
				</tr>
				<tr>
					<td>办卡时间</td>
					<td>${user.cardtime }</td>
				</tr>
				<tr id="timetr">
					<td>剩余时间</td>
					<td><span id="timespan" style="float:  left;"></span>
					<span id="warnspan" style="color:red;"></span></td>
				</tr>
			</tbody>
		</table>
	</div>
	<script type="text/javascript" src="<%=path%>/lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path%>/static/h-ui/js/H-ui.min.js"></script>
	<script>
		$(function(){
			var userIdval = '${user.userId}';
			var integraltype="普通";
			$.post('<%=path %>/integralCtrl/queryIntegralByUserId',{'userId':userIdval},
					function(result){
				if(result!=null&&result!=""){
					if(result.integralNum<=50){
						integraltype = '白银会员';
					}else if(result.integralNum>50&&result.integralNum<=100){
						integraltype = '黄金会员';
					}else if(result.integralNum>100&&result.integralNum<=200){
						integraltype = '白金会员';
					}else if(result.integralNum>200&&result.integralNum<=500){
						integraltype = '钻石会员';
					}else{
						integraltype = '游客';
					}
				}
				$("#integraltd").text(result.integralNum);
				$("#typetd").text(integraltype);
			})
			
			var date1 = getNowTime();
			var t = dateDiff(date1, "${user.cardtime}");
			
			if(t*1<=0){
				$("#timespan").text("0");
				$("#warnspan").text("（已到期）");
			}else{
				if(t*1<=5){
					$("#warnspan").text("（即将到期）");
				}
				$("#timespan").text(t);
			}
		})
		
		function dateDiff(date1, date2) {
	        var type1 = typeof date1, type2 = typeof date2;
	        if (type1 == 'string')
	            date1 = stringToTime(date1);
	        else if (date1.getTime)
	            date1 = date1.getTime();
	        if (type2 == 'string')
	            date2 = stringToTime(date2);
	        else if (date2.getTime)
	            date2 = date2.getTime();
	        //alert((date1 - date2) / (1000*60*60)); 
	        return (date1 - date2) / (1000 * 60 * 60 * 24); //结果是小时 
	    }
	    //字符串转成Time(dateDiff)所需方法 
	    function stringToTime(string) {
	        var f = string.split(' ', 2);
	        var d = (f[0] ? f[0] : '').split('-', 3);
	        var t = (f[1] ? f[1] : '').split(':', 3);
	        return (new Date(
	       parseInt(d[0], 10) || null,
	       (parseInt(d[1], 10) || 1) - 1,
	        parseInt(d[2], 10) || null,
	        parseInt(t[0], 10) || null,
	        parseInt(t[1], 10) || null,
	        parseInt(t[2], 10) || null
	        )).getTime();

	    }
	    function getNowTime(){
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
	</script>
</body>
</html>