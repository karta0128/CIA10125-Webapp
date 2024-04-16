package com.chatroom.member;

import java.util.List;

public class Test_chatroom {

	public static void main(String[] args) {
//		ChatroomIdVO civo = new ChatroomIdVO();
//		civo.setMemberA(10004);
//		civo.setMemberB(10005);
//		ChatroomIdDAOImp civoi = new ChatroomIdDAOImp();
////		civoi.addChatroom(civo);//ADD ChatroomID
//		List<ChatroomIdVO> list = civoi.getAllChatrom(10001);
//		if (list.isEmpty()) {
//			System.out.println("沒有資料");
//		} else {
//			for (ChatroomIdVO vo : list) {
//				System.out.println("Chatroom : " + vo.getChatroomId());
//				System.out.println("USER A : " + vo.getMemberA());
//				System.out.println("USER B : " + vo.getMemberB());
//			}
//		}
		ChatroomIdDAOImp civoi2 = new ChatroomIdDAOImp();
		civoi2.addChatroom(10004, 10002);

	}

}
