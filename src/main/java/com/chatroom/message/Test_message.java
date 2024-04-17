package com.chatroom.message;


import java.sql.Timestamp;
import java.util.Date;



public class Test_message {

	public static void main(String[] args) {
		//-------發送測試
		
		MessageIdVO mes = new MessageIdVO();
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		
		mes.setChatroomId(1);
		mes.setContent("我很好!!");
		mes.setDate(ts);
		mes.setType(1);
		MessageIdDAOImp midi = new MessageIdDAOImp();
		midi.sendMessage(mes);
		
		
		/*
		MessageIdDAOImp midi2 = new MessageIdDAOImp();
		List<MessageIdVO> list =midi2.getMessage(100000001);
		for(MessageIdVO lists: list) {
			System.out.print("ChatroomID : " + lists.getChatroomId());
			System.out.print("、 Content : " + lists.getContent());
			System.out.print("、 DataTime : " + lists.getTimestamp());
			System.out.println("、 Type : " + lists.getType());
			System.out.println();
		}
		*/
		
//		MessageIdDAOImp midi3 = new MessageIdDAOImp();
//		midi3.
	}

}
