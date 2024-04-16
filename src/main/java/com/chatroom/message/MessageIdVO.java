package com.chatroom.message;

import java.sql.Timestamp;

public class MessageIdVO {
	private Integer messageId;
	private Integer chatroomId;
	private String content;
	private Timestamp date;
	private byte[] img;
	private Integer type;
	public MessageIdVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MessageIdVO(Integer messageId, Integer chatroomId, String content, Timestamp date, byte[] img,
			Integer type) {
		super();
		this.messageId = messageId;
		this.chatroomId = chatroomId;
		this.content = content;
		this.date = date;
		this.img = img;
		this.type = type;
	}
	public Integer getMessageId() {
		return messageId;
	}
	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}
	public Integer getChatroomId() {
		return chatroomId;
	}
	public void setChatroomId(Integer chatroomId) {
		this.chatroomId = chatroomId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public byte[] getImg() {
		return img;
	}
	public void setImg(byte[] img) {
		this.img = img;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
	
}
