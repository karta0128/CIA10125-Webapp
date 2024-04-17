<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.chatroom.message.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
	MessageServlet mesSvc = new MessageServlet();
	String str = (String)request.getAttribute("mesVO");
	List<MessageIdVO> list = mesSvc.getOneMes(str);
    pageContext.setAttribute("list",list);
%>


<html>
<head>
<title>所有員工資料 - listAllEmp.jsp</title>

<style>
  table#table-1 {
	background-color: #CCCCFF;
    border: 2px solid black;
    text-align: center;
  }
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 1px;
  }
  h4 {
    color: blue;
    display: inline;
  }
</style>

<style>
  table {
	width: 800px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
  }
  table, th, td {
    border: 1px solid #CCCCFF;
  }
  th, td {
    padding: 5px;
    text-align: center;
  }
</style>

</head>
<body bgcolor='white'>

<h4>此頁練習採用 EL 的寫法取值:</h4>
<table id="table-1">
	<tr><td>
		 <h3>所有聊天室資訊 - getMessage.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/back1.jpg" width="100" height="100" border="0">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>會員編號</th>
		<th>訊息內容</th>
		<th>圖片</th>
		<th>發送時間</th>
		<th>修改訊息</th>
		<th>刪除訊息</th>

	</tr>
	<%@ include file="page1.file" %> 
	<c:forEach var="messageVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		
		<tr>
			<td>${messageVO.getType()}</td>
			<td>${messageVO.getContent()}</td>
			<td>${messageVO.getImg()}</td>
			<td>${messageVO.getDate()}</td>

			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/chatroom/chatroom.do" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="messageid"  value="${messageVO.getMessageId()}">
			     <input type="hidden" name="action" value="update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/chatroom/chatroom.do" style="margin-bottom: 0px;">
			     <input type="submit" value="刪除">
			     <input type="hidden" name="messageid"  value="${messageVO.getMessageId()}">
			     <input type="hidden" name="action" value="delete"></FORM>
			</td>
		</tr>
	</c:forEach>
</table>
<%@ include file="page2.file" %>

</body>
</html>