package com.ktds.pingpong.history.biz;

import com.ktds.pingpong.history.dao.OperationHistoryDAO;
import com.ktds.pingpong.history.vo.OperationHistoryVO;

public class OperationHistoryBiz {

	private OperationHistoryDAO dao;
	
	public OperationHistoryBiz() {
		dao = new OperationHistoryDAO();
	}
	
	public void addHistory(OperationHistoryVO historyVO){
		dao.insertHistory(historyVO);
	}
	
}
