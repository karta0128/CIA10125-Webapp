package com.chatroom.contorller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chatroom.member.ChatroomIdServlet;
import com.chatroom.member.ChatroomIdVO;
@WebServlet("/chatDo")
public class ChatroomServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("get_all_chatroom".equals(action)) {
			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);
			//------ 接收請求參數
			String str = req.getParameter("chatroomid");
			if(str.trim().length() == 0) {
				errorMsgs.put("chatroomid", "請輸入聊天室編號");
			}
			if(!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/chatroom/select_page.jsp");
				failureView.forward(req, res);
				return;
			}
			Integer chatroomid = null;
			try {
				chatroomid = Integer.valueOf(str);
			}catch(Exception e) {
				errorMsgs.put("chatroomid", "聊天室編號格式不正確");
			}
			if(!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/chatroom/select_page.jsp");
				failureView.forward(req, res);
				return;
			}
			
			//------ 查詢
			ChatroomIdServlet roomSvc = new ChatroomIdServlet();
			ChatroomIdVO roomVO = roomSvc.getOneRoom(chatroomid);
			if(roomVO == null) {
				errorMsgs.put("chatroomid", "查無資料");
			}
			if(!errorMsgs.isEmpty()) {
				RequestDispatcher failureView =req.getRequestDispatcher("/chatroom/select_page.jsp");
				failureView.forward(req, res);
				return;
			}
			
			//------ 發送
			req.setAttribute("roomVO", roomVO);
			String url = "/chatroom/listOneEmp.jsp";
			RequestDispatcher successView =req.getRequestDispatcher(url);
			successView.forward(req, res);
		}
		
		
	}
}
