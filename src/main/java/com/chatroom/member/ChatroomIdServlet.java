package com.chatroom.member;

import java.util.Set;

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

	public ChatroomIdVO updateRoom() {
		ChatroomIdVO crVO = new ChatroomIdVO();
		return crVO;
	}

	public ChatroomIdVO deleteRoom(Integer id) {
		ChatroomIdVO crVO = new ChatroomIdVO();
		dao.deleteChatroom(id);
		return crVO;
	}

	public ChatroomIdVO getOneRoom() {
		ChatroomIdVO crVO = new ChatroomIdVO();
		return crVO;
	}

	public Set<ChatroomIdVO> getAllRoom(Integer id) {
		return dao.getAllChatroom(id);
	}
}
