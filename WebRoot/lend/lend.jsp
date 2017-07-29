<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>图书管理系统</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">


</head>

<body>
	<table bgcolor="#71cabf" align="center">
		<tr>
			<td colspan="2"><jsp:include page="/index/head.jsp"></jsp:include> </td>
		</tr>
		<tr>
			<td><jsp:include page="search.jsp"></jsp:include> </td>
			<td><jsp:include page="lendbook.jsp"></jsp:include> </td>
		</tr>
		<tr>
			<td colspan="2" align="center"><font size="2">南京师范大学：南京市宁海路122号&nbsp;&nbsp;邮编：210097<br> 
			师教教育研究中心版权所有2010-2015</font>
			</td>
		</tr>
	</table>
</body>
</html>
