<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <style>
  	.font1{font-size:13px;}
  </style>
    
 </head>
  
  <body>
   <table border="1" width="200" cellspacing=1 class="font1">
   <tr bgcolor="#E9EDF5">
     <td>功能选择</td>
   </tr>
   <tr>
   		<td align="center" valign="top" height="400">
			<br><s:submit value="图书追加" method="addBook"/><br>
			<br><s:submit value="图书删除" method="deleteBook"/><br>  
			<br><s:submit value="图书修改" method="updateBook"/><br>  
			<br><s:submit value="图书查询" method="selectBook"/><br>     		
   		</td>
   </tr>
   </table>
  </body>
</html>
