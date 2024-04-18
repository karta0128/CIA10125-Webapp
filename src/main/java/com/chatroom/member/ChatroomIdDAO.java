package com.chatroom.member;

import java.util.List;
import java.util.Set;

public interface ChatroomIdDAO {
	public int addChatroom(Integer userA, Integer userB);
	//public void receiveChatroom();
	public void deleteChatroom(Integer id);
	public Set<ChatroomIdVO> getAllChatroom(Integer user);
	public ChatroomIdVO getOneChatroom(Integer id);
	public List<ChatroomIdVO> getAllRoom();
	public List<ChatroomIdVO> getAll();
}
