<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>IBM Emp: Home</title>

<style>
table#table-1 {
	width: 450px;
	background-color: #CCCCFF;
	margin-top: 5px;
	margin-bottom: 10px;
	border: 3px ridge Gray;
	height: 80px;
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

</head>
<body bgcolor='white'>

	<table id="table-1">
		<tr>
			<td><h3>IBM Emp: Home</h3>
				<h4>( MVC )</h4></td>
		</tr>
	</table>

	<p>This is the Home page for IBM Emp: Home</p>

	<h3>資料查詢:</h3>

	<%-- 錯誤表列 --%>
	<%-- <c:if test="${not empty errorMsgs}"> --%>
	<!-- 	<font style="color:red">請修正以下錯誤:</font> -->
	<!-- 	<ul> -->
	<%-- 		<c:forEach var="message" items="${errorMsgs}"> --%>
	<%-- 			<li style="color:red">${message.value}</li> --%>
	<%-- 		</c:forEach> --%>
	<!-- 	</ul> -->
	<%-- </c:if> --%>

	<ul>
		<li><a href='allChatroom.jsp'>所有聊天室</a> 的喔. <br> <br></li>


		<li>
			<FORM METHOD="post" ACTION="chatroom.do">
				<b>輸入聊天室編號 (如1):</b> <input type="text" name="chatroomid"><font
					color=red>${errorMsgs.chatroomid}</font> <input type="hidden"
					name="action" value="getOne_chatroom"> <input
					type="submit" value="送出">
			</FORM>
		</li>
		<jsp:useBean id="chatid" scope="page"
			class="com.chatroom.member.ChatroomIdServlet" />
		<li>
			<FORM METHOD="post" ACTION="chatroom.do">
				<b>選擇聊天室編號:</b> <select size="1" name="chatroomid">
					<c:forEach var="chatroomVO" items="${chatid.all}">
						<option value="${chatroomVO.chatroomId}">${chatroomVO.chatroomId}
					</c:forEach>
				</select> <input type="hidden" name="action" value="getOne_chatroom">
				<input type="submit" value="送出">
			</FORM>
		</li>

		<li>
			<FORM METHOD="post" ACTION="chatroom.do">
				<b>選擇聊天編號並查看訊息內容:</b> <select size="1" name="chatroomid">
					<c:forEach var="chatroomVO" items="${chatid.all}">
						<option value="${chatroomVO.chatroomId}">${chatroomVO.chatroomId}
					</c:forEach>
				</select> <input type="hidden" name="action" value="get_Message">
				<input type="submit" value="送出">
			</FORM>
		</li>
	</ul>


	<h3>員工管理</h3>

	<ul>
		<li><a href='addChatroom.jsp'>我想與人獨處一室</a>新增聊天室</li>
	</ul>
	<ul>
		<li><a href='addEmp.jsp'>我想大聲說</a>新增訊息</li>
	</ul>




</body>
</html>