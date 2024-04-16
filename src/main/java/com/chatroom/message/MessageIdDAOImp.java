package com.chatroom.message;

import static com.sql.pass.PassworldSQL.PASSWORD;
import static com.sql.pass.PassworldSQL.URL;
import static com.sql.pass.PassworldSQL.USER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.PreparableStatement;

public class MessageIdDAOImp implements MessageIdDAO {
	private static final String SEND_CONTENT = "INSERT INTO mmdf.member_message(member_chatroom_id, message_content, message_date, message_type)"
			+ "VALUE(?,?,?,?);";
	private static final String SEND_IMG = "INSERT INTO mmdf.member_message(member_chatroom_id,message_id, message_img, message_type)"
			+ "VALUE(?,?,?);";
	private static final String GET_MESSAGE = "SELECT * FROM mmdf.member_message WHERE member_chatroom_id= ?";
	private static final String DELETE_MESSAGE = "DELETE FROM member_message WHERE message_id = ?";
	private static final String UPDATE_MESSAGE = "UPDATE FROM mmdf.member_message SET message_content = ? WHERE message_id = ? ;";

	@Override
	public void sendMessage(MessageIdVO message) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			ps = con.prepareStatement(SEND_CONTENT);
			con.setAutoCommit(false);
//			ps.setInt(1, message.getMessageId());
			ps.setInt(1, message.getChatroomId());
			ps.setString(2, message.getContent());
			ps.setTimestamp(3, message.getDate());
			ps.setInt(4, message.getType());
			ps.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<MessageIdVO> getMessage(Integer user) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<MessageIdVO> list = new ArrayList<MessageIdVO>();
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			ps = con.prepareStatement(GET_MESSAGE);
			ps.setInt(1, user);
			rs = ps.executeQuery();
			while (rs.next()) {
				MessageIdVO mes = new MessageIdVO();
				mes.setChatroomId(rs.getInt("member_chatroom_id"));
				mes.setMessageId(rs.getInt("message_id"));
				mes.setContent(rs.getString("message_content"));
				mes.setDate(rs.getTimestamp("message_date"));
				mes.setImg(rs.getBytes("message_img"));
				mes.setType(rs.getInt("message_type"));
				list.add(mes);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public void sendImg(MessageIdVO message) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			ps = con.prepareStatement(SEND_IMG);
			ps.setInt(1, message.getChatroomId());
			ps.setInt(2, message.getMessageId());
			ps.setBytes(3, message.getImg());
			ps.setInt(4, message.getType());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void deleteMessage(Integer id) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			con.setAutoCommit(false);
			ps = con.prepareStatement(DELETE_MESSAGE);
			ps.setInt(1, id);
			ps.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void updateMessage(Integer id, String mes) {
		Connection con = null;
		PreparedStatement ps =null;
		try {
			con = DriverManager.getConnection(URL,USER,PASSWORD);
			ps = con.prepareStatement(UPDATE_MESSAGE);
			ps.setString(1,mes);
			ps.setInt(2, id);
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
