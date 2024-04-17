package com.chatroom.message;

import java.util.List;

public interface MessageIdDAO {
	public void sendMessage(MessageIdVO message);
	public void deleteMessage(Integer id);
	public List<MessageIdVO> getMessage(String user);
	public void sendImg(MessageIdVO message);
	public void updateMessage(Integer id, String mes);
}
