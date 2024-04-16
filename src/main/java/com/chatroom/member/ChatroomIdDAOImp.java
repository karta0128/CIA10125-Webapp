package com.chatroom.member;

import static com.sql.pass.PassworldSQL.PASSWORD;
import static com.sql.pass.PassworldSQL.URL;
import static com.sql.pass.PassworldSQL.USER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ChatroomIdDAOImp implements ChatroomIdDAO {
	private static final String ADD_CHATROOM = "INSERT INTO mmdf.member_chatroom(member_a_id,member_b_id)"
			+ "VALUES(?,?); ";
//	private static final String GET_ALL_CHATROOM = 
//			"SELECT *　FROM member_chatroom WHERE = ? ";
	private static final String MEMBER_CHATROOM = "SELECT * FROM mmdf.member_chatroom "
			+ "WHERE member_a_id = ? || member_b_id =?";
	private static final String IS_EXIST_CHATROOM = "SELECT member_chatroom_id FROM mmdf.member_chatroom "
			+ "WHERE (member_a_id = ? && member_b_id = ? ) || (member_a_id = ? && member_b_id = ?);";
	private static final String GET_MEMBER_ROOM = "SELECT member_a_id, member_b_id FROM mmdf.member_chatroom "
			+ "WHERE member_chatroom_id = ?";
	private static final String DELETE_ROOM = "DELETE FROM mmdf.member_chartoom " + "WHERE member_chatroom_id = ? ;";
	private static final String DELETE_ROOM_MES = "DELETE FROM mmdf.member_message" + "WHERE member_chatroom_id = ?";

	// --------------------自動新增聊天室
	@Override
	public void addChatroom(Integer userA, Integer userB) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Integer qp = null;
//		List<ChatroomIdVO> qp = new ArrayList();
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			ps = con.prepareStatement(IS_EXIST_CHATROOM);
			ps.setInt(1, userA);
			ps.setInt(2, userB);
			ps.setInt(3, userB);
			ps.setInt(4, userA);
			rs = ps.executeQuery();
			while (rs.next()) {
				qp = rs.getInt("member_chatroom_id");
			}
			if (qp == null) {
				ps = null;
				ps = con.prepareStatement(ADD_CHATROOM);
				ps.setInt(1, userA);
				ps.setInt(2, userB);
				ps.executeLargeUpdate();
			} else {
				System.out.println("此聊天室已創建");
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
	}

	// ---------------想要自動跳出聊天室
	@Override
	public void receiveChatroom() {

	}

	// ---------------未定
	@Override
	public void deleteChatroom(Integer id) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			ps = con.prepareStatement(DELETE_ROOM_MES);
			ps.setInt(1, id);
			ps.executeUpdate();
			ps = con.prepareStatement(DELETE_ROOM);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Set<ChatroomIdVO> getAllChatroom(Integer user) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Set<ChatroomIdVO> set = new LinkedHashSet<ChatroomIdVO>();
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			ps = con.prepareStatement(MEMBER_CHATROOM);
			ps.setInt(1, user);
			ps.setInt(2, user);
			rs = ps.executeQuery();
			while (rs.next()) {
				ChatroomIdVO cr = new ChatroomIdVO();
				cr.setChatroomId(rs.getInt("member_chatroom_id"));
				cr.setMemberA(rs.getInt("member_a_id"));
				cr.setMemberB(rs.getInt("member_b_id"));
				set.add(cr);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return set;

	}

	@Override
	public List<ChatroomIdVO> getOneChatroom(Integer id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ChatroomIdVO> list = new ArrayList<ChatroomIdVO>();
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			ps = con.prepareStatement(GET_MEMBER_ROOM);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				ChatroomIdVO cr = new ChatroomIdVO();
				cr.setMemberA(rs.getInt("member_a_id"));
				cr.setMemberB(rs.getInt("member_b_id"));
				list.add(cr);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
