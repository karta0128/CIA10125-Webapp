package com.chatroom.member;

import java.util.List;
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

	public void deleteRoom(Integer id) {
		dao.deleteChatroom(id);
	}

	public ChatroomIdVO getOneRoom(Integer id) {
		return dao.getOneChatroom(id);
	}

	public Set<ChatroomIdVO> getAllMembetRoom(Integer id) {
		return dao.getAllChatroom(id);
	}

	public List<ChatroomIdVO> getAll() {
		return dao.getAll();
	}
//	public static void main(String[] args) {
//		ChatroomIdServlet ca = new ChatroomIdServlet();
//		ChatroomIdVO cb = ca.getOneRoom(1);
//		System.out.println(cb.getChatroomId());
//		System.out.println(cb.getMemberA());
//		System.out.println(cb.getMemberB());
//	}
}
