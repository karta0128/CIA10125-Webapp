package com.chatroom.member;

public class ChatroomIdVO {
	private Integer chatroomId;
	private Integer memberA;
	private Integer memberB;

	public ChatroomIdVO() {

	}

	public ChatroomIdVO(Integer chatroomId, Integer memberA, Integer memberB) {
		super();
		this.chatroomId = chatroomId;
		this.memberA = memberA;
		this.memberB = memberB;
	}

	public Integer getChatroomId() {
		return chatroomId;
	}

	public void setChatroomId(Integer chatroomId) {
		this.chatroomId = chatroomId;
	}

	public Integer getMemberA() {
		return memberA;
	}

	public void setMemberA(Integer memberA) {
		this.memberA = memberA;
	}

	public Integer getMemberB() {
		return memberB;
	}

	public void setMemberB(Integer memberB) {
		this.memberB = memberB;
	}

}
