<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>ͼ�����ϵͳ</title>
<style >
	.font1{font-size:13px}
</style>
<script language="javascript">
	function check(thisObject)
	{
		var sTmp="";
		sTmp=thisObject.value;
		if(isNaN(sTmp))
		{
			alert("����������");
			thisObject.select();
		}
	}
</script>

  </head>
  
  <body>
  		<table bgcolor=#71CABF align="center" class="font1">
  		<tr>
  			<td colspan="2"><jsp:include page="../index/head.jsp"/></td>
  		</tr>
  		<tr>
  			<s:form theme="simple" action="book" method="post" enctype="multipart/form-data" validate="true">
  			<td><jsp:include page="funcselect.jsp"/></td>
  			<td><jsp:include page="bookinfo.jsp"/></td>
  			</s:form>
  		</tr>
  		<tr>
  			<td colspan="2" algin="center">�Ͼ�ʦ����ѧ���Ͼ�������·122��&nbsp;&nbsp;�ʱ�:210097<br>
  			ʦ�̽����о����İ�Ȩ����
  			</td>
  		</tr>
  		</table>
  </body>
</html>
