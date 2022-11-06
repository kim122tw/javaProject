package Dao.member;

import java.util.List;

import Model.member;

public interface memberDao {
	// Create 新增
	void add(member m);
	
	// Read 查詢
	List<member> queryAll(); // 全部
	member queryMember(String username,String password); // 帳號,密碼
	boolean queryUsername(String username);
	member queryMember(int id);
	
	// Update 修改
	void update(member m);
	
	
	// Delete 刪除
	void delete(int id);
	
}
