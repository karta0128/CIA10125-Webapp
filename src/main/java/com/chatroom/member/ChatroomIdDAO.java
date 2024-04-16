package com.chatroom.member;

import java.util.Set;

public interface ChatroomIdDAO {
	public void addChatroom(Integer userA, Integer userB);
	public void receiveChatroom();
	public void deleteChatroom(Integer id);
	public Set<ChatroomIdVO> getAllChatroom(Integer user);
	public ChatroomIdVO getOneChatroom(Integer id);
}
