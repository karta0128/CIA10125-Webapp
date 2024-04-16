package com.chatroom.member;

import java.util.Set;

import javax.servlet.annotation.WebServlet;
@WebServlet("/chatS.do")
public class ChatroomIdServlet {
	private ChatroomIdDAO dao;

	public ChatroomIdServlet() {
		dao = new ChatroomIdDAOImp();
	}

	public ChatroomIdVO addRoom(Integer a, Integer b) {
		ChatroomIdVO crVO = new ChatroomIdVO();
		crVO.setMemberA(a);
		crVO.setMemberB(b);
		return crVO;
	}

	public void deleteRoom(Integer id) {
		dao.deleteChatroom(id);
	}

	public ChatroomIdVO getOneRoom(Integer id) {
		return dao.getOneChatroom(id);
	}

	public Set<ChatroomIdVO> getAllRoom(Integer id) {
		return dao.getAllChatroom(id);
	}
}
