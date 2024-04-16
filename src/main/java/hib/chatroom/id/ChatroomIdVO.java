package hib.chatroom.id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="member_chatroom")
public class ChatroomIdVO {
	@Id
	@Column(name = "member_chatroom_id")
	private Integer roomId;
	@Column(name = "member_a_id")
	private Integer memberA;
	@Column(name = "member_b_id")
	private Integer memberB;
	public ChatroomIdVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChatroomIdVO(Integer roomId, Integer memberA, Integer memberB) {
		super();
		this.roomId = roomId;
		this.memberA = memberA;
		this.memberB = memberB;
	}
	public Integer getRoomId() {
		return roomId;
	}
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
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
