package hib.chatroom.message;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "member_massage")
public class MessageVO {
	@Id
	@Column(name = "message_id")
	private Integer mesId;
	@Column(name = "member_chatroom_id")
	private Integer chatroomId;
	@Column(name = "message_content")
	private String content;
	@Column(name ="massage_date")
	private Timestamp time;
	@Column(name = "message_img")
	private byte[] img;
	@Column(name = "messaeg_type")
	private Byte type;

	public MessageVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MessageVO(Integer mesId, Integer chatroomId, String content, Timestamp time, byte[] img, Byte type) {
		super();
		this.mesId = mesId;
		this.chatroomId = chatroomId;
		this.content = content;
		this.time = time;
		this.img = img;
		this.type = type;
	}

	public Integer getMesId() {
		return mesId;
	}

	public void setMesId(Integer mesId) {
		this.mesId = mesId;
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

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	public Byte getType() {
		return type;
	}

	public void setType(Byte type) {
		this.type = type;
	}

}
