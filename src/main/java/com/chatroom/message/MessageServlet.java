package com.chatroom.message;

public class MessageServlet {
private MessageIdDAO dao;
public MessageServlet() {
	dao = new MessageIdDAOImp();
}
public MessageIdVO addMes(Integer chatroomId, String content,Integer type) {
	MessageIdVO mesVO = new MessageIdVO();
	
	mesVO.setChatroomId(chatroomId);
	mesVO.setContent(content);
	mesVO.setDate(null);
	mesVO.setType(type);
	dao.sendMessage(mesVO);
	return mesVO;
}
public MessageIdVO addImg() {
	return null;
}
public MessageIdVO updataMes() {
	
	return null;
}
public MessageIdVO deleteMes(Integer id) {
	dao.deleteMessage(id);
	return null;
}
public MessageIdVO getOneMes() {
	return null;
}
public MessageIdVO getAll() {
	return null;
}
}
