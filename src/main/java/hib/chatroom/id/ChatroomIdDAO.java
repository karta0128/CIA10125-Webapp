package hib.chatroom.id;

import java.util.List;

public interface ChatroomIdDAO {
	int add(ChatroomIdVO id);
	int update(ChatroomIdVO id);
	int delete(ChatroomIdVO id);
	ChatroomIdVO findByPK(Integer roomid);
	List<ChatroomIdVO> getAll(Integer member);
}
