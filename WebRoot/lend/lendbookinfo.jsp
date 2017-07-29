<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'lendbookinfo.jsp' starting page</title>
    
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
    <table border="1" align="center" width="570" cellpadding="10" cellspacing="0" bgcolor="#71cabf" class="font1">
    	<tr bgcolor="e9edf5">
    		<th>图书ID</th><th>ISBN</th><th>书名</th><th>出版社</th><th>价格</th><th>借书时间</th>
    	</tr>
    	<s:iterator value="#request.list" id="lend">
    		<tr>
    			<td><s:property value="#lend.bookId"/></td>
    			<td><s:property value="#lend.ISBN"/></td>
    			<td><s:property value="#lend.bookName"/></td>
    			<td><s:property value="#lend.publisher"/></td>
    			<td><s:property value="#lend.price"/></td>
    			<td><s:date name="#lend.lTime" format="yyyy-MM-dd"/></td>
    		</tr>
    	</s:iterator>
    </table>
  </body>
</html>
