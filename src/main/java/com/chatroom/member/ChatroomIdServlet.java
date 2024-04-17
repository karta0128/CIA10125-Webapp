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

	public List<ChatroomIdVO> getAllRoom() {
		return dao.getAllRoom();
	}
	public List<ChatroomIdVO> getAll() {
		return dao.getAll();
	}
//	public static void main(String[] args) {
//		ChatroomIdServlet ca = new ChatroomIdServlet();
//		List<ChatroomIdVO>cb = ca.getAll();
//		System.out.println(cb);
//		for(ChatroomIdVO ab:cb) {
//			System.out.println(ab.getChatroomId());
//			System.out.println(ab.getMemberA());
//			System.out.println(ab.getMemberB());
//		}
//		
//	}
}
