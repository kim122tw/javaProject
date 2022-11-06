package Dao.porder;

import java.util.List;

import Model.porder;

public interface porderDao {

	// create 新增
	void add(porder p);
	
	// read 查詢
	List<porder> queryAll();
	List<porder> querySum(int start, int end);
	porder queryPorder(int id);
	
	// update 修改
	void update(porder p);
	
	// delete 刪除
	void delete(int id);
}
