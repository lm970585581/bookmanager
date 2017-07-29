<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'lendbook.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<style type="text/css">
.font1 {
	font-size: 13px;
}
</style>


</head>

<body>
	<table border="1" width="599">
		<s:form action="LendAction!lendBook" method="post" theme="simple">
			<tr bgcolor="#e9edf5" class="font1">
				<s:if test="#request.readerId==null">
					<td colspan="2">图书信息&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ISBN<s:textfield
							name="bookId" size="15" disabled="true"></s:textfield> <s:submit
							value="借书" disabled="true"></s:submit></td>
				</s:if>
				<s:else>
					<td colspan="2">图书信息&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ISBN<s:textfield
							name="bookId" size="15"></s:textfield> <s:submit value="借书"></s:submit>
					</td>
				</s:else>
			</tr>
		</s:form>
		<tr>
			<td height="360" valign="top"><jsp:include
					page="lendbookinfo.jsp"></jsp:include></td>
		</tr>
		<tr>
			<td align="center"><font color="red"><s:property
						value="message" /> </font></td>
		</tr>
		<tr bgcolor="#e9edf5" class="font1">
			<td align="right"><s:set name="page" value="#request.page"></s:set>
				<a
				href="selectBook?pageNow=1&readerId=<s:property value="#request.readerId"/>">
					首页 </a> <s:if test="#page.hasPre">
					<a
						href="selectBook?pageNow=<s:property value="#page.pageNow-1"/>&readerId=<s:property value="#request.readerId"/>">
						上一页 </a>
				</s:if> <s:else>
					<a
						href="selectBook?pageNow=1&readerId=<s:property value="#request.readerId"/>">
						上一页 </a>
				</s:else> <s:if test="#page.hasNext">
					<a
						href="selectBook?pageNow=<s:property value="#page.pageNow+1"/>&readerId=<s:property value="#request.readerId"/>">
						下一页 </a>
				</s:if> <s:else>
					<a
						href="selectBook?pageNow=<s:property value="#page.totalPage"/>&readerId=<s:property value="#request.readerId"/>">
						下一页 </a>
				</s:else> <a
				href="selectBook?pageNow=<s:property value="#page.totalPage"/>&readerId=<s:property value="#request.readerId"/>">
					尾页 </a>
			</td>
		</tr>
	</table>
</body>
</html>
