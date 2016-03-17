package com.ktds.jmj.history.biz;

import com.ktds.jmj.history.dao.OperationHistoryDAO;
import com.ktds.jmj.history.vo.OperationHistoryVO;

public class OperationHistoryBiz {
	
	private OperationHistoryDAO dao;
	
	public OperationHistoryBiz() {
		dao = new OperationHistoryDAO();
	}
	
	public void addHistory(OperationHistoryVO historyVO){
		dao.insertHistory(historyVO);
	}
	
}
