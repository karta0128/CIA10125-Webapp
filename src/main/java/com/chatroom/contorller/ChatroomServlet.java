package com.chatroom.contorller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chatroom.member.ChatroomIdServlet;
import com.chatroom.member.ChatroomIdVO;
import com.chatroom.message.MessageIdVO;
import com.chatroom.message.MessageServlet;

@WebServlet("/chatroom/chatroom.do")
public class ChatroomServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		/* ============ 取得單一聊天室資訊 ============ */
		if ("getOne_chatroom".equals(action)) {
			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);

			// ------ 接收請求參數 ------//
			String str = req.getParameter("chatroomid");
			if (str == null || str.trim().length() == 0) {
				errorMsgs.put("chatroomid", "請輸入聊天室編號");
			}
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/chatroom/select_page.jsp");
				failureView.forward(req, res);
				return;
			}
			Integer chatroomid = null;
			try {
				chatroomid = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.put("chatroomid", "聊天室編號格式不正確");
			}
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/chatroom/select_page.jsp");
				failureView.forward(req, res);
				return;
			}

			// ------ 查詢 ------//
			ChatroomIdServlet roomSvc = new ChatroomIdServlet();
			ChatroomIdVO roomVO = roomSvc.getOneRoom(chatroomid);
			if (roomVO == null) {
				errorMsgs.put("chatroomid", "查無資料");
			}
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/chatroom/select_page.jsp");
				failureView.forward(req, res);
				return;
			}
//			System.out.println(chatroomid);
//			System.out.println(roomVO.getMemberA());
//			System.out.println(roomVO.getMemberB());

			// ------ 發送 ------//
			req.setAttribute("roomVO", roomVO);
			String url = "/chatroom/listOneEmp.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}

		/* ============ 取得單一聊天室訊息 ============ */
		if ("get_Message".equals(action)) {
			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);
			System.out.println("ERROR - 1");
			// ------ 接收請求參數 ------//
			String str = req.getParameter("chatroomid");
			if (str == null || str.trim().length() == 0) {
				errorMsgs.put("chatroomid", "請輸入聊天室編號");
			}
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/chatroom/select_page.jsp");
				failureView.forward(req, res);
				return;
			}
//			Integer chatroomid = null;
			System.out.println("ERROR - 2");
//			try {
//				chatroomid = Integer.valueOf(str);
//			} catch (Exception e) {
//				errorMsgs.put("chatroomid", "聊天室編號格式不正確");
//			}
//			if (!errorMsgs.isEmpty()) {
//				RequestDispatcher failureView = req.getRequestDispatcher("/chatroom/select_page.jsp");
//				failureView.forward(req, res);
//				return;
//			}
			System.out.println("ERROR - 3");
			// ------ 查詢 ------//
			MessageServlet mesSvc = new MessageServlet();
			List<MessageIdVO> mesVO = mesSvc.getOneMes(str);
			if (mesVO == null) {
				errorMsgs.put("chatroomid", "查無資料");
			}
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/chatroom/getMessage.jsp");
				failureView.forward(req, res);
				return;
			}
			// ------ 發送 ------//
			req.setAttribute("mesVO", str);
			String url = "/chatroom/getMessage.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
			System.out.println("ERROR - end");
		}

		/* ============ 新增聊天室ID ============ */
		if ("add_Chatroom".equals(action)) {
			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);
			System.out.println("ERROR - 1");
			// ------ 接收請求參數 ------//
			String memA = req.getParameter("memberA");
			String memB = req.getParameter("memberB");
			if (memA == null || memA.trim().length() == 0) {
				errorMsgs.put("memberA", "請輸入會員編號");
			}
			if (memB == null || memB.trim().length() == 0) {
				errorMsgs.put("memberB", "請輸入會員編號");
			}
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/chatroom/addChatroom.jsp");
				failureView.forward(req, res);
				return;
			}
			Integer memAid = null;
			Integer memBid = null;
			System.out.println("ERROR - 2");
			try {
				memAid = Integer.valueOf(memA);
				memBid = Integer.valueOf(memB);
			} catch (Exception e) {
				errorMsgs.put("member", "請檢查會員編號");
			}
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/chatroom/addChatroom.jsp");
				failureView.forward(req, res);
				return;
			}
			System.out.println("ERROR - 3");
			// ------ 新增 ------//
			ChatroomIdServlet roomSvc = new ChatroomIdServlet();
			roomSvc.addRoom(memAid, memBid);

			// ------ 發送 ------//
			ChatroomIdVO roomVO = new ChatroomIdVO();
			req.setAttribute("roomVO", roomVO);
			String url = "/chatroom/getMessage.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
			System.out.println("ERROR - end");
		}
	}

//	public static void main(String[] args) {
//		Integer chatroomid = 1;
//		ChatroomIdServlet roomSvc = new ChatroomIdServlet();
//		ChatroomIdVO roomVO = roomSvc.getOneRoom(chatroomid);
//		System.out.println(roomVO.getChatroomId());
//		System.out.println(roomVO.getMemberA());
//		System.out.println(roomVO.getMemberB());
//	}
}
