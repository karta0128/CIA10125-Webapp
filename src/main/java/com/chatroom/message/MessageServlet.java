package com.chatroom.message;

import java.util.List;

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
public MessageIdVO addImg(Integer chatroomId, byte[] img, Integer type) {
	MessageIdVO mesVO = new MessageIdVO();
	
	mesVO.setChatroomId(chatroomId);
	mesVO.setImg(img);
	mesVO.setType(type);
	dao.sendImg(mesVO);
	return mesVO;
}
public void updataMes(Integer id, String mes) {
	dao.updateMessage(id, mes);
}
public void deleteMes(Integer id) {
	dao.deleteMessage(id);
}
public List<MessageIdVO> getOneMes(Integer id) {
	return dao.getMessage(id);
}

}
