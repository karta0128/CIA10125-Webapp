<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.chatroom.member.*"%>
<%@ page import="java.util.*"%>

<%!
	ChatroomIdServlet roomSvc = new ChatroomIdServlet();
	List<ChatroomIdVO> list = roomSvc.getAll();
	int indexEnd = list.size()+1;
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>新增聊天室 - addChatroom.jsp</title>

<style>
  table#table-1 {
    width: 450px;
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
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
  }
  table, th, td {
    border: 0px solid #CCCCFF;
  }
  th, td {
    padding: 1px;
  }
</style>

</head>
<body bgcolor='white'>

<table id="table-1">
	<tr><td>
		 <h3>新增聊天室 - addChatroom.jsp</h3></td><td>
		 <h4><a href="select_page.jsp"><img src="images/tomcat.png" width="100" height="100" border="0">回首頁</a></h4>
	</td></tr>
</table>

<h3>資料新增:</h3>

<%-- 錯誤表列 --%>
<%-- <c:if test="${not empty errorMsgs}"> --%>
<!-- 	<font style="color:red">請修正以下錯誤:</font> -->
<!-- 	<ul> -->
<%-- 		<c:forEach var="message" items="${errorMsgs}"> --%>
<%-- 			<li style="color:red">${message.value}</li> --%>
<%-- 		</c:forEach> --%>
<!-- 	</ul> -->
<%-- </c:if> --%>

<FORM METHOD="post" ACTION="chatroom.do" name="form1">
<table>
	
		
	<tr>
		<td>聊天室編號:</td>
		<td><input type="TEXT" name="chatroomid" value="<%out.print(indexEnd); %>" size="20" readonly/></td> <td></td>
	</tr>
	<tr>
		<td>會員_A</td>
		<td><input type="TEXT" name="memberA"   size="20"/></td> <td>${errorMsgs.memberA}</td>
	</tr>
	<tr>
		<td>會員_B</td>
		<td><input  name="memberB" type="text" ></td> <td>${errorMsgs.memberB}</td>
	</tr>


</table>
<br>
<input type="hidden" name="action" value="add_Chatroom">
<input type="submit" value="送出新增">
</FORM>

</body>
</html>